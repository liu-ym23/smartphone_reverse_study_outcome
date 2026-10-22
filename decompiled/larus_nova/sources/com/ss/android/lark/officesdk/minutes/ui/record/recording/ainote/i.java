package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f436093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f436094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f436095d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f436092a.f435986s = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MmAINotePanelAnimator r101 = this.f436092a;
        r101.f435986s = null;
        r101.f(this.f436093b, this.f436094c, this.f436095d, true);
    }

    public i(MmAINotePanelAnimator r100, int r101, int r102, String r103) {
        this.f436092a = r100;
        this.f436093b = r101;
        this.f436094c = r102;
        this.f436095d = r103;
    }
}
