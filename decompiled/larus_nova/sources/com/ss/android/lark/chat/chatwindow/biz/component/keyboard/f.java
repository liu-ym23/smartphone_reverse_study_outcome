package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f412085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f412086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f412087c;

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
        d r101 = this.f412085a;
        r101.f412080c = false;
        r101.f412083f = null;
        if (this.f412086b.element == true) goto L6;
        r101.f412079b.invoke(Integer.valueOf(this.f412087c));
        return;
    }

    public f(d r100, Ref.BooleanRef r101, int r102) {
        this.f412085a = r100;
        this.f412086b = r101;
        this.f412087c = r102;
    }
}
