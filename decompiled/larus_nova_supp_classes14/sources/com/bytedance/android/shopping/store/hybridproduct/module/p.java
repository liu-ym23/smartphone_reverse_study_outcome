package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$visibleWithHeight");
        r2.setVisibility(0);
        r2.setAlpha(1.0f);
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        r1.height = RangesKt.coerceAtLeast(r3, 0);
        Unit r4 = Unit.INSTANCE;
        r2.setLayoutParams(r1);
        r2.requestLayout();
    }
}
