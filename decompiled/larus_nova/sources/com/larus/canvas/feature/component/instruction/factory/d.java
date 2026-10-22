package com.larus.canvas.feature.component.instruction.factory;

import android.animation.Animator;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstructionTabWidgetFactory f323143a;

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

    public d(InstructionTabWidgetFactory r100) {
        this.f323143a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f323143a.f323131c;
        ViewGroup r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r101 = null;
    L5:
        r101.removeAllViews();
        ViewGroup r103 = this.f323143a.f323131c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
    L9:
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L14;
        r104.height = -2;
        r102.setLayoutParams(r104);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r102 = r103;
        goto L9
    }
}
