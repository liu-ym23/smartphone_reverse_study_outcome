package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ECShopGroupAnimation a;

    public n(ECShopGroupAnimation r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        int r0 = this.a.c;
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L24;
        int r1 = r0 - ((Integer) r8).intValue();
        Iterator<Map.Entry<Integer, ECShopGroupAnimation.a>> r9 = this.a.e.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L22;
        Map.Entry<Integer, ECShopGroupAnimation.a> r2 = r9.next();
        Integer r3 = r2.getKey();
        ECShopGroupAnimation.a r4 = r2.getValue();
        Pair<Integer, Integer> r5 = this.a.f.get(r3);
        int r6 = 0;
        if (r5 == null) goto L12;
        Integer r10 = (Integer) r5.getFirst();
        if (r10 == null) goto L12;
        int r11 = r10.intValue();
    L13:
        Pair<Integer, Integer> r12 = this.a.f.get(r3);
        if (r12 == null) goto L18;
        Integer r13 = (Integer) r12.getSecond();
        if (r13 == null) goto L18;
        r6 = r13.intValue();
    L18:
        if (r11 > r1) goto L6;
        if (r6 <= r1) goto L6;
        int r14 = r1 - r11;
        r4.onChange(r14, r14 / (r6 - r11));
    L12:
        r11 = 0;
        goto L13
    L22:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
