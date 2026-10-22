package com.larus.bot.impl.feature.edit.component;

import android.animation.Animator;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class q implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageBotEditBinding f318314a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public q(LarusPageBotEditBinding r100) {
        this.f318314a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f318314a.f317941l.setVisibility(8);
    }
}
