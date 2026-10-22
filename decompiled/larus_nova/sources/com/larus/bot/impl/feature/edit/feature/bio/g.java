package com.larus.bot.impl.feature.edit.feature.bio;

import android.animation.Animator;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f319109a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public g(f r100) {
        this.f319109a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        AppCompatEditText r101 = this.f319109a.f319101a.f317831b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        r102.height = -2;
        r101.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
