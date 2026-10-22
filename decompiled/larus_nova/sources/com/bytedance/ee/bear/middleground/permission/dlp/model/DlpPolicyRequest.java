package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class DlpPolicyRequest implements NonProguard {

    @JSONField(name = "entityType")
    private String entityType;

    @JSONField(name = "policyType")
    private String policyType;

    @JSONField(name = "token")
    private String token;

    public DlpPolicyRequest() {
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public String getToken() {
        return this.token;
    }

    public void setEntityType(String r100) {
        this.entityType = r100;
    }

    public void setPolicyType(String r100) {
        this.policyType = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
