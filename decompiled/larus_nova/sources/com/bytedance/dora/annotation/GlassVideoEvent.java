package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface GlassVideoEvent {
    public static final int LAST_VIDEO = 2;
    public static final int NOT_ON_VIDEO = 0;
    public static final int ON_VIDEO = 1;
    public static final int UNKNOWN = -1;
}
