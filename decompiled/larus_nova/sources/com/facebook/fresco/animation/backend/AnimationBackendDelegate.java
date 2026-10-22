package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    private int mAlpha;

    @Nullable
    private T mAnimationBackend;

    @Nullable
    private Rect mBounds;

    @Nullable
    private ColorFilter mColorFilter;
    private ImageFormat mImageFormat;
    private boolean mIsAnimatedHeifIndividualCacheEnabled;

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T r100 = this.mAnimationBackend;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getIntrinsicHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean isAnimatedHeifIndividualCacheEnabled() {
        T r100 = this.mAnimationBackend;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isAnimatedHeifIndividualCacheEnabled();
    }

    @Nullable
    public T getAnimationBackend() {
        return this.mAnimationBackend;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend, com.facebook.fresco.animation.backend.AnimationSourceInfo
    public ImageFormat getImageFormat() {
        return this.mImageFormat;
    }

    public AnimationBackendDelegate(@Nullable T r100) {
        this.mImageFormat = null;
        this.mIsAnimatedHeifIndividualCacheEnabled = false;
        this.mAlpha = -1;
        this.mAnimationBackend = r100;
    }

    private void applyBackendProperties(AnimationBackend r100) {
        Rect r101 = this.mBounds;
        if (r101 == null) goto L5;
        r100.setBounds(r101);
    L5:
        int r102 = this.mAlpha;
        if (r102 >= 0) goto L8;
    L10:
        ColorFilter r103 = this.mColorFilter;
        if (r103 == null) goto L14;
        r100.setColorFilter(r103);
        return;
    L14:
        return;
    L8:
        if (r102 > 255) goto L10;
        r100.setAlpha(r102);
        goto L10
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int r100) {
        T r101 = this.mAnimationBackend;
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.getFrameDurationMs(r100);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean hasCacheFrame(int r100) {
        T r101 = this.mAnimationBackend;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.hasCacheFrame(r100);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int r100) {
        T r101 = this.mAnimationBackend;
        if (r101 == null) goto L5;
        r101.setAlpha(r100);
    L5:
        this.mAlpha = r100;
    }

    public void setAnimationBackend(@Nullable T r100) {
        this.mAnimationBackend = r100;
        if (r100 == null) goto L6;
        applyBackendProperties(r100);
        return;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect r100) {
        T r101 = this.mAnimationBackend;
        if (r101 == null) goto L5;
        r101.setBounds(r100);
    L5:
        this.mBounds = r100;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter r100) {
        T r101 = this.mAnimationBackend;
        if (r101 == null) goto L5;
        r101.setColorFilter(r100);
    L5:
        this.mColorFilter = r100;
    }

    public AnimationBackendDelegate(@Nullable T r100, ImageFormat r101) {
        this.mIsAnimatedHeifIndividualCacheEnabled = false;
        this.mAlpha = -1;
        this.mAnimationBackend = r100;
        this.mImageFormat = r101;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable r100, Canvas r101, int r102) {
        T r103 = this.mAnimationBackend;
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.drawFrame(r100, r101, r102) == false) goto L7;
        return true;
    }
}
