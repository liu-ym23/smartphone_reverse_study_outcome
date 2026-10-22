package com.facebook.animated.gif;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.BaseAnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imageutils.FrescoSoLoader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes22.dex */
public class GifImage extends BaseAnimatedImage implements AnimatedImageDecoder {
    private static final int LOOP_COUNT_FOREVER = 0;
    private static final int LOOP_COUNT_MISSING = -1;
    private static final int MAX_ALLOWED_DIMENSION = 65534;
    private static int defaultMaxAllowedDimension = 65534;
    private static volatile boolean sInitialized;
    private long mNativeContext;

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer r100, int r101, boolean r102);

    private static native GifImage nativeCreateFromFileDescriptor(int r100, int r101, boolean r102);

    private static native GifImage nativeCreateFromNativeMemory(long r100, int r101, int r102, boolean r103);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int r100);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    private native boolean nativeIsAnimated();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    private static synchronized void ensure() {
        monitor-enter(GifImage.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInitialized == true) goto L7;
        sInitialized = true;     // Catch: Throwable -> L9
        FrescoSoLoader.loadLibrary("gifimage");     // Catch: Throwable -> L9
    L7:
        monitor-exit(GifImage.class);
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
        int r100 = nativeGetLoopCount();
        if (r100 == (-1)) goto L9;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return r100 + 1;
    L9:
        return 1;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    public boolean isAnimated() {
        return nativeIsAnimated();
    }

    public GifImage() {
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
        return DefaultImageFormats.GIF;
    }

    public GifImage(long r100) {
        this.mNativeContext = r100;
    }

    public static GifImage createFromByteArray(byte[] r100) {
        Preconditions.checkNotNull(r100);
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length);
        r101.put(r100);
        r101.rewind();
        return createFromByteBuffer(r101, ImageDecodeOptions.defaults());
    }

    public static GifImage createFromByteBuffer(ByteBuffer r100) {
        return createFromByteBuffer(r100, ImageDecodeOptions.defaults());
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int r100) {
        if (r100 != 0) goto L6;
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    L6:
        if (r100 != 1) goto L10;
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    L10:
        if (r100 != 2) goto L14;
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
    L14:
        if (r100 != 3) goto L18;
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
    L18:
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }

    public static void setDefaultMaxAllowedDimension(int r100) {
        defaultMaxAllowedDimension = r100;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(ByteBuffer r100) {
        return createFromByteBuffer(r100, null);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public GifFrame getFrame(int r100) {
        return nativeGetFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int r110) {
        GifFrame r100 = getFrame(r110);
        AnimatedDrawableFrameInfo r101 = new AnimatedDrawableFrameInfo(r110, r100.getXOffset(), r100.getYOffset(), r100.getWidth(), r100.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(r100.getDisposalMode()));     // Catch: Throwable -> L6
        r100.dispose();
        return r101;
    L6:
        th = move-exception;
        r100.dispose();
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public GifFrame getFrameNew(int r100) {
        return nativeGetFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public /* bridge */ /* synthetic */ AnimatedImageFrame getFrame(int r100) {
        return getFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public /* bridge */ /* synthetic */ AnimatedImageFrame getFrameNew(int r100) {
        return getFrameNew(r100);
    }

    public static GifImage createFromByteBuffer(ByteBuffer r100, ImageDecodeOptions r101) {
        ensure();
        r100.rewind();
        return nativeCreateFromDirectByteBuffer(r100, Integer.MAX_VALUE, false);
    }

    public static GifImage createFromFileDescriptor(int r100, ImageDecodeOptions r101) {
        ensure();
        return nativeCreateFromFileDescriptor(r100, Integer.MAX_VALUE, false);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(long r100, int r101) {
        return createFromNativeMemory(r100, r101, null);
    }

    public static GifImage createFromNativeMemory(long r100, int r101, ImageDecodeOptions r102) {
        ensure();
        if (r100 == 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        return nativeCreateFromNativeMemory(r100, r101, defaultMaxAllowedDimension, false);
    L5:
        r103 = false;
        goto L6
    }
}
