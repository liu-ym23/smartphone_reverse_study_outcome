package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.animation.Animator;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f319174a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public i(h r100) {
        this.f319174a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        AppCompatEditText r101 = this.f319174a.f319161b.f317864b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        r102.height = -2;
        r101.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
