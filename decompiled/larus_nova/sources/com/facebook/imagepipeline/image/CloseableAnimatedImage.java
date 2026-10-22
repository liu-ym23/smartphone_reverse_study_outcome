package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class CloseableAnimatedImage extends CloseableImage {
    private AnimatedImageResult mImageResult;
    private final ImageDecodeOptions mOptions;

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
        AnimatedImageResult r100 = this.mImageResult;     // Catch: Throwable -> L11
        if (r100 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.mImageResult = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r100.dispose();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r100 = 0;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.mImageResult.getImage().getHeight();     // Catch: Throwable -> L9
        goto L7
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        AnimatedImage r100 = null;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.mImageResult.getImage();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getImageCount() {
        monitor-enter(this);
        int r100 = this.mImageResult.getImage().getFrameCount();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AnimatedImageResult getImageResult() {
        monitor-enter(this);
        AnimatedImageResult r100 = this.mImageResult;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized int getSizeInBytes() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r100 = 0;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.mImageResult.getImage().getSizeInBytes();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r100 = 0;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = this.mImageResult.getImage().getWidth();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.mImageResult != null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return true;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public String getSourceUri() {
        AnimatedImageResult r100 = this.mImageResult;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSourceUri();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public CloseableImage cloneOrNull() {
        AnimatedImage r100 = getImage();
        if (r100 != null) goto L5;
        return null;
    L5:
        AnimatedImage r101 = r100.cloneOrNull();
        if (r101 != null) goto L9;
        return null;
    L9:
        return getCloseableImage(this.mOptions, r101, getImageFormat());
    }

    public ImageDecodeOptions getOptions() {
        return this.mOptions;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public void setSourceUri(String r100) {
        AnimatedImageResult r101 = this.mImageResult;
        if (r101 == null) goto L6;
        r101.setSourceUri(r100);
        return;
    }

    public CloseableAnimatedImage(AnimatedImageResult r100, ImageDecodeOptions r101) {
        this.mImageResult = r100;
        this.mOptions = r101;
    }

    public CloseableAnimatedImage(AnimatedImageResult r100, ImageDecodeOptions r101, ImageFormat r102) {
        this.mImageResult = r100;
        this.mOptions = r101;
        this.mImageFormat = r102;
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions r100, AnimatedImage r101, ImageFormat r102) {
        AnimatedImageResult r103 = getImageResult();
        int r104 = r103.getFrameForPreview();
        CloseableReference<Bitmap> r105 = r103.getPreviewBitmap();
        ArrayList r106 = new ArrayList(r104);
        int r107 = 0;
    L3:
        if (r107 >= r104) goto L5;
        r106.add(r103.getDecodedFrame(r107));     // Catch: Throwable -> L8
        r107 = r107 + 1;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableReference.closeSafely(r105);
        CloseableReference.closeSafely(r106);
        throw th;
    L5:
        CloseableAnimatedImage r108 = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(r101).setPreviewBitmap(r105).setFrameForPreview(r104).setDecodedFrames(r106).setAnimHeifIndividualCacheForCurrentRequestEnabled(r100.animatedHeifIndividualCacheEnabled).build(), r100, r102);     // Catch: Throwable -> L8
        CloseableReference.closeSafely(r105);
        CloseableReference.closeSafely(r106);
        return r108;
    }
}
