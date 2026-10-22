package com.bytedance.ee.bear.middleground.permission.secret.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SecretApprovalCreateReq implements NonProguard {

    @JSONField(name = "apply_sec_label_id")
    private String apply_sec_label_id;

    @JSONField(name = "approval_code")
    private String approval_code;

    @JSONField(name = "change_reason")
    private String change_reason;

    @JSONField(name = "sec_label_id")
    private String sec_label_id;

    @JSONField(name = "token")
    private String token;

    @JSONField(name = "type")
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

    public void setApply_sec_label_id(String r100) {
        this.apply_sec_label_id = r100;
    }

    public void setApproval_code(String r100) {
        this.approval_code = r100;
    }

    public void setChange_reason(String r100) {
        this.change_reason = r100;
    }

    public void setSec_label_id(String r100) {
        this.sec_label_id = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(long r100) {
        this.type = r100;
    }
}
