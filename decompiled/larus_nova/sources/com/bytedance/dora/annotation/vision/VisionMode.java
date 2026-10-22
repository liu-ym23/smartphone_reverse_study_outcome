package com.bytedance.dora.annotation.vision;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VisionMode {
    public static final int KWS_INTENTION = 8;
    public static final int LIVE = 2;
    public static final int LLM_INTENTION = 7;
    public static final int UNKNOWN = 0;
}
