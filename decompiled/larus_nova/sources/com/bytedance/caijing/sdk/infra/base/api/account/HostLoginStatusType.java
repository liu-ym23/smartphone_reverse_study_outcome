package com.bytedance.caijing.sdk.infra.base.api.account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface HostLoginStatusType {
    public static final int ACCOUNT_LOGIN = 1;
    public static final int ACCOUNT_LOGIN_END = 4;
    public static final int ACCOUNT_LOGOUT = 3;
    public static final int ACCOUNT_SWITCH = 2;
    public static final int ACCOUNT_SWITCH_LOGOUT = 5;
}
