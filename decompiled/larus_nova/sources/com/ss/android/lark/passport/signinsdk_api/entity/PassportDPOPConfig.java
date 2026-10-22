package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "passport_dpop_config")
public class PassportDPOPConfig {

    @SerializedName("log_rate")
    public double logRate;

    @SerializedName("token_expire_ms")
    public int tokenExpMs;

    public PassportDPOPConfig() {
        this.logRate = 0.01d;
        this.tokenExpMs = 5000;
    }
}
