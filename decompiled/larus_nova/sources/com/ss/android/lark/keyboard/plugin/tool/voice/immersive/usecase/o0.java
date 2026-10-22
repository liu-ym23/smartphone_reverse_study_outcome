package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f430568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceImeWrapperUseCase f430569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f430570c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        TypeIntrinsics.asMutableCollection(this.f430569b.b()).remove(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f430568a.setTranslationY(0.0f);
        TypeIntrinsics.asMutableCollection(this.f430569b.b()).remove(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f430570c.setVisibility(0);
    }

    public o0(View r100, VoiceImeWrapperUseCase r101, View r102) {
        this.f430568a = r100;
        this.f430569b = r101;
        this.f430570c = r102;
    }
}
