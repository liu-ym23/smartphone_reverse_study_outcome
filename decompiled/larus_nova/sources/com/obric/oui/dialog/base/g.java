package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractDialog f400712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f400713b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        AbstractDialog r101 = this.f400712a;
        r101.A = null;
        r101.f400672z = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        AbstractDialog r101 = this.f400712a;
        r101.C = Integer.valueOf(this.f400713b);
        AbstractDialog r102 = this.f400712a;
        r102.B = Integer.valueOf(this.f400713b);
        AbstractDialog r103 = this.f400712a;
        r103.A = null;
        r103.f400672z = null;
    }

    public g(AbstractDialog r100, int r101) {
        this.f400712a = r100;
        this.f400713b = r101;
    }
}
