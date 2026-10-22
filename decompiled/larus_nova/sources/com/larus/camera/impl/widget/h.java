package com.larus.camera.impl.widget;

import android.animation.Animator;
import android.view.View;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f322911a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public h(View r100) {
        this.f322911a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNull(this.f322911a);
        e1.o(this.f322911a);
    }
}
