package com.ss.android.lark.compose.foundation.toast;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f417665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f417666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f417667c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f417666b.f417660c = null;
        Function0<Unit> r101 = this.f417667c;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        Animator.AnimatorListener r102 = this.f417665a;
        if (r102 == null) goto L9;
        r102.onAnimationCancel(r100);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f417666b.f417660c = null;
        Function0<Unit> r101 = this.f417667c;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        Animator.AnimatorListener r102 = this.f417665a;
        if (r102 == null) goto L9;
        r102.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Animator.AnimatorListener r101 = this.f417665a;
        if (r101 == null) goto L6;
        r101.onAnimationRepeat(r100);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Animator.AnimatorListener r101 = this.f417665a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public j(Animator.AnimatorListener r100, i r101, Function0<Unit> r102) {
        this.f417665a = r100;
        this.f417666b = r101;
        this.f417667c = r102;
    }
}
