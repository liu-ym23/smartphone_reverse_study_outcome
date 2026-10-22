package com.ss.android.lark.audit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AuthorizationManager$CheckResult {
    public static final int ALLOW = 2;
    public static final int DENY = 1;
    public static final int ERROR = 4;
    public static final int NULL = 3;
    public static final int UNKNOWN = 0;
}
