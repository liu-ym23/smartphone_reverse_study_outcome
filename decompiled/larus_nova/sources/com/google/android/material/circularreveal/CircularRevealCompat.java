package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

/* JADX INFO: loaded from: classes23.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    public static Animator.AnimatorListener createCircularRevealListener(final CircularRevealWidget r100) {
        return new AnonymousClass1(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator createCircularReveal(CircularRevealWidget r100, float r101, float r102, float r103) {
        ObjectAnimator r104 = ObjectAnimator.ofObject(r100, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r101, r102, r103)});
        CircularRevealWidget.RevealInfo r105 = r100.getRevealInfo();
        if (r105 == null) goto L7;
        Animator r106 = ViewAnimationUtils.createCircularReveal((View) r100, (int) r101, (int) r102, r105.radius, r103);
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(new Animator[]{r104, r106});
        return r107;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator createCircularReveal(CircularRevealWidget r100, float r101, float r102, float r110, float r111) {
        ObjectAnimator r103 = ObjectAnimator.ofObject(r100, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r101, r102, r110), new CircularRevealWidget.RevealInfo(r101, r102, r111)});
        Animator r104 = ViewAnimationUtils.createCircularReveal((View) r100, (int) r101, (int) r102, r110, r111);
        AnimatorSet r105 = new AnimatorSet();
        r105.playTogether(new Animator[]{r103, r104});
        return r105;
    }
}
