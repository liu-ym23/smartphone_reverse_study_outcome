package com.bytedance.fresco.animatedheif;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.BaseAnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imageutils.HeifFormatUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes19.dex */
public class HeifImage extends BaseAnimatedImage implements AnimatedImageDecoder {
    private boolean isSeekDecode;
    private int lastFrameNum;
    private long mNativeContext;

    private native HeifImage nativeCloneHeifImage();

    private static native HeifImage nativeCreateFromDirectByteBuffer(ByteBuffer r100);

    private static native HeifImage nativeCreateFromNativeMemory(long r100, int r101);

    private static native HeifImage nativeCreateFromNativeMemory(long r100, int r101, boolean r102, int r103);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native HeifFrame nativeGetFrame(int r100);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native HeifFrame nativeGetFrameNew(int r100);

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    public HeifImage() {
        this.lastFrameNum = -1;
    }

    @Override // com.facebook.imagepipeline.animated.base.BaseAnimatedImage, com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedImage cloneOrNull() {
        return nativeCloneHeifImage();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDuration() {
        return nativeGetDuration();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public ImageFormat getImageFormat() {
        return HeifFormatUtil.getHeifFormatAnimated();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        return nativeGetLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    public HeifImage(long r100) {
        this.lastFrameNum = -1;
        this.mNativeContext = r100;
    }

    public static HeifImage create(byte[] r100) {
        Preconditions.checkNotNull(r100);
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length);
        r101.put(r100);
        r101.rewind();
        return nativeCreateFromDirectByteBuffer(r101);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(ByteBuffer r100) {
        return create(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public HeifFrame getFrame(int r100) {
        return nativeGetFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int r110) {
        HeifFrame r100 = getFrame(r110);
        int r101 = r100.getXOffset();     // Catch: Throwable -> L14
        int r102 = r100.getYOffset();     // Catch: Throwable -> L14
        int r103 = r100.getWidth();     // Catch: Throwable -> L14
        int r104 = r100.getHeight();     // Catch: Throwable -> L14
        if (r100.isBlendWithPreviousFrame() == false) goto L6;
        AnimatedDrawableFrameInfo.BlendOperation r105 = AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS;     // Catch: Throwable -> L14
    L7:
        AnimatedDrawableFrameInfo.BlendOperation r106 = r105;
        if (r100.shouldDisposeToBackgroundColor() == false) goto L10;
        AnimatedDrawableFrameInfo.DisposalMethod r107 = AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;     // Catch: Throwable -> L14
    L11:
        AnimatedDrawableFrameInfo r108 = new AnimatedDrawableFrameInfo(r110, r101, r102, r103, r104, r106, r107);     // Catch: Throwable -> L14
        r100.dispose();
        return r108;
    L10:
        r107 = AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;     // Catch: Throwable -> L14
        goto L11
    L6:
        r105 = AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r100.dispose();
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public HeifFrame getFrameNew(int r100) {
        if (r100 == (this.lastFrameNum + 1)) goto L5;
        this.isSeekDecode = true;
        return nativeGetFrameNew(r100);
    L5:
        if (r100 != (getFrameCount() - 1)) goto L7;
        int r101 = -1;
    L8:
        this.lastFrameNum = r101;
        this.isSeekDecode = false;
        return nativeGetFrame(r100);
    L7:
        r101 = r100;
        goto L8
    }

    public static HeifImage create(ByteBuffer r100) {
        r100.rewind();
        return nativeCreateFromDirectByteBuffer(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public /* bridge */ /* synthetic */ AnimatedImageFrame getFrame(int r100) {
        return getFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public /* bridge */ /* synthetic */ AnimatedImageFrame getFrameNew(int r100) {
        return getFrameNew(r100);
    }

    public static HeifImage create(long r100, int r101) {
        if (r100 == 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        return nativeCreateFromNativeMemory(r100, r101, FrescoCacheMonitorUtil.isHeifUseWpp(), FrescoCacheMonitorUtil.getHeifDecodeThreads());
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(long r100, int r101) {
        return create(r100, r101);
    }
}
