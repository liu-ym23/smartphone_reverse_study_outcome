package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroupItemAnimator.b f251998a;

    public d(ViewGroupItemAnimator.b r100) {
        this.f251998a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroupItemAnimator.b r101 = this.f251998a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroupItemAnimator.b r101 = this.f251998a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroupItemAnimator.b r101 = this.f251998a;
        if (r101 == null) goto L6;
        r101.onAnimationRepeat();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroupItemAnimator.b r101 = this.f251998a;
        if (r101 == null) goto L6;
        r101.onAnimationStart();
        return;
    }
}
