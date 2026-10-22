package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedImageResultBuilder {
    private boolean mAnimHeifIndividualCacheForCurrentRequestEnabled;
    private List<CloseableReference<Bitmap>> mDecodedFrames;
    private int mFrameForPreview;
    private final AnimatedImage mImage;
    private CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResult build() {
        AnimatedImageResult r100 = new AnimatedImageResult(this);     // Catch: Throwable -> L6
        CloseableReference.closeSafely(this.mPreviewBitmap);
        this.mPreviewBitmap = null;
        CloseableReference.closeSafely(this.mDecodedFrames);
        this.mDecodedFrames = null;
        return r100;
    L6:
        th = move-exception;
        CloseableReference.closeSafely(this.mPreviewBitmap);
        this.mPreviewBitmap = null;
        CloseableReference.closeSafely(this.mDecodedFrames);
        this.mDecodedFrames = null;
        throw th;
    }

    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        return CloseableReference.cloneOrNull(this.mDecodedFrames);
    }

    public CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public boolean isAnimHeifIndividualCacheForCurrentRequestEnabled() {
        return this.mAnimHeifIndividualCacheForCurrentRequestEnabled;
    }

    public AnimatedImageResultBuilder(AnimatedImage r100) {
        this.mImage = r100;
    }

    public AnimatedImageResultBuilder setAnimHeifIndividualCacheForCurrentRequestEnabled(boolean r100) {
        this.mAnimHeifIndividualCacheForCurrentRequestEnabled = r100;
        return this;
    }

    public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> r100) {
        this.mDecodedFrames = CloseableReference.cloneOrNull(r100);
        return this;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int r100) {
        this.mFrameForPreview = r100;
        return this;
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> r100) {
        this.mPreviewBitmap = CloseableReference.cloneOrNull(r100);
        return this;
    }
}
