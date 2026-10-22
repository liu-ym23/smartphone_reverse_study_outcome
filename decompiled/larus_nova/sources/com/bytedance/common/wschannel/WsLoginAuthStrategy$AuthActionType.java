package com.bytedance.common.wschannel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface WsLoginAuthStrategy$AuthActionType {
    public static final int DELETE = 2;
    public static final int INSERT = 1;
    public static final int UNKNOWN = 0;
}
