package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedTempBitmapFactory {
    public static final int DRAW_DECODE_FRAME = 2;
    public static final int PRE_DECODE_FRAME = 1;

    Bitmap createBitmap(int r100, int r101, Bitmap.Config r102, int r103);
}
