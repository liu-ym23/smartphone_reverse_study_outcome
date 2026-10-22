package com.ss.android.lark.passport.signinsdk_api.contants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes37.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface UserStatus {
    public static final int ENABLED = 0;
    public static final int FORBIDDEN = 1;
    public static final int FROZEN = 2;
    public static final int INACTIVE = 3;
    public static final int PENDING = 5;
    public static final int UNJOIN = 6;
    public static final int UNVERIFIED = 4;
}
