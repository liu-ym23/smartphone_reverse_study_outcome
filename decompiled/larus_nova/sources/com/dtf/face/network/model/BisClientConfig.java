package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class BisClientConfig {

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "sign")
    private String sign;

    public BisClientConfig() {
        this.sign = "";
    }

    public String getContent() {
        return this.content;
    }

    public String getSign() {
        return this.sign;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setSign(String r100) {
        this.sign = r100;
    }
}
