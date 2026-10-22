package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f430563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f430564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VoiceImeWrapperUseCase f430565c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        TypeIntrinsics.asMutableCollection(this.f430565c.b()).remove(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f430563a.setTranslationY(this.f430564b);
        this.f430563a.setVisibility(4);
        TypeIntrinsics.asMutableCollection(this.f430565c.b()).remove(r100);
    }

    public n0(View r100, float r101, VoiceImeWrapperUseCase r102) {
        this.f430563a = r100;
        this.f430564b = r101;
        this.f430565c = r102;
    }
}
