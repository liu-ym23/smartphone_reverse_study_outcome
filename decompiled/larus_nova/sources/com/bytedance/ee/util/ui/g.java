package com.bytedance.ee.util.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    public static class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
        }
    }

    public static ValueAnimator a(final View r100, int r101, int r102) {
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r101, r102});
        r103.addUpdateListener(new d(r100));
        return r103;
    }

    public static ValueAnimator b(View r100, int r101, int r102) {
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r101, r102});
        r103.addUpdateListener(new f(r100.getLayoutParams(), r100));
        r103.setDuration(200);
        r103.setInterpolator(new LinearInterpolator());
        return r103;
    }

    public static ValueAnimator c(final View r100, int r101, int r102) {
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r101, r102});
        r103.addUpdateListener(new c(r100));
        return r103;
    }

    public static ValueAnimator d(View r100, float r101, float r102) {
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r101, r102});
        r103.addUpdateListener(new e(r100));
        r103.setDuration(150);
        r103.setInterpolator(new LinearInterpolator());
        return r103;
    }
}
