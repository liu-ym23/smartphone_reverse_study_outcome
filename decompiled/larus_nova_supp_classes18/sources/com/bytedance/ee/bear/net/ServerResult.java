package com.bytedance.ee.bear.net;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
