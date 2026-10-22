package com.bytedance.ee.bear.net;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class ServerResult implements Serializable {
    public int code;
    public String data;
    public String msg;

    public ServerResult() {
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }
}
