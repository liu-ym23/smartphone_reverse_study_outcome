package com.bytedance.dora.camera;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ImageStage {
    public static final int IMAGE_START = 1;
    public static final int TRANS_FINISH = 3;
    public static final int TRANS_START = 2;
}
