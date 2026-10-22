package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f411053a;

    public y(w r100) {
        this.f411053a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        Log.d("CaptureButton", "state = " + this.f411053a.f411024a);
        w r101 = this.f411053a;
        r101.f411024a = 5;
        d0b.a r102 = r101.f411048y;
        if (r102 == null) goto L5;
        r102.b();
    L5:
        this.f411053a.f411024a = 1;
    }
}
