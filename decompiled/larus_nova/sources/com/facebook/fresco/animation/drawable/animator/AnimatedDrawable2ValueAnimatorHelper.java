package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawable2ValueAnimatorHelper {
    private AnimatedDrawable2ValueAnimatorHelper() {
    }

    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(final AnimatedDrawable2 r100) {
        return new AnonymousClass1(r100);
    }

    public static ValueAnimator createValueAnimator(AnimatedDrawable2 r100) {
        int r101 = r100.getLoopCount();
        ValueAnimator r102 = new ValueAnimator();
        r102.setIntValues(new int[]{0, (int) r100.getLoopDurationMs()});
        r102.setDuration(r100.getLoopDurationMs());
        if (r101 != 0) goto L6;
        r101 = -1;
    L6:
        r102.setRepeatCount(r101);
        r102.setRepeatMode(1);
        r102.setInterpolator(null);
        r102.addUpdateListener(createAnimatorUpdateListener(r100));
        return r102;
    }

    public static ValueAnimator createValueAnimator(AnimatedDrawable2 r100, int r101) {
        ValueAnimator r102 = createValueAnimator(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        r102.setRepeatCount((int) Math.max(((long) r101) / r100.getLoopDurationMs(), 1));
        return r102;
    }
}
