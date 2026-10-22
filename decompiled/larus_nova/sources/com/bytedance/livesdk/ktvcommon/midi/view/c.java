package com.bytedance.livesdk.ktvcommon.midi.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f256068a;

    public c(e r100) {
        this.f256068a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        e r101 = this.f256068a;
        if (r101.f256079h == false) goto L8;
        Animator r102 = r101.f256085n;
        if (r102 == null) goto L9;
        r102.start();
        return;
    L9:
        return;
    }
}
