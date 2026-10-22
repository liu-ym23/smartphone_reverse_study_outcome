package com.bytedance.ee.bear.contract;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(DATA r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
