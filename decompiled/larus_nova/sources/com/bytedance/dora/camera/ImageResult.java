package com.bytedance.dora.camera;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ImageResult {
    public static final int ROLE_SWITCH_FAIL = 2;
    public static final int ROLE_SWITCH_TIMEOUT = 8;
    public static final int SHA256_ERROR = 11;
    public static final int SUCCESS = 1;
    public static final int TRANS_FAIL = 10;
    public static final int TRANS_TIMEOUT = 9;
}
