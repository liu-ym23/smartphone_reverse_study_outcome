package com.ss.android.lark.passport.signinsdk_api.account.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes37.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ModuleConfigEnum {
    public static final String MODULE_ACCOUNT_MANAGEMENT = "module_account_management";
    public static final String MODULE_DEVICE_MANAGEMENT = "module_device_management";
    public static final String MODULE_FACE_LOGIN = "module_bio_auth_login";
    public static final String MODULE_FACE_RECOGNITION = "module_bio_auth";
    public static final String MODULE_MODIFY_PWD = "module_modify_pwd";
    public static final String MODULE_SECURITY_VERIFICATION = "module_security_verification";
    public static final String MODULE_TWO_FA = "module_2fa";
}
