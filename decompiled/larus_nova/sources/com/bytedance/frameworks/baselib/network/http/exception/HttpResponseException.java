package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String errorResponse;
    private final int statusCode;

    public String getErrorResponse() {
        return this.errorResponse;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public static String getPathFromHttpURLConnection(HttpURLConnection r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.getURL() != null) goto L6;
        return "";
    L6:
        if (r100.getURL().getPath() != null) goto L8;
        return "";
    L8:
        return r100.getURL().getPath();
    }

    public static String getPathFromOk3Request(Request r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.url() != null) goto L6;
        return "";
    L6:
        return r100.url().url().getPath();
    }

    public static String getPathFromUrlString(String r100) {
        URI r101 = UrlUtils.safeCreateUri(r100);
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getPath();
    }

    public HttpResponseException(int r100, String r101) {
        super(r101);
        this.statusCode = r100;
        this.errorResponse = null;
    }

    public HttpResponseException(int r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.append(r101);
        r103.append(" ");
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r103.append(r102);
        super(r103.toString());
        this.statusCode = r100;
        this.errorResponse = null;
    }

    public HttpResponseException(int r100, String r101, String r102, String r103) {
        StringBuilder r104 = new StringBuilder();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r104.append(r101);
        r104.append(" ");
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r104.append(r102);
        super(r104.toString());
        this.statusCode = r100;
        this.errorResponse = r103;
    }
}
