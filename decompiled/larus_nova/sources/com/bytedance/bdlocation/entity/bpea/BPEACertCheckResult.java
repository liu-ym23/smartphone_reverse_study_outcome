package com.bytedance.bdlocation.entity.bpea;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BPEACertCheckResult {
    private int code;
    private String msg;
    private JSONObject params;

    public BPEACertCheckResult() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setParams(JSONObject r100) {
        this.params = r100;
    }
}
