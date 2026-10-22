package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStoreTipsView$setupInternal$2 extends MutablePropertyReference0Impl {
    public ECStoreTipsView$setupInternal$2(p r7) {
        super(r7, p.class, "triangle", "getTriangle()Landroid/view/View;", 0);
    }

    public Object get() {
        View r0 = ((p) ((CallableReference) this).receiver).e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L5:
        return r0;
    }

    public void set(Object r2) {
        View r3 = (View) r2;
        ((p) ((CallableReference) this).receiver).e = r3;
    }
}
