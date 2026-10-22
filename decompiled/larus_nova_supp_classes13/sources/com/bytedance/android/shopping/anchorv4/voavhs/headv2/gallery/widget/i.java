package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.c.setVisibility(4);
    }
}
