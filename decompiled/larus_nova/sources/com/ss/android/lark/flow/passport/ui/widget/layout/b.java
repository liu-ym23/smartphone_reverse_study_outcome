package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonContainerLayout f423879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f423880b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function1<Boolean, Unit> r101 = this.f423879a.getOnImeChangedEndListener();
        if (r101 == null) goto L6;
        r101.invoke(Boolean.valueOf(this.f423880b));
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function1<Boolean, Unit> r101 = this.f423879a.getOnImeChangedEndListener();
        if (r101 == null) goto L6;
        r101.invoke(Boolean.valueOf(this.f423880b));
        return;
    }

    public b(CommonContainerLayout r100, boolean r101) {
        this.f423879a = r100;
        this.f423880b = r101;
    }
}
