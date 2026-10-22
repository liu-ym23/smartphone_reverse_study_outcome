package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedImageResult {
    private boolean mAnimHeifIndividualCacheForCurrentRequestEnabled;

    @Nullable
    private List<CloseableReference<Bitmap>> mDecodedFrames;
    private final int mFrameForPreview;
    private final AnimatedImage mImage;

    @Nullable
    private CloseableReference<Bitmap> mPreviewBitmap;
    private String mSourceUri;

    public synchronized void dispose() {
        monitor-enter(this);
        CloseableReference.closeSafely(this.mPreviewBitmap);     // Catch: Throwable -> L6
        this.mPreviewBitmap = null;     // Catch: Throwable -> L6
        CloseableReference.closeSafely(this.mDecodedFrames);     // Catch: Throwable -> L6
        this.mDecodedFrames = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getDecodedFrameSize() {
        monitor-enter(this);
        List<CloseableReference<Bitmap>> r100 = this.mDecodedFrames;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        int r101 = r100.size();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized CloseableReference<Bitmap> getPreviewBitmap() {
        monitor-enter(this);
        CloseableReference<Bitmap> r100 = CloseableReference.cloneOrNull(this.mPreviewBitmap);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public String getSourceUri() {
        return this.mSourceUri;
    }

    public boolean isUseIndividualCacheForHeif() {
        return this.mAnimHeifIndividualCacheForCurrentRequestEnabled;
    }

    public AnimatedImageResult(AnimatedImageResultBuilder r100) {
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(r100.getImage());
        this.mFrameForPreview = r100.getFrameForPreview();
        this.mPreviewBitmap = r100.getPreviewBitmap();
        this.mDecodedFrames = r100.getDecodedFrames();
        this.mAnimHeifIndividualCacheForCurrentRequestEnabled = r100.isAnimHeifIndividualCacheForCurrentRequestEnabled();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage r100) {
        return new AnimatedImageResult(r100);
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage r100) {
        return new AnimatedImageResultBuilder(r100);
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getDecodedFrame(int r100) {
        monitor-enter(this);
        List<CloseableReference<Bitmap>> r101 = this.mDecodedFrames;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        CloseableReference<Bitmap> r102 = CloseableReference.cloneOrNull(r101.get(r100));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean hasDecodedFrame(int r100) {
        monitor-enter(this);
        List<CloseableReference<Bitmap>> r101 = this.mDecodedFrames;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        if (r101.get(r100) == null) goto L8;
        boolean r102 = true;
    L9:
        monitor-exit(this);
        return r102;
    L8:
        r102 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public void setSourceUri(String r100) {
        if (this.mImage.getImageFormat() != DefaultImageFormats.WEBP_ANIMATED) goto L5;
    L6:
        this.mSourceUri = r100;
        return;
    L5:
        if (this.mImage.getImageFormat() == DefaultImageFormats.GIF) goto L6;
    }

    private AnimatedImageResult(AnimatedImage r100) {
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(r100);
        this.mFrameForPreview = 0;
    }
}
