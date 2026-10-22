package com.ss.android.lark.bottomsheet.view;

import android.animation.Animator;
import com.ss.android.lark.bottomsheet.q;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandValueAnimatorInForseti.a f410761a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public g(q r100) {
        this.f410761a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ExpandValueAnimatorInForseti.a r101 = this.f410761a;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
