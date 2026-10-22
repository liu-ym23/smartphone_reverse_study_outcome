package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PromptType {
    public static final int CHANGE_MIC = 1;
    public static final int NETWORK_ERR = 2;
    public static final int SHUTTER = 3;
}
