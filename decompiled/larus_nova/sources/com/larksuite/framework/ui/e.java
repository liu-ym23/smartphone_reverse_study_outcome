package com.larksuite.framework.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTransitionContainer<View> f285848a;

    public e(ViewTransitionContainer<View> r100) {
        this.f285848a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewTransitionContainer<View> r101 = this.f285848a;
        r101.f285835b = null;
        r101.f285836c.set(0.0f, 0.0f);
        r101.f285837d = null;
        r101.invalidate();
    }
}
