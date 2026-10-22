package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o implements DoubleBallSwipeRefreshLayout.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubleColorBallAnimationView f193440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f193441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f193442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f193443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f193444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f193445f;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f193446a;

        public a(o r100) {
            this.f193446a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f193446a.f193441b;
            if (r101 == null) goto L6;
            r101.setVisibility(4);
        L6:
            this.f193446a.getClass();
            this.f193446a.getClass();
            View r102 = this.f193446a.f193442c;
            if (r102 == null) goto L11;
            r102.setTranslationY(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f193446a.f193441b;
            if (r101 == null) goto L6;
            r101.setVisibility(4);
        L6:
            this.f193446a.getClass();
            this.f193446a.getClass();
            View r102 = this.f193446a.f193442c;
            if (r102 == null) goto L11;
            r102.setTranslationY(0.0f);
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f193447a;

        public b(o r100) {
            this.f193447a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f193447a.f193442c;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
        L6:
            this.f193447a.getClass();
            this.f193447a.getClass();
            View r102 = this.f193447a.f193441b;
            if (r102 == null) goto L11;
            r102.setAlpha(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f193447a.f193442c;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
        L6:
            this.f193447a.getClass();
            this.f193447a.getClass();
            View r102 = this.f193447a.f193441b;
            if (r102 == null) goto L11;
            r102.setAlpha(0.0f);
            return;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshFinish() {
        Integer r100 = this.f193443d;
        Integer r101 = this.f193444e;
        View r102 = this.f193442c;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
    L6:
        ValueAnimator r103 = this.f193445f;
        if (r103 == null) goto L10;
        r103.cancel();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshStartManually() {
        View r100 = this.f193442c;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        View r101 = this.f193442c;
        if (r101 == null) goto L10;
        r101.setAlpha(1.0f);
    L10:
        View r102 = this.f193441b;
        if (r102 == null) goto L14;
        r102.setVisibility(4);
    L14:
        DoubleColorBallAnimationView r103 = this.f193440a;
        if (r103 == null) goto L18;
        r103.setVisibility(0);
    L18:
        DoubleColorBallAnimationView r104 = this.f193440a;
        if (r104 == null) goto L21;
        r104.setCycleBias(1);
    L21:
        DoubleColorBallAnimationView r105 = this.f193440a;
        if (r105 == null) goto L25;
        r105.c();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndRefresh() {
        View r100 = this.f193442c;
        final float r101 = 0.0f;
        if (r100 == null) goto L5;
        final float r102 = r100.getTranslationY();
    L6:
        View r103 = this.f193442c;
        if (r103 == null) goto L9;
        r101 = r103.getTranslationY();
    L9:
        ValueAnimator r104 = this.f193445f;
        if (r104 == null) goto L12;
        r104.cancel();
    L12:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r105.addUpdateListener(new n(this, r101, r102));
        r105.addListener(new a(this));
        r105.setDuration((long) (r102 * 2));
        this.f193445f = r105;
        r105.start();
        View r106 = this.f193442c;
        if (r106 == null) goto L16;
        r106.setAlpha(1.0f);
    L16:
        DoubleColorBallAnimationView r107 = this.f193440a;
        if (r107 == null) goto L20;
        r107.setVisibility(0);
    L20:
        DoubleColorBallAnimationView r108 = this.f193440a;
        if (r108 == null) goto L23;
        r108.setCycleBias(1);
    L23:
        DoubleColorBallAnimationView r109 = this.f193440a;
        if (r109 == null) goto L27;
        r109.c();
        return;
    L27:
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndScrollBack() {
        View r100 = this.f193442c;
        final float r101 = 0.0f;
        if (r100 == null) goto L5;
        final float r102 = r100.getTranslationY();
    L6:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r103.addUpdateListener(new m(this, r102, r101));
        r103.setDuration((long) (0.0f * 2));
        r103.addListener(new b(this));
        r103.start();
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onOverScroll(float r100, float r101) {
        View r102 = this.f193442c;
        if (r102 == null) goto L6;
        r102.setTranslationY(r100 * 0.85f);
    L6:
        View r103 = this.f193442c;
        boolean r104 = true;
        if (r103 == null) goto L10;
        r103.setAlpha((2 * r101) - 1);
    L10:
        DoubleColorBallAnimationView r105 = this.f193440a;
        if (r105 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == true) goto L21;
        DoubleColorBallAnimationView r107 = this.f193440a;
        if (r107 == null) goto L21;
        r107.setVisibility(0);
    L21:
        DoubleColorBallAnimationView r108 = this.f193440a;
        if (r108 == null) goto L24;
        r108.setProgress(r101);
    L24:
        View r109 = this.f193442c;
        if (r109 != null) goto L27;
    L29:
        boolean r110 = false;
    L30:
        if (r110 == true) goto L35;
        View r111 = this.f193442c;
        if (r111 == null) goto L35;
        r111.setVisibility(0);
    L35:
        View r112 = this.f193441b;
        if (r112 != null) goto L38;
    L40:
        r104 = false;
    L41:
        if (r104 == true) goto L46;
        View r113 = this.f193441b;
        if (r113 == null) goto L46;
        r113.setVisibility(0);
    L46:
        View r114 = this.f193441b;
        if (r114 == null) goto L51;
        r114.setAlpha(1.0f);
    L51:
        return;
    L38:
        if (r112.getVisibility() != 0) goto L40;
    L27:
        if (r109.getVisibility() != 0) goto L29;
        r110 = true;
        goto L30
    L13:
        if (r105.getVisibility() != 0) goto L15;
        r106 = true;
        goto L16
    }

    public o(DoubleColorBallAnimationView r100, DmtTextView r101, View r102) {
        this.f193440a = r100;
        this.f193441b = r101;
        this.f193442c = r102;
        this.f193443d = null;
        this.f193444e = null;
        this.f193443d = null;
        this.f193444e = null;
    }
}
