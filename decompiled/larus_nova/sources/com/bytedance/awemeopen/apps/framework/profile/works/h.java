package com.bytedance.awemeopen.apps.framework.profile.works;

import android.animation.Animator;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.base.view.FixRatioRoundFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f197589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f197590b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f197589a.setScaleX(1.0f);
        this.f197589a.setScaleY(1.0f);
        View r101 = this.f197589a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.base.view.FixRatioRoundFrameLayout");
        ((FixRatioRoundFrameLayout) r101).setRadius(0.0f);
        ViewCompat.setElevation(this.f197589a, 0.0f);
        g r102 = this.f197590b;
    L4:
        if (r102.f197586a.isEmpty() == true) goto L6;
        Pair<ViewGroup, boolean[]> r103 = r102.f197586a.pop();
        ((ViewGroup) r103.first).setClipChildren(((boolean[]) r103.second)[0]);
        ((ViewGroup) r103.first).setClipToPadding(((boolean[]) r103.second)[1]);
        goto L4
    }

    public h(View r100, g r101) {
        this.f197589a = r100;
        this.f197590b = r101;
    }
}
