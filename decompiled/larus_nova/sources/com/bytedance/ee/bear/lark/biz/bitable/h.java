package com.bytedance.ee.bear.lark.biz.bitable;

import android.animation.Animator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableTabFragmentV2 f227325a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public h(BitableTabFragmentV2 r100) {
        this.f227325a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f227325a.f227311r;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r101 = null;
    L5:
        r101.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f227325a.f227311r;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r101 = null;
    L5:
        r101.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f227325a.f227311r;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r101 = null;
    L5:
        r101.setVisibility(0);
    }
}
