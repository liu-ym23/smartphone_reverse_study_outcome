package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {
    public final WeakReference<CardListCartLoadingView> a;

    public m(CardListCartLoadingView r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingView");
        this.a = new WeakReference(r2);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animator");
        CardListCartLoadingView r1 = this.a.get();
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "animator");
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L13;
        float r6 = ((Float) r5).floatValue();
        k r0 = r1.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L9:
        float r7 = r6 * ((Number) r0.e.invoke()).floatValue();
        View r2 = r1.l;
        if (r2 == null) goto L15;
        r2.setTranslationX(r7);
        return;
    L15:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
