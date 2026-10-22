package com.bytedance.ee.bear.bitable.toolbox.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BitableToolboxFragment a;

    public b(BitableToolboxFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LinearLayout r0 = this.a.g;
        LinearLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Object r6 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
        r2.height = (int) ((Float) r6).floatValue();
        LinearLayout r7 = this.a.g;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarContainer");
    L9:
        r1.setLayoutParams(r2);
        return;
    L8:
        r1 = r7;
        goto L9
    }
}
