package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ PageHorizontalPullLayout b;
    public final /* synthetic */ float c;

    public f(ValueAnimator r1, float r2, PageHorizontalPullLayout r3, float r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Object r6 = this.a.getAnimatedValue();
        if (r6 == null) goto L22;
        float r7 = ((Float) r6).floatValue();
        Integer r0 = this.b.m;
        if (r0 != null) goto L8;
    L9:
        if (r0 != null) goto L12;
    L17:
        c r8 = this.b.o;
        if (r8 == null) goto L24;
        r8.c();
        return;
    L24:
        return;
    L12:
        if (r0.intValue() != 2) goto L17;
    L13:
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r1 = this.b.getChildViews().entrySet().iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<View, BaseHorizontalPullLayout.a> r2 = r1.next();
        r2.getKey().setX(r2.getValue().a + (this.c * r7));
        goto L15
    L8:
        if (r0.intValue() == 0) goto L13;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
