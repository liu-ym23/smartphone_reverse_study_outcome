package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ServerResultException extends Exception {
    private int code;
    private String data;
    private String json;
    private String logId;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getJson() {
        return this.json;
    }

    public String getLogId() {
        return this.logId;
    }

    public String getMsg() {
        return this.msg;
    }

    public ServerResultException(int r3, String r4, String r5, String r6, String r7) {
        super("Server result isn't successful. code = " + r3 + ", msg = " + r4);
        this.code = r3;
        this.msg = r4;
        this.data = r5;
        this.json = r6;
        this.logId = r7;
    }
}
