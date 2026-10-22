package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436085a;

    public g(MmAINotePanelAnimator r100) {
        this.f436085a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MmAINotePanelAnimator r101 = this.f436085a;
        if (r101.f435984q == r100) goto L5;
        return;
    L5:
        r101.f435984q = null;
        r101.f435982o = MmAINoteSheetState.FULL;
        r101.g(r101.q(), 0.0f);
    }
}
