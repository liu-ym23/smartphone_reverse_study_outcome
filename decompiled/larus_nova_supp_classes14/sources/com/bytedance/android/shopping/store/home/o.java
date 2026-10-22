package com.bytedance.android.shopping.store.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends AnimatorListenerAdapter {
    public final /* synthetic */ ECShopGroupAnimation a;

    public o(ECShopGroupAnimation r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Iterator<T> r4 = this.a.e.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        ECShopGroupAnimation.a r0 = (ECShopGroupAnimation.a) r4.next();
        if (this.a.b == false) goto L8;
        ECShopGroupAnimation.Direction r1 = ECShopGroupAnimation.Direction.REVERSE;
    L9:
        r0.c(r1);
        goto L4
    L8:
        r1 = ECShopGroupAnimation.Direction.FORWARD;
        goto L9
    }
}
