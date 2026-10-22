package com.ss.android.lark.audit;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes34.dex */
@AppConfig(key = "lark_authz_audit_config")
public class LarkAuditSettingConfig {

    @SerializedName("authz_retry")
    public boolean authzRetry;

    @SerializedName("authz_retry_count")
    public int authzRetryCount;

    @SerializedName("authz_retry_delay")
    public int authzRetryDelay;

    public LarkAuditSettingConfig() {
        this.authzRetryCount = 2;
        this.authzRetryDelay = 5000;
        this.authzRetry = true;
    }
}
