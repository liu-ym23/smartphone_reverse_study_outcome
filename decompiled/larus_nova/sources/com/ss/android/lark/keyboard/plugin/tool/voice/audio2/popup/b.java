package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f429976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioPopupWindowImpl f429977b;

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
        Function0 r101 = this.f429976a;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        this.f429977b.a();
    }

    public b(Function0 r100, AudioPopupWindowImpl r101) {
        this.f429976a = r100;
        this.f429977b = r101;
    }
}
