package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class q implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImeWrapper f429409a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public q(ImeWrapper r100) {
        this.f429409a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ImeWrapper r101 = this.f429409a;
        ImeWrapper.P(r101, r101.f429362w - 1);
        b r102 = b.f429377a;
        final ImeWrapper r103 = this.f429409a;
        Function0<String> r104 = new ImeWrapper$startCompatInsetsAnimation$1$3$1(r103);
        r102.getClass();
        b.a("ImeWrapper", r104);
        ImeWrapper r105 = this.f429409a;
        if (r105.f429352m == false) goto L9;
        r105.f429352m = false;
        f r106 = r105.f429359t.acquire();
        if (r106 != null) goto L7;
        r106 = new f();
    L7:
        r106.a(this.f429409a.f429353n);
        this.f429409a.S(r106, false);
        this.f429409a.f429359t.release(r106);
        return;
    }
}
