package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ OftenShopPullLayout a;

    public e(OftenShopPullLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        b r3 = this.a.j;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        this.a.getClass();
        OftenShopPullLayout r4 = this.a;
        r4.f = 0.0f;
        r4.h = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        b r3 = this.a.j;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        this.a.getClass();
        OftenShopPullLayout r4 = this.a;
        r4.f = 0.0f;
        r4.h = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        b r3 = this.a.j;
        if (r3 == null) goto L5;
        r3.a();
    L5:
        this.a.h = true;
    }
}
