package com.obric.oui.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f401255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IndicatorAnimator f401256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IndicatorAnimator.a f401257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f401258d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f401255a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f401256b.f401141a.animate().setUpdateListener(null).setListener(null);
        if (this.f401255a == false) goto L5;
        return;
    L5:
        IndicatorAnimator.a r101 = this.f401256b.f401146f;
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        this.f401258d.invoke();
        return;
    L9:
        if (r101.f401151a != this.f401257c.f401151a) goto L11;
        r102 = true;
        goto L11
    }

    public c(IndicatorAnimator r100, IndicatorAnimator.a r101, Function0<Unit> r102) {
        this.f401256b = r100;
        this.f401257c = r101;
        this.f401258d = r102;
    }
}
