package com.bytedance.android.shopping.mall.homepage.tools;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ List a;
    public final /* synthetic */ int b;

    public j(List r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        View r1 = (View) r0.next();
        Object r2 = r5.getAnimatedValue();
        if (r2 == null) goto L9;
        r1.setTranslationX(((Float) r2).floatValue() * this.b);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
