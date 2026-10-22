package com.bytedance.caijing.sdk.biz.pay.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PayCode {
    public static final int CANCEL = 1;
    public static final int FAIL = 2;
    public static final int FAIL_NET_ERROR = -10;
    public static final int FAIL_SERVER = -100;
    public static final int PROCESSING = 3;
    public static final int SUCCESS = 0;
}
