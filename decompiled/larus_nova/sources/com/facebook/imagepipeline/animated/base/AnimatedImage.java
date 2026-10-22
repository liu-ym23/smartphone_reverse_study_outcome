package com.facebook.imagepipeline.animated.base;

import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedImage {
    public static final int LOOP_COUNT_INFINITE = 0;

    AnimatedImage cloneOrNull();

    void dispose();

    boolean doesRenderSupportScaling();

    int getDecodeStatus();

    int getDuration();

    AnimatedImageFrame getFrame(int r100);

    int getFrameCount();

    int[] getFrameDurations();

    AnimatedDrawableFrameInfo getFrameInfo(int r100);

    AnimatedImageFrame getFrameNew(int r100);

    int getHeight();

    ImageFormat getImageFormat();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
