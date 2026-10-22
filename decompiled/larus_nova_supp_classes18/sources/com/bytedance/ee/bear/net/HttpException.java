package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HttpException extends Exception {
    private int code;
    private String httpStr;

    public int getCode() {
        return this.code;
    }

    public String getHttpStr() {
        return this.httpStr;
    }

    public HttpException(int r3, String r4) {
        super("Okhttp error, code = " + r3 + ", body = " + r4);
        this.code = r3;
        this.httpStr = r4;
    }
}
