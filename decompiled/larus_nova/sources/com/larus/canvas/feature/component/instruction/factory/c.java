package com.larus.canvas.feature.component.instruction.factory;

import android.animation.Animator;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstructionTabWidgetFactory f323142a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public c(InstructionTabWidgetFactory r100) {
        this.f323142a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f323142a.f323131c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L10;
        r102.height = -2;
        r101.setLayoutParams(r102);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
