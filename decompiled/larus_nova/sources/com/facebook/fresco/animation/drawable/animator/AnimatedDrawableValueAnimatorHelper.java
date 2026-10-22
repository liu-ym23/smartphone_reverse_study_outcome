package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableValueAnimatorHelper {
    private AnimatedDrawableValueAnimatorHelper() {
    }

    @Nullable
    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == true) goto L5;
        return null;
    L5:
        return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) r100);
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable r100) {
        if ((r100 instanceof AnimatedDrawable2) == true) goto L5;
        return null;
    L5:
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) r100);
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable r100, int r101) {
        if ((r100 instanceof AnimatedDrawable2) == true) goto L5;
        return null;
    L5:
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) r100, r101);
    }
}
