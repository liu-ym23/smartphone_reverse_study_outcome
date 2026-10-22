package com.bytedance.locallife.pdp.container;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f261136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f261137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f261138c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        ValueAnimator r101 = this.f261138c;
        if (r101 == null) goto L6;
        r101.start();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        a0 r101 = this.f261136a;
        FrameLayout r102 = r101.f261114b;
        if (r102 == null) goto L5;
        int r103 = this.f261137b;
        a0.b(r101, r101.f261119g, r102);
        r102.setAlpha(1.0f);
        r102.getLayoutParams().height = r103;
        r102.setVisibility(0);
        r102.setBackgroundColor(a0.a(r101, r101.f261119g));
        r101.f261121i.add(r102);
    L5:
        View r104 = this.f261136a.f261118f;
        if (r104 == null) goto L10;
        r104.setVisibility(8);
        return;
    }

    public c0(a0 r100, int r101, ValueAnimator r102) {
        this.f261136a = r100;
        this.f261137b = r101;
        this.f261138c = r102;
    }
}
