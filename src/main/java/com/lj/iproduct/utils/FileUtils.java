package com.lj.iproduct.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static String fileUpload(MultipartFile File){
		
		        //文件源文件名
				String fileName = new Date().getTime()+File.getOriginalFilename();
				System.out.println("源文件名------>"+fileName);
				//文件上传路径
				String filePath = "E:/images/";
				System.out.println("文件上传路径------->"+ filePath);
				File file = new File(filePath);
				if(!file.exists()){
					//如果文件不存在，就创建该文件夹
				 file.mkdirs();	
				}
				
				try {
					//将上传文件内容通过I/O流写入到新文件
					FileOutputStream out = new FileOutputStream(filePath+fileName);
					out.write(File.getBytes());
					out.flush();
					out.close();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
				
				return "http://localhost:8088/images/"+fileName;
	}
	
}
