package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface GlassEnvState {
    public static final int READY = 1;
    public static final int UNKNOWN = -1;
    public static final int UNREADY = 2;
}
