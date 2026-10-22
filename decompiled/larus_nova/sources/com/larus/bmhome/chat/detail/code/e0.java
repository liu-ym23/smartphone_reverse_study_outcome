package com.larus.bmhome.chat.detail.code;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CodeBlockDetailFragment f302735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f302736b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LarusFragmentCodeBlockDetailBinding r101 = this.f302735a.C;
        if (r101 == null) goto L8;
        TextView r102 = r101.f358611h;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        if (Intrinsics.areEqual(this.f302735a.V, this.f302736b) == false) goto L11;
        this.f302735a.V = null;
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LarusFragmentCodeBlockDetailBinding r101 = this.f302735a.C;
        if (r101 == null) goto L8;
        TextView r102 = r101.f358611h;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    L9:
        return;
    }

    public e0(CodeBlockDetailFragment r100, ValueAnimator r101) {
        this.f302735a = r100;
        this.f302736b = r101;
    }
}
