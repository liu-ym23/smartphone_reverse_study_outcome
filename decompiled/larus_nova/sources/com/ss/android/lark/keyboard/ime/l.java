package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f429397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f429398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f429399c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Log.d("ImeWrapper", "doOnEndIgnoreCancel: updateStateOnAnimEnd is " + this.f429397a.element);
        if (this.f429397a.element == false) goto L6;
        this.f429398b.invoke(this.f429399c);
        return;
    }

    public l(Ref.BooleanRef r100, Function1 r101, ValueAnimator r102) {
        this.f429397a = r100;
        this.f429398b = r101;
        this.f429399c = r102;
    }
}
