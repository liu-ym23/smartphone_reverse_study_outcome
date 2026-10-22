package com.bytedance.component.lyric_v2.painter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f203070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f203071b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        d r101 = this.f203070a;
        r101.f203078c = 0.0f;
        r101.f203079d = 0.0f;
        r101.f203076a = false;
        this.f203071b.invoke();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        d r101 = this.f203070a;
        r101.f203078c = 0.0f;
        r101.f203079d = 0.0f;
        r101.f203076a = false;
        this.f203071b.invoke();
    }

    public a(d r100, Function0 r101) {
        this.f203070a = r100;
        this.f203071b = r101;
    }
}
