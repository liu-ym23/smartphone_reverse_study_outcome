package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    private static final Class<?> TAG = null;
    private AnimatedDrawableBackend mAnimatedDrawableBackend;
    private AnimatedImageCompositor mAnimatedImageCompositor;
    private final BitmapFrameCache mBitmapFrameCache;
    private final AnimatedImageCompositor.Callback mCallback;

    static {
        TAG = AnimatedDrawableBackendFrameRenderer.class;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public static /* synthetic */ BitmapFrameCache access$000(AnimatedDrawableBackendFrameRenderer r100) {
        return r100.mBitmapFrameCache;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public void setBounds(@Nullable Rect r100) {
        AnimatedDrawableBackend r101 = this.mAnimatedDrawableBackend.forNewBounds(r100);
        if (r101 == this.mAnimatedDrawableBackend) goto L6;
        this.mAnimatedDrawableBackend = r101;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(r101, this.mCallback);
        return;
    }

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache r100, AnimatedDrawableBackend r101) {
        AnimatedImageCompositor.Callback r102 = new AnonymousClass1(this);
        this.mCallback = r102;
        this.mBitmapFrameCache = r100;
        this.mAnimatedDrawableBackend = r101;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(r101, r102);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public boolean renderFrame(int r100, Bitmap r101) {
        this.mAnimatedImageCompositor.renderFrame(r100, r101);     // Catch: IllegalStateException -> L5
        return true;
    L5:
        e = move-exception;
        FLog.e(TAG, e, "Rendering of frame unsuccessful. Frame number: %d", new Object[]{Integer.valueOf(r100)});
        return false;
    }
}
