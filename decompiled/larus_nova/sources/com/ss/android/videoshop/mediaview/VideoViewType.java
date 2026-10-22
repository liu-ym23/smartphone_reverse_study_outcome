package com.ss.android.videoshop.mediaview;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VideoViewType {
    public static final int SurfaceUseSetSurface = 2;
    public static final int SurfaceUseSetSurfaceHolder = 1;
    public static final int Texture = 0;
}
