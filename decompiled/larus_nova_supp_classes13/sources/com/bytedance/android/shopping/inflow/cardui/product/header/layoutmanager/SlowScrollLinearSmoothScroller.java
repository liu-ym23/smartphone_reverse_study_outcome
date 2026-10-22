package com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/layoutmanager/SlowScrollLinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlowScrollLinearSmoothScroller extends LinearSmoothScroller {
    public final float a;

    public final float calculateSpeedPerPixel(DisplayMetrics r2) {
        Intrinsics.checkNotNullParameter(r2, "displayMetrics");
        return this.a / r2.density;
    }

    public SlowScrollLinearSmoothScroller(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
    }
}
