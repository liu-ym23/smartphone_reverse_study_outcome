package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f410942a;

    public d0(w r100) {
        this.f410942a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        w r101 = this.f410942a;
        if (r101.f411024a != 3) goto L9;
        d0b.a r102 = r101.f411048y;
        if (r102 == null) goto L7;
        r102.c();
    L7:
        w r103 = this.f410942a;
        r103.f411024a = 4;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r104.setDuration(r103.f411043t);
        r104.addUpdateListener(new z(r103));
        r104.addListener(new a0(r103));
        r104.start();
        r103.A = r104;
        return;
    }
}
