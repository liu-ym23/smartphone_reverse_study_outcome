package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DisLinkCode {
    public static final int ENTER_MINOR = 3;
    public static final int LOGOUT = 2;
    public static final int NONE = 0;
    public static final int UNBOND = 1;
}
