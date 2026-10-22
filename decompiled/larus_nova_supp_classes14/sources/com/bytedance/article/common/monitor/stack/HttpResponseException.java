package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public String getMsg() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpResponseException(int r1, String r2) {
        this.statusCode = r1;
        this.message = r2;
    }
}
