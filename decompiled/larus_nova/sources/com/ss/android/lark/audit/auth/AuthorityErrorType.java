package com.ss.android.lark.audit.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AuthorityErrorType {
    public static final int NetworkError = 1;
    public static final int NoError = 0;
    public static final int RequestFailed = 3;
    public static final int RequestTimeout = 2;
}
