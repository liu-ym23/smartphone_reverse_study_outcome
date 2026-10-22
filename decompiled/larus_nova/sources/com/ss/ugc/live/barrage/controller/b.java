package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsBarrageController f458134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f458135b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        if (this.f458135b.element >= 5) goto L8;
        AbsBarrageController r101 = this.f458134a;
        r101.l();
        AbsBarrageController.f458093m = true;
        r101.n();
        if (r101.f().isRunning() == false) goto L9;
        r101.f().cancel();
        return;
    L9:
        return;
    }

    public b(AbsBarrageController r100, Ref.IntRef r101) {
        this.f458134a = r100;
        this.f458135b = r101;
    }
}
