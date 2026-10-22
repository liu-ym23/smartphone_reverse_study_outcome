package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStockProgressLayout$updateLargeMode$3 extends MutablePropertyReference0Impl {
    public ECStockProgressLayout$updateLargeMode$3(ECStockProgressLayout r7) {
        super(r7, ECStockProgressLayout.class, "svStockLabel", "getSvStockLabel()Landroid/widget/TextView;", 0);
    }

    public Object get() {
        TextView r0 = ((ECStockProgressLayout) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        return r0;
    }

    public void set(Object r2) {
        TextView r3 = (TextView) r2;
        ((ECStockProgressLayout) ((CallableReference) this).receiver).d = r3;
    }
}
