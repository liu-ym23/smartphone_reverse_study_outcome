package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import ff7.b;
import ff7.g;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpService extends IService {
    g buildMultipartUpload(String r100, String r101, boolean r102) throws Exception;

    g buildMultipartUpload(String r100, String r101, boolean r102, Map<String, String> r103) throws Exception;

    b doGet(String r100, Map<String, String> r101) throws Exception;

    b doPost(String r100, byte[] r101, Map<String, String> r102) throws Exception;

    b uploadFiles(String r100, List<File> r101, Map<String, String> r102) throws Exception;
}
