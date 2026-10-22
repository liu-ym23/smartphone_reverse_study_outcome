package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import com.ss.android.lark.keyboard.editor.input.w;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f431046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragShrinkLayout f431047b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        DragShrinkLayout.a r101 = this.f431047b.f430987e;
        if (r101 == null) goto L5;
        r101.f();
    L5:
        Animator.AnimatorListener r102 = this.f431046a;
        if (r102 == null) goto L9;
        r102.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        DragShrinkLayout.a r101 = this.f431047b.f430987e;
        if (r101 == null) goto L5;
        r101.e();
    L5:
        Animator.AnimatorListener r102 = this.f431046a;
        if (r102 == null) goto L9;
        r102.onAnimationStart(r100);
        return;
    }

    public h(DragShrinkLayout r100, w r101) {
        this.f431047b = r100;
        this.f431046a = r101;
    }
}
