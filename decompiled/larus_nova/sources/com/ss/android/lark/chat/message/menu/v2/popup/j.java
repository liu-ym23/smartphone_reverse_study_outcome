package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.Animator;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuMainContent f415891a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public j(PopupMenuMainContent r100) {
        this.f415891a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        PopupMenuMainContent r101 = this.f415891a;
        r101.f415827e = false;
        r101.invalidate();
    }
}
