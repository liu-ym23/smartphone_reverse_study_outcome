package com.bytedance.locallife.pdp.container;

import android.animation.Animator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f261142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f261143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f261144c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        a0 r101 = this.f261142a;
        FrameLayout r102 = r101.f261115c;
        if (r102 == 0) goto L12;
        int r103 = this.f261143b;
        int r104 = this.f261144c;
        a0.b(r101, r101.f261120h, r102);
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        ViewGroup.MarginLayoutParams r106 = null;
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
    L8:
        if (r107 == null) goto L10;
        r107.setMargins(r107.leftMargin, r103, r107.rightMargin, r104);
        r106 = r107;
    L10:
        r102.setLayoutParams(r106);
        r102.setTranslationX(wo6.a.c(r102.getContext()));
        r102.setVisibility(0);
        r102.setBackgroundColor(a0.a(r101, r101.f261120h));
        r101.f261121i.add(r102);
        return;
    L7:
        r107 = null;
        goto L8
    }

    public e0(a0 r100, int r101, int r102) {
        this.f261142a = r100;
        this.f261143b = r101;
        this.f261144c = r102;
    }
}
