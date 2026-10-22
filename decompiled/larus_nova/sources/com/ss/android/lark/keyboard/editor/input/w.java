package com.ss.android.lark.keyboard.editor.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.keyboard.widget.DragShrinkLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichTextInputExpandPlugin f428913a;

    public w(RichTextInputExpandPlugin r100) {
        this.f428913a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f428913a.getClass();
        RichTextInputExpandPlugin.z0(this.f428913a, 0.7f);
        DragShrinkLayout r101 = this.f428913a.O;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r101 = null;
    L5:
        r101.setDragEnabled(true);
        this.f428913a.getClass();
        this.f428913a.N.invoke();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        DragShrinkLayout r101 = this.f428913a.O;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r101 = null;
    L5:
        r101.setVisibility(0);
        DragShrinkLayout r103 = this.f428913a.O;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r103 = null;
    L8:
        r103.setDragEnabled(false);
        View r104 = this.f428913a.P;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L12:
        r102.setVisibility(0);
        return;
    L11:
        r102 = r104;
        goto L12
    }
}
