package com.ttnetuploader.uploader.request_protocol;

import android.content.Context;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class UploaderRequest {
    public static final String CONTENT_LEN = "Content-Length";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String CONTENT_TYPE_STREAM = "application/octet-stream";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";

    public UploaderRequest() {
    }

    public static Map<String, String> getKeepAliveHeaders() {
        return UploaderRequestLan.getKeepAliveHeaders();
    }

    public static String getCompletedMethod(int r100) {
        return (String) getRealClass(r100, "getCompletedMethod", new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "POST";
    }

    public static String getPostDataMethod(int r100) {
        return (String) getRealClass(r100, "getPostDataMethod", new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "POST";
    }

    public static String getQueryMethod(int r100) {
        return (String) getRealClass(r100, "getQueryMethod", new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static Map<String, String> getCompletedHeaders(int r100, SliceConfig r101) {
        return (Map) getRealClass(r100, "getCompletedHeaders", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return new HashMap();
    }

    public static String getCompletedMsgBody(int r100, SliceConfig r101) {
        return (String) getRealClass(r100, "getCompletedMsgBody", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getCompletedMsgUrl(int r100, SliceConfig r101) {
        return (String) getRealClass(r100, "getCompletedMsgUrl", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static Map<String, String> getPostDataHeaders(int r100, SliceConfig r101) {
        return (Map) getRealClass(r100, "getPostDataHeaders", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return new HashMap();
    }

    public static String getPostDataUrl(int r100, SliceConfig r101) {
        return (String) getRealClass(r100, "getPostDataUrl", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getQueryBody(int r100, SliceConfig r101) {
        return (String) getRealClass(r100, "getQueryBody", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getQueryUrl(int r100, SliceConfig r101) {
        return (String) getRealClass(r100, "getQueryUrl", new Class[]{SliceConfig.class}).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getKeepAliveUrl(String r100, int r101, boolean r102) {
        return UploaderRequestLan.getKeepAliveUrl(r100, r101, r102);
    }

    public static Map<String, String> getQueryHeaders(int r100, SliceConfig r101, Context r102) {
        return (Map) getRealClass(r100, "getQueryHeaders", new Class[]{SliceConfig.class, Context.class}).invoke(null, new Object[]{r101, r102});
    L4:
        e = move-exception;
        e.printStackTrace();
        return new HashMap();
    }

    private static Method getRealClass(int r100, String r101, Class<?>... r102) {
        if (r100 != 1) goto L8;
        Class r103 = UploaderRequestLan.class;
    L15:
        return r103.getMethod(r101, r102);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        if (r100 != 2) goto L10;
        r103 = UploaderRequestAliyun.class;
        goto L15
    L10:
        r103 = null;
        goto L15
    }
}
