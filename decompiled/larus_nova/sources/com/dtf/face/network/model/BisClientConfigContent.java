package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class BisClientConfigContent {

    @JSONField(name = "androidcfg")
    private String androidcfg;

    @JSONField(name = "ioscfg")
    private String ioscfg;

    @JSONField(name = "sampleMode")
    private int sampleMode;

    @JSONField(name = "token")
    private String token;

    @JSONField(name = "type")
    private int type;

    public BisClientConfigContent() {
    }

    public String getAndroidcfg() {
        return this.androidcfg;
    }

    public String getIoscfg() {
        return this.ioscfg;
    }

    public int getSampleMode() {
        return this.sampleMode;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setAndroidcfg(String r100) {
        this.androidcfg = r100;
    }

    public void setIoscfg(String r100) {
        this.ioscfg = r100;
    }

    public void setSampleMode(int r100) {
        this.sampleMode = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
