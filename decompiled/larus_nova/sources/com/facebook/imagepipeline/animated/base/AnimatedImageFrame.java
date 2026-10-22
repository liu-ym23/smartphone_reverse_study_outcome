package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedImageFrame {
    void dispose();

    int getDurationMs();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int r100, int r101, Bitmap r102);
}
