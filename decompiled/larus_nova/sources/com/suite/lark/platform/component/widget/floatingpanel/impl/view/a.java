package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingBannerContainer f460781a;

    public a(FloatingBannerContainer r100) {
        this.f460781a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FloatingBannerContainer.a r101 = this.f460781a.getOnBannerMovedOutListener();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
