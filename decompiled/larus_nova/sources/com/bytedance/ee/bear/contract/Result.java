package com.bytedance.ee.bear.contract;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class Result<DATA extends Serializable> implements Serializable {
    public static final int SUCCESS_CODE = 0;
    public int code;
    public DATA data;
    public String msg;

    public Result() {
    }

    public int getCode() {
        return this.code;
    }

    public DATA getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(DATA r100) {
        this.data = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }
}
