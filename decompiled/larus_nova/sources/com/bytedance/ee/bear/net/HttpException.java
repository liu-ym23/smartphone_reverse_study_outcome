package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: classes18.dex */
public class HttpException extends Exception {
    private int code;
    private String httpStr;

    public int getCode() {
        return this.code;
    }

    public String getHttpStr() {
        return this.httpStr;
    }

    public HttpException(int r100, String r101) {
        super("Okhttp error, code = " + r100 + ", body = " + r101);
        this.code = r100;
        this.httpStr = r101;
    }
}
