package com.bytedance.framwork.core.monitor.internal;

/* JADX INFO: loaded from: classes19.dex */
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public String getMsg() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpResponseException(int r100, String r101) {
        this.statusCode = r100;
        this.message = r101;
    }
}
