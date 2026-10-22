package com.bytedance.awemeopen.apps.framework.comment.write;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f194486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f194487b;

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
        this.f194486a.f194471c = false;
        this.f194487b.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        boolean r101 = false;
        this.f194486a.f194471c = false;
        this.f194487b.removeListener(this);
        n r102 = this.f194486a;
        r102.f194470b = 3;
        ViewGroup r103 = r102.f194472d;
        if (r103 == null) goto L10;
        View r104 = r102.f194473e;
        Intrinsics.checkNotNull(r104);
        if (r103.indexOfChild(r104) == (-1)) goto L7;
        boolean r105 = true;
    L8:
        if (r105 != true) goto L10;
        r101 = true;
        goto L10
    L7:
        r105 = false;
    L10:
        if (r101 == false) goto L18;
        ViewGroup r106 = r102.f194472d;
        if (r106 == null) goto L14;
        r106.removeView(r102.f194474f);
    L14:
        ViewGroup r107 = r102.f194472d;
        if (r107 == null) goto L19;
        r107.removeView(r102.f194473e);
        return;
    L19:
        return;
    }

    public p(n r100, ObjectAnimator r101) {
        this.f194486a = r100;
        this.f194487b = r101;
    }
}
