package com.bytedance.caijing.sdk.infra.base.api.account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface HostLoginResult {
    public static final int CANCEL = -2;
    public static final int FAIL = -1;
    public static final int SUCCESS = 0;
}
