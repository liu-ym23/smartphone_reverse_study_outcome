package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public class TokenResult extends Result {

    @Packed
    private String belongId;

    @Packed
    private int retCode;

    @Packed
    private String token;

    public TokenResult() {
        this.token = "";
        this.retCode = 0;
    }

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setBelongId(String r100) {
        this.belongId = r100;
    }

    public void setRetCode(int r100) {
        this.retCode = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
