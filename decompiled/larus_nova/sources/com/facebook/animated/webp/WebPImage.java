package com.facebook.animated.webp;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.BaseAnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes22.dex */
public class WebPImage extends BaseAnimatedImage implements AnimatedImageDecoder {
    private long mNativeContext;

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer r100);

    private static native WebPImage nativeCreateFromNativeMemory(long r100, int r101);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int r100);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
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

    public WebPImage() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public ImageFormat getImageFormat() {
        return DefaultImageFormats.WEBP_ANIMATED;
    }

    public WebPImage(long r100) {
        this.mNativeContext = r100;
    }

    public static WebPImage create(byte[] r100) {
        StaticWebpNativeLoader.ensure();
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
    public WebPFrame getFrame(int r100) {
        return nativeGetFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int r110) {
        WebPFrame r100 = getFrame(r110);
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
    public WebPFrame getFrameNew(int r100) {
        return nativeGetFrame(r100);
    }

    public static WebPImage create(ByteBuffer r100) {
        StaticWebpNativeLoader.ensure();
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

    public static WebPImage create(long r100, int r101) {
        StaticWebpNativeLoader.ensure();
        if (r100 == 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        return nativeCreateFromNativeMemory(r100, r101);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(long r100, int r101) {
        return create(r100, r101);
    }
}
