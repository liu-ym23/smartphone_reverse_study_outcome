package com.larus.livetutor.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorPlanView f356852a;

    public i0(LiveTutorPlanView r100) {
        this.f356852a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LiveTutorPlanView.b6(this.f356852a, 4);
    }
}
