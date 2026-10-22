package com.ttnetuploader.uploader.net;

import com.ttnetuploader.uploader.api.ULMultipartPart;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public interface INetRequest {
    public static final int BUFF_SIZE_MAX = 8192;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_POST = 2;
    public static final int HTTP_METHOD_PUT = 3;

    INetResponse httpGetRequest(String r100, SliceConfig r101, Map<String, String> r102, int r103) throws Exception;

    INetResponse httpPostDataRequest(String r100, SliceConfig r101, Map<String, String> r102, InputStream r103) throws Exception;

    INetResponse httpPostMultipartRequest(String r100, SliceConfig r101, Map<String, String> r102, Map<String, ULMultipartPart> r103) throws Exception;

    INetResponse httpPostRequest(String r100, SliceConfig r101, Map<String, String> r102, String r103, int r104) throws Exception;

    INetResponse httpPutDataRequest(String r100, SliceConfig r101, Map<String, String> r102, InputStream r103) throws Exception;

    void suspend();
}
