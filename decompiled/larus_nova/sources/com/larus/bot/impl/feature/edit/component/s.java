package com.larus.bot.impl.feature.edit.component;

import android.animation.Animator;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class s implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageBotEditBinding f318322a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public s(LarusPageBotEditBinding r100) {
        this.f318322a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f318322a.f317942m.setAlpha(0.0f);
        this.f318322a.f317942m.setVisibility(0);
        this.f318322a.f317941l.setAlpha(0.3f);
    }
}
