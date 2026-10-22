package com.bytedance.fresco.animatedheif;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;

/* JADX INFO: loaded from: classes19.dex */
public class HeifFrame implements AnimatedImageFrame {
    private boolean mIsSeekDecode;
    private long mNativeContext;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(boolean r100, int r101, int r102, Bitmap r103);

    private native void nativeRenderFrameNew(int r100, int r101, Bitmap r102);

    private native boolean nativeShouldDisposeToBackgroundColor();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getDurationMs() {
        return nativeGetDurationMs();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getXOffset() {
        return nativeGetXOffset();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getYOffset() {
        return nativeGetYOffset();
    }

    public boolean isBlendWithPreviousFrame() {
        return nativeIsBlendWithPreviousFrame();
    }

    public boolean shouldDisposeToBackgroundColor() {
        return nativeShouldDisposeToBackgroundColor();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    public HeifFrame(long r100) {
        this.mNativeContext = r100;
        this.mIsSeekDecode = false;
    }

    public HeifFrame(long r100, boolean r101) {
        this.mNativeContext = r100;
        this.mIsSeekDecode = r101;
    }

    private void nativeRenderFrame(int r100, int r101, Bitmap r102) {
        nativeRenderFrame(FrescoCacheMonitorUtil.getTTHeifAnimDecOpt(), r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void renderFrame(int r100, int r101, Bitmap r102) {
        if (this.mIsSeekDecode == false) goto L5;
        nativeRenderFrameNew(r100, r101, r102);
        return;
    L5:
        nativeRenderFrame(r100, r101, r102);
    }
}
