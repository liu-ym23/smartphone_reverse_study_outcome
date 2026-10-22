package com.bytedance.ee.bear.middleground.permission.setting.appsetting;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes18.dex */
@AppConfig(key = RealNameConfig.KEY)
public class RealNameConfig implements NonProguard {
    public static final String KEY = "lark_authn";

    @SerializedName("lark_authn_url_mobile")
    private String feishuAuth;

    @SerializedName("real_name_authn_url")
    private String userRealNameAuth;

    public RealNameConfig() {
        this.feishuAuth = "";
        this.userRealNameAuth = "";
    }

    public String getFeishuAuth() {
        return this.feishuAuth;
    }

    public String getUserRealNameAuth() {
        return this.userRealNameAuth;
    }

    public void setFeishuAuth(String r100) {
        this.feishuAuth = r100;
    }

    public void setUserRealNameAuth(String r100) {
        this.userRealNameAuth = r100;
    }
}
