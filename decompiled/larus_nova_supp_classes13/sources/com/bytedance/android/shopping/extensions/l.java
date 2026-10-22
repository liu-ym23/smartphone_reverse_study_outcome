package com.bytedance.android.shopping.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.b == false) goto L6;
        this.a.setVisibility(4);
        return;
    }

    public l(View r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
