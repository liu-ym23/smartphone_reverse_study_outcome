package com.bytedance.vmsdk.net;

import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Response {
    private final String TAG;
    private final byte[] body;
    private ReadableMap headers;
    private final String mimeType;
    private final int status;
    private final String url;

    private static native long nativeCreateResponse(Response r100);

    public byte[] getBodyBytes() {
        return this.body;
    }

    public ReadableMap getHeaders() {
        return this.headers;
    }

    public int getStatusCode() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] getBodyBytesInternal(InputStream r100) {
        byte[] r101 = new byte[1024];
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: IOException -> L10
    L4:
        int r103 = r100.read(r101, 0, 1024);     // Catch: IOException -> L10
        if (r103 <= 0) goto L7;
        r102.write(r101, 0, r103);     // Catch: IOException -> L10
    L7:
        if (r103 > 0) goto L4;
        return r102.toByteArray();
    L10:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public Response(String r100, int r101, Map r102, InputStream r103, String r104) {
        this.TAG = SOAP.RESPONSE;
        if (r100 == null) goto L14;
        if (r101 < 200) goto L12;
        this.url = r100;
        this.status = r101;
        this.mimeType = r104;
        this.headers = JavaOnlyMap.from(r102);
        if (r103 != null) goto L9;
        this.body = null;
        return;
    L9:
        this.body = getBodyBytesInternal(r103);
        return;
    L12:
        throw new IllegalArgumentException("Invalid status code: " + r101);
    L14:
        throw new IllegalArgumentException("url == null");
    }
}
