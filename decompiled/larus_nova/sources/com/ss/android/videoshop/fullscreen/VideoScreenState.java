package com.ss.android.videoshop.fullscreen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VideoScreenState {
    public static final int ENTERING_FULL = 1;
    public static final int EXITING_FULL = 3;
    public static final int FULL = 2;
    public static final int HALF = 0;
}
