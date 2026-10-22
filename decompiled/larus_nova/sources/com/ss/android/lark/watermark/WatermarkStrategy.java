package com.ss.android.lark.watermark;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface WatermarkStrategy {
    public static final int GLOBAL = 0;
    public static final int PARTIAL = 1;
    public static final int UNKNOWN = -1;
}
