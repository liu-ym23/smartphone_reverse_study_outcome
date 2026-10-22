package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements DoubleBallSwipeRefreshLayout.h {
    public final DoubleColorBallAnimationView a;
    public final View b;
    public final View c;
    public final Integer d;
    public final Integer e;
    public ValueAnimator f;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.setVisibility(4);
        L6:
            this.a.getClass();
            this.a.getClass();
            View r4 = this.a.c;
            if (r4 == null) goto L11;
            r4.setTranslationY(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.setVisibility(4);
        L6:
            this.a.getClass();
            this.a.getClass();
            View r4 = this.a.c;
            if (r4 == null) goto L11;
            r4.setTranslationY(0.0f);
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
        L6:
            this.a.getClass();
            this.a.getClass();
            View r4 = this.a.b;
            if (r4 == null) goto L11;
            r4.setAlpha(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
        L6:
            this.a.getClass();
            this.a.getClass();
            View r4 = this.a.b;
            if (r4 == null) goto L11;
            r4.setAlpha(0.0f);
            return;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshFinish() {
        Integer r0 = this.d;
        Integer r1 = this.e;
        View r2 = this.c;
        if (r2 == null) goto L6;
        r2.setVisibility(8);
    L6:
        ValueAnimator r3 = this.f;
        if (r3 == null) goto L10;
        r3.cancel();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshStartManually() {
        View r0 = this.c;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        View r1 = this.c;
        if (r1 == null) goto L10;
        r1.setAlpha(1.0f);
    L10:
        View r2 = this.b;
        if (r2 == null) goto L14;
        r2.setVisibility(4);
    L14:
        DoubleColorBallAnimationView r3 = this.a;
        if (r3 == null) goto L18;
        r3.setVisibility(0);
    L18:
        DoubleColorBallAnimationView r4 = this.a;
        if (r4 == null) goto L21;
        r4.setCycleBias(1);
    L21:
        DoubleColorBallAnimationView r5 = this.a;
        if (r5 == null) goto L25;
        r5.c();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndRefresh() {
        View r0 = this.c;
        final float r1 = 0.0f;
        if (r0 == null) goto L5;
        final float r2 = r0.getTranslationY();
    L6:
        View r3 = this.c;
        if (r3 == null) goto L9;
        r1 = r3.getTranslationY();
    L9:
        ValueAnimator r4 = this.f;
        if (r4 == null) goto L12;
        r4.cancel();
    L12:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r5.addUpdateListener(new n(this, r1, r2));
        r5.addListener(new a(this));
        r5.setDuration((long) (r2 * 2));
        this.f = r5;
        r5.start();
        View r6 = this.c;
        if (r6 == null) goto L16;
        r6.setAlpha(1.0f);
    L16:
        DoubleColorBallAnimationView r7 = this.a;
        if (r7 == null) goto L20;
        r7.setVisibility(0);
    L20:
        DoubleColorBallAnimationView r8 = this.a;
        if (r8 == null) goto L23;
        r8.setCycleBias(1);
    L23:
        DoubleColorBallAnimationView r9 = this.a;
        if (r9 == null) goto L27;
        r9.c();
        return;
    L27:
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndScrollBack() {
        View r0 = this.c;
        final float r1 = 0.0f;
        if (r0 == null) goto L5;
        final float r2 = r0.getTranslationY();
    L6:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r3.addUpdateListener(new m(this, r2, r1));
        r3.setDuration((long) (0.0f * 2));
        r3.addListener(new b(this));
        r3.start();
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onOverScroll(float r4, float r5) {
        View r0 = this.c;
        if (r0 == null) goto L6;
        r0.setTranslationY(r4 * 0.85f);
    L6:
        View r6 = this.c;
        boolean r1 = true;
        if (r6 == null) goto L10;
        r6.setAlpha((2 * r5) - 1);
    L10:
        DoubleColorBallAnimationView r7 = this.a;
        if (r7 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L21;
        DoubleColorBallAnimationView r9 = this.a;
        if (r9 == null) goto L21;
        r9.setVisibility(0);
    L21:
        DoubleColorBallAnimationView r10 = this.a;
        if (r10 == null) goto L24;
        r10.setProgress(r5);
    L24:
        View r11 = this.c;
        if (r11 != null) goto L27;
    L29:
        boolean r12 = false;
    L30:
        if (r12 == true) goto L35;
        View r13 = this.c;
        if (r13 == null) goto L35;
        r13.setVisibility(0);
    L35:
        View r14 = this.b;
        if (r14 != null) goto L38;
    L40:
        r1 = false;
    L41:
        if (r1 == true) goto L46;
        View r15 = this.b;
        if (r15 == null) goto L46;
        r15.setVisibility(0);
    L46:
        View r16 = this.b;
        if (r16 == null) goto L51;
        r16.setAlpha(1.0f);
    L51:
        return;
    L38:
        if (r14.getVisibility() != 0) goto L40;
    L27:
        if (r11.getVisibility() != 0) goto L29;
        r12 = true;
        goto L30
    L13:
        if (r7.getVisibility() != 0) goto L15;
        r8 = true;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(DoubleColorBallAnimationView r1, DmtTextView r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.e = null;
        this.d = null;
        this.e = null;
    }
}
