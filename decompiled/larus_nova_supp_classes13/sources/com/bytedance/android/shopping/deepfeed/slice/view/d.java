package com.bytedance.android.shopping.deepfeed.slice.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.e(1.0f);
        this.b.invoke();
    }

    public d(a r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
