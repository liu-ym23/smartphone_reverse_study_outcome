package com.larksuite.component.universe_design.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDTabLayout.c f285305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f285306b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f285305a.f285266e = 0.0f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        UDTabLayout.c r101 = this.f285305a;
        r101.f285265d = this.f285306b;
    }

    public e(UDTabLayout.c r100, int r101) {
        this.f285305a = r100;
        this.f285306b = r101;
    }
}
