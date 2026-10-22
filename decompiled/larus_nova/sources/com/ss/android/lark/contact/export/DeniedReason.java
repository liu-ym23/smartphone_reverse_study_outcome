package com.ss.android.lark.contact.export;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DeniedReason {
    public static final int BE_BLOCKED = 1;
    public static final int BLOCKED = 5;
    public static final int CROSS_TENANT_DENY = 2;
    public static final int CRYPTO_CHAT_DENY = 4;
    public static final int EXTERNAL_COORDINATE_CTL = 10;
    public static final int NO_FRIENDSHIP = 6;
    public static final int PRIVACY_SETTING = 7;
    public static final int SAME_TENANT_DENY = 3;
    public static final int TARGET_EXTERNAL_COORDINATE_CTL = 11;
    public static final int TARGET_PRIVACY_SETTING = 8;
    public static final int UNKNOWN_REASON = 0;
}
