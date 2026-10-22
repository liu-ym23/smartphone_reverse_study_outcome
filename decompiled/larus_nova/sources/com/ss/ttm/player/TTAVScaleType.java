package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class TTAVScaleType {
    public static final int ASPECT_FILL = 3;
    public static final int ASPECT_FILL_X = 1;
    public static final int ASPECT_FILL_Y = 2;
    public static final int ASPECT_FIT = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScaleType {
    }

    public TTAVScaleType() {
    }
}
