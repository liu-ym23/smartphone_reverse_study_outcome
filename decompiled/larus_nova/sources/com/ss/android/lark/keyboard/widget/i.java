package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f431048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragShrinkLayout f431049b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        DragShrinkLayout.a r101 = this.f431049b.f430987e;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        DragShrinkLayout.a r101 = this.f431049b.f430987e;
        if (r101 == null) goto L5;
        r101.d();
    L5:
        Animator.AnimatorListener r102 = this.f431048a;
        if (r102 == null) goto L9;
        r102.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        DragShrinkLayout.a r101 = this.f431049b.f430987e;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        Animator.AnimatorListener r102 = this.f431048a;
        if (r102 == null) goto L9;
        r102.onAnimationStart(r100);
        return;
    }

    public i(DragShrinkLayout r100, RichTextInputExpandPlugin.b r101) {
        this.f431049b = r100;
        this.f431048a = r101;
    }
}
