package com.bytedance.ee.bear.middleground.permission.secret.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SecretApprovalResultModel extends Result implements NonProguard {
    private String instance_code;

    public SecretApprovalResultModel() {
    }

    public String getInstance_code() {
        return this.instance_code;
    }

    public void setInstance_code(String r1) {
        this.instance_code = r1;
    }
}
