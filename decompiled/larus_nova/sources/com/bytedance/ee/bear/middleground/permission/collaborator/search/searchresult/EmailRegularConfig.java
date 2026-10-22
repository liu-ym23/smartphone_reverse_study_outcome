package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes18.dex */
@AppConfig(key = EmailRegularConfig.KEY)
public class EmailRegularConfig implements NonProguard {
    public static final String KEY = "email_validate_regular";
    private static final String TAG = "EmailRegularConfig";
    private String email_reg;

    public EmailRegularConfig() {
    }

    public String toString() {
        return "EmailRegularConfig{email_reg='" + this.email_reg + "'}";
    }

    public String getEmail_reg() {
        return this.email_reg;
    }

    public void setEmail_reg(String r100) {
        this.email_reg = r100;
    }
}
