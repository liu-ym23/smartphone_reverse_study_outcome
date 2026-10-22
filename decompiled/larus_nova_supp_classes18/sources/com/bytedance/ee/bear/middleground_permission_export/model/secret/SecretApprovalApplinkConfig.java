package com.bytedance.ee.bear.middleground_permission_export.model.secret;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = "approve_record_process_url")
public class SecretApprovalApplinkConfig implements NonProguard {
    private String approve_record_process_url;

    public SecretApprovalApplinkConfig() {
    }

    public String getApprove_record_process_url() {
        return this.approve_record_process_url;
    }

    public void setApprove_record_process_url(String r1) {
        this.approve_record_process_url = r1;
    }
}
