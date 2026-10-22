package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: classes18.dex */
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

    public ServerResultException(int r100, String r101, String r102, String r103, String r104) {
        super("Server result isn't successful. code = " + r100 + ", msg = " + r101);
        this.code = r100;
        this.msg = r101;
        this.data = r102;
        this.json = r103;
        this.logId = r104;
    }
}
