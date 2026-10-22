package com.bytedance.ee.bear.widgets.popupmenu;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f240317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupMenuView f240318b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public b(PopupMenuView r100) {
        this.f240317a = false;
        this.f240318b = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f240317a == true) goto L5;
        this.f240318b.setVisibility(8);
    L5:
        this.f240318b.f240314e = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f240317a == true) goto L5;
        this.f240318b.setVisibility(8);
    L5:
        this.f240318b.f240314e = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f240317a == false) goto L5;
        PopupMenuView r101 = this.f240318b;
        int r102 = PopupMenuView.f240309g;
        r101.getClass();
        return;
    L5:
        PopupMenuView r103 = this.f240318b;
        int r104 = PopupMenuView.f240309g;
        r103.getClass();
    }
}
