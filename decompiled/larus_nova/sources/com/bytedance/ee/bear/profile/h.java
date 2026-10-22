package com.bytedance.ee.bear.profile;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.lark.databinding.ActivityHalfProfileBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236288a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public h(HalfProfileActivity r100) {
        this.f236288a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        HalfProfileActivity r101 = this.f236288a;
        j r102 = r101.f236248j;
        if (r102 == null) goto L5;
        r102.f226596k = true;
    L5:
        if (r102 == null) goto L11;
        ActivityHalfProfileBinding r103 = r101.f236247i;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L9:
        r102.i(r103.f227339e);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        HalfProfileActivity r101 = this.f236288a;
        j r102 = r101.f236248j;
        if (r102 == null) goto L5;
        r102.f226596k = true;
    L5:
        if (r102 == null) goto L11;
        ActivityHalfProfileBinding r103 = r101.f236247i;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L9:
        r102.i(r103.f227339e);
        return;
    }
}
