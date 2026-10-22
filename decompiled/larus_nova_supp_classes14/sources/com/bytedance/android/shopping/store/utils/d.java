package com.bytedance.android.shopping.store.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final int[] a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getGoneViewSize");
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{r3.getMeasuredWidth(), r3.getMeasuredHeight()};
    }
}
