package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import ff7.b;
import ff7.g;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IHttpService extends IService {
    g buildMultipartUpload(String r1, String r2, boolean r3) throws Exception;

    g buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) throws Exception;

    b doGet(String r1, Map<String, String> r2) throws Exception;

    b doPost(String r1, byte[] r2, Map<String, String> r3) throws Exception;

    b uploadFiles(String r1, List<File> r2, Map<String, String> r3) throws Exception;
}
