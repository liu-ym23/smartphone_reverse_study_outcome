package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class r implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f321934a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public r(Ref.ObjectRef r100) {
        this.f321934a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.larus.camera.impl.ui.component.capture.edu.o] */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ((Function0) this.f321934a.element).invoke();
        Ref.ObjectRef r101 = this.f321934a;
        r101.element = o.f321931a;
    }
}
