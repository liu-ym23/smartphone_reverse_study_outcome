package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpertCardBox f304520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f304521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f304522c;

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
        Boolean r101 = Boolean.valueOf(this.f304522c);
        ExpertCardBox.n(this.f304520a).put(this.f304521b, r101);
        ExpertCardBox.b r102 = this.f304520a.f304094p;
        if (r102 == null) goto L6;
        r102.f304126a = this.f304522c;
        return;
    }

    public n0(ExpertCardBox r100, String r101, boolean r102) {
        this.f304520a = r100;
        this.f304521b = r101;
        this.f304522c = r102;
    }
}
