package com.bytedance.ee.bear.middleground.permission.secret.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SecretApprovalCreateReq implements NonProguard {

    @JSONField(name = "apply_sec_label_id")
    private String apply_sec_label_id;

    @JSONField(name = "approval_code")
    private String approval_code;

    @JSONField(name = "change_reason")
    private String change_reason;

    @JSONField(name = "sec_label_id")
    private String sec_label_id;

    @JSONField(name = ResourceData.KEY_TOKEN)
    private String token;

    @JSONField(name = ResourceData.KEY_TYPE)
    private long type;

    public SecretApprovalCreateReq() {
    }

    public String getApply_sec_label_id() {
        return this.apply_sec_label_id;
    }

    public String getApproval_code() {
        return this.approval_code;
    }

    public String getChange_reason() {
        return this.change_reason;
    }

    public String getSec_label_id() {
        return this.sec_label_id;
    }

    public String getToken() {
        return this.token;
    }

    public long getType() {
        return this.type;
    }

    public void setApply_sec_label_id(String r1) {
        this.apply_sec_label_id = r1;
    }

    public void setApproval_code(String r1) {
        this.approval_code = r1;
    }

    public void setChange_reason(String r1) {
        this.change_reason = r1;
    }

    public void setSec_label_id(String r1) {
        this.sec_label_id = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(long r1) {
        this.type = r1;
    }
}
