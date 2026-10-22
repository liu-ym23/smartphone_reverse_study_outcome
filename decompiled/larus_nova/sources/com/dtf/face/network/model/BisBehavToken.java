package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;

/* JADX INFO: loaded from: classes22.dex */
public class BisBehavToken {

    @JSONField(name = "apdid")
    public String apdid;

    @JSONField(name = "apdidToken")
    public String apdidToken;

    @JSONField(name = "appid")
    public String appid;

    @JSONField(name = "behid")
    public String behid;

    @JSONField(name = "bizid")
    public String bizid;

    @JSONField(name = "sampleMode")
    public int sampleMode;

    @JSONField(name = "token")
    public String token;

    @JSONField(name = "type")
    public int type;

    @JSONField(name = "uid")
    public String uid;

    @JSONField(name = DyVerifyEventConstants.EventParam.VERIFY_ID)
    public String verifyid;

    @JSONField(name = "vtoken")
    public String vtoken;

    public BisBehavToken() {
        this.type = 0;
        this.sampleMode = 0;
        this.verifyid = "";
        this.vtoken = "";
        this.apdidToken = "";
    }

    public String getApdid() {
        return this.apdid;
    }

    public String getApdidToken() {
        return this.apdidToken;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getBehid() {
        return this.behid;
    }

    public String getBizid() {
        return this.bizid;
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

    public String getUid() {
        return this.uid;
    }

    public String getVerifyid() {
        return this.verifyid;
    }

    public String getVtoken() {
        return this.vtoken;
    }

    public void setApdid(String r100) {
        this.apdid = r100;
    }

    public void setApdidToken(String r100) {
        this.apdidToken = r100;
    }

    public void setAppid(String r100) {
        this.appid = r100;
    }

    public void setBehid(String r100) {
        this.behid = r100;
    }

    public void setBizid(String r100) {
        this.bizid = r100;
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

    public void setUid(String r100) {
        this.uid = r100;
    }

    public void setVerifyid(String r100) {
        this.verifyid = r100;
    }

    public void setVtoken(String r100) {
        this.vtoken = r100;
    }
}
