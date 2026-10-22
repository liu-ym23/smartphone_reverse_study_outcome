package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LocalIntentType {
    public static final int EXIT = 3;
    public static final int RECORD_VIDEO = 2;
    public static final int TAKE_PHOTO = 1;
}
