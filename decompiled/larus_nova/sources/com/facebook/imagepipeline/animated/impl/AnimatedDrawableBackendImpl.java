package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.fresco.animation.util.AnimationBackendUtil;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.animated.factory.AnimatedTempBitmapFactory;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    private boolean isFromTempBitmapFactory;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImage mAnimatedImage;
    private final AnimatedImageResult mAnimatedImageResult;
    private int mDecodeType;
    private final int mDurationMs;
    private final int[] mFrameDurationsMs;
    private final AnimatedDrawableFrameInfo[] mFrameInfos;
    private final int[] mFrameTimestampsMs;
    private final Rect mRenderDstRect;
    private final Rect mRenderSrcRect;
    private final Rect mRenderedBounds;

    @Nullable
    private Bitmap mTempBitmap;

    private synchronized void clearTempBitmap() {
        monitor-enter(this);
        Bitmap r100 = this.mTempBitmap;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
    L9:
        monitor-exit(this);
        return;
    L6:
        if (this.isFromTempBitmapFactory == true) goto L8;
        r100.recycle();     // Catch: Throwable -> L11
    L8:
        this.mTempBitmap = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        monitor-enter(this);
        clearTempBitmap();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized int getMemoryUsage() {
        monitor-enter(this);
        Bitmap r100 = this.mTempBitmap;     // Catch: Throwable -> L10
        int r101 = 0;
        if (r100 == null) goto L6;
        r101 = 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(r100);     // Catch: Throwable -> L10
    L6:
        int r102 = r101 + this.mAnimatedImage.getSizeInBytes();
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean isAnimatedHeifIndividualCacheEnabled() {
        return AnimationBackendUtil.isUseIndividualCacheForCurrentAnimHeifRequest(this.mAnimatedImageResult.isUseIndividualCacheForHeif());
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.mDurationMs;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableBackend forNewBounds(Rect r100) {
        if (getBoundsToUse(this.mAnimatedImage, r100).equals(this.mRenderedBounds) == false) goto L6;
        return this;
    L6:
        return new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int r100) {
        return this.mFrameDurationsMs[r100];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int r100) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int r100) {
        return this.mFrameInfos[r100];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int r100) {
        return this.mAnimatedImageResult.getDecodedFrame(r100);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int r100) {
        Preconditions.checkElementIndex(r100, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[r100];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int r100) {
        return this.mAnimatedImageResult.hasDecodedFrame(r100);
    }

    public void setDecodeType(int r100) {
        this.mDecodeType = r100;
    }

    private static Rect getBoundsToUse(AnimatedImage r100, Rect r101) {
        if (r101 != null) goto L7;
        return new Rect(0, 0, r100.getWidth(), r100.getHeight());
    L7:
        return new Rect(0, 0, Math.min(r101.width(), r100.getWidth()), Math.min(r101.height(), r100.getHeight()));
    }

    private synchronized void prepareTempBitmapForThisSize(int r100, int r101) {
        monitor-enter(this);
        Bitmap r102 = this.mTempBitmap;     // Catch: Throwable -> L28
        if (r102 == null) goto L11;
        if (r102.getWidth() >= r100) goto L8;
    L9:
        clearTempBitmap();     // Catch: Throwable -> L28
        goto L11
    L8:
        if (this.mTempBitmap.getHeight() < r101) goto L9;
    L11:
        if (this.mTempBitmap != null) goto L26;
        AnimatedTempBitmapFactory r103 = AnimatedFactoryProvider.getAnimatedTempBitmapFactory();     // Catch: Throwable -> L28
        if (r103 == null) goto L15;
        Bitmap r104 = r103.createBitmap(r100, r101, Bitmap.Config.ARGB_8888, this.mDecodeType);     // Catch: Throwable -> L28
    L16:
        if (r104 == null) goto L19;
        this.mTempBitmap = r104;     // Catch: Throwable -> L28
        this.isFromTempBitmapFactory = true;     // Catch: Throwable -> L28
        goto L26
    L19:
        if (r100 > 0) goto L22;
        r100 = 10;
    L22:
        if (r101 > 0) goto L25;
        r101 = 10;
    L25:
        this.mTempBitmap = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L28
        this.isFromTempBitmapFactory = false;     // Catch: Throwable -> L28
        goto L26
    L15:
        r104 = null;
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    private void renderImageDoesNotSupportScaling(Canvas r100, AnimatedImageFrame r110) {
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        int r103 = r110.getXOffset();
        int r104 = r110.getYOffset();
        monitor-enter(this);
        prepareTempBitmapForThisSize(r101, r102);     // Catch: Throwable -> L18
        Bitmap r105 = this.mTempBitmap;     // Catch: Throwable -> L18
        monitor-enter(r105);     // Catch: Throwable -> L18
        this.mTempBitmap.eraseColor(0);     // Catch: Throwable -> L15
        r110.renderFrame(r101, r102, this.mTempBitmap);     // Catch: IllegalStateException -> L12 Throwable -> L15
        this.mRenderSrcRect.set(0, 0, r101, r102);     // Catch: Throwable -> L15
        this.mRenderDstRect.set(0, 0, r101, r102);     // Catch: Throwable -> L15
        r100.save();     // Catch: Throwable -> L15
        r100.translate(r103, r104);     // Catch: Throwable -> L15
        r100.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, null);     // Catch: Throwable -> L15
        r100.restore();     // Catch: Throwable -> L15
        monitor-exit(r105);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e.getMessage() + parseExtraInfo(this.mTempBitmap, r101, r102, null, this.mDecodeType));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void renderImageSupportsScaling(Canvas r110, AnimatedImageFrame r111) {
        double r100 = ((double) this.mRenderedBounds.width()) / ((double) this.mAnimatedImage.getWidth());
        double r101 = ((double) this.mRenderedBounds.height()) / ((double) this.mAnimatedImage.getHeight());
        int r102 = (int) Math.round(((double) r111.getWidth()) * r100);
        int r103 = (int) Math.round(((double) r111.getHeight()) * r101);
        int r104 = (int) (((double) r111.getXOffset()) * r100);
        int r105 = (int) (((double) r111.getYOffset()) * r101);
        monitor-enter(this);
        int r106 = this.mRenderedBounds.width();     // Catch: Throwable -> L18
        int r107 = this.mRenderedBounds.height();     // Catch: Throwable -> L18
        prepareTempBitmapForThisSize(r106, r107);     // Catch: Throwable -> L18
        Bitmap r108 = this.mTempBitmap;     // Catch: Throwable -> L18
        monitor-enter(r108);     // Catch: Throwable -> L18
        this.mTempBitmap.eraseColor(0);     // Catch: Throwable -> L15
        r111.renderFrame(r102, r103, this.mTempBitmap);     // Catch: IllegalStateException -> L12 Throwable -> L15
        this.mRenderSrcRect.set(0, 0, r106, r107);     // Catch: Throwable -> L15
        this.mRenderDstRect.set(r104, r105, r106 + r104, r107 + r105);     // Catch: Throwable -> L15
        r110.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, null);     // Catch: Throwable -> L15
        monitor-exit(r108);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e.getMessage() + parseExtraInfo(this.mTempBitmap, r102, r103, this.mRenderedBounds, this.mDecodeType));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int r100, Canvas r101) {
        if (FrescoOptUtil.isOptHeifAnimDecode() == false) goto L5;
        AnimatedImageFrame r102 = this.mAnimatedImage.getFrameNew(r100);
    L15:
    L12:
        th = move-exception;
        r102.dispose();
        throw th;
    L7:
        if (this.mAnimatedImage.doesRenderSupportScaling() == false) goto L9;
        renderImageSupportsScaling(r101, r102);     // Catch: Throwable -> L12
    L10:
        r102.dispose();
        return;
    L9:
        renderImageDoesNotSupportScaling(r101, r102);     // Catch: Throwable -> L12
        goto L10
    L5:
        r102 = this.mAnimatedImage.getFrame(r100);
        goto L15
    }

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil r100, AnimatedImageResult r101, Rect r102) {
        this.mRenderSrcRect = new Rect();
        this.mRenderDstRect = new Rect();
        this.mDecodeType = 2;
        this.mAnimatedDrawableUtil = r100;
        this.mAnimatedImageResult = r101;
        AnimatedImage r103 = r101.getImage();
        this.mAnimatedImage = r103;
        int[] r104 = r103.getFrameDurations();
        this.mFrameDurationsMs = r104;
        r100.fixFrameDurations(r104);
        this.mDurationMs = r100.getTotalDurationFromFrameDurations(r104);
        this.mFrameTimestampsMs = r100.getFrameTimeStampsFromDurations(r104);
        this.mRenderedBounds = getBoundsToUse(r103, r102);
        this.mFrameInfos = new AnimatedDrawableFrameInfo[r103.getFrameCount()];
        int r105 = 0;
    L4:
        if (r105 >= this.mAnimatedImage.getFrameCount()) goto L6;
        this.mFrameInfos[r105] = this.mAnimatedImage.getFrameInfo(r105);
        r105 = r105 + 1;
        goto L4
    }

    private String parseExtraInfo(Bitmap r100, int r101, int r102, Rect r103, int r104) {
        StringBuilder r105 = new StringBuilder(", mTempBitmap:");
        r105.append(r100.getWidth());
        r105.append("x");
        r105.append(r100.getHeight());
        r105.append(", frame:");
        r105.append(r101);
        r105.append("x");
        r105.append(r102);
        if (r103 == null) goto L5;
        r105.append(", renderedBounds:");
        r105.append(r103.width());
        r105.append("x");
        r105.append(r103.height());
    L5:
        r105.append(", decodeType:");
        r105.append(r104);
        return r105.toString();
    }
}
