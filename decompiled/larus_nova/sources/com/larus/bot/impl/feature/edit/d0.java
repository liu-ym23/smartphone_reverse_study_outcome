package com.larus.bot.impl.feature.edit;

import android.animation.Animator;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f318352a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public d0(AppCompatEditText r100) {
        this.f318352a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        EditText r101 = this.f318352a;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        r102.height = -2;
        r101.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
