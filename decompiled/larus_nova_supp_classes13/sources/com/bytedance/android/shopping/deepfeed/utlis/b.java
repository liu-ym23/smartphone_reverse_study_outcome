package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(DeepFeedProductSlcView r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        int r4 = ((Integer) r3).intValue();
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        r0.height = r4;
        this.a.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
