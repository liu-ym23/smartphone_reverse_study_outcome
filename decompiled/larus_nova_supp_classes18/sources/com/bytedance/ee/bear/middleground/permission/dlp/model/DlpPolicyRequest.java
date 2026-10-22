package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DlpPolicyRequest implements NonProguard {

    @JSONField(name = "entityType")
    private String entityType;

    @JSONField(name = "policyType")
    private String policyType;

    @JSONField(name = ResourceData.KEY_TOKEN)
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

    public void setEntityType(String r1) {
        this.entityType = r1;
    }

    public void setPolicyType(String r1) {
        this.policyType = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
