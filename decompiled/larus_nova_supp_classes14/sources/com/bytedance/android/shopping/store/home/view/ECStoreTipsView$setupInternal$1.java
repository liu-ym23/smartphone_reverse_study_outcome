package com.bytedance.android.shopping.store.home.view;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStoreTipsView$setupInternal$1 extends MutablePropertyReference0Impl {
    public ECStoreTipsView$setupInternal$1(p r7) {
        super(r7, p.class, "text", "getText()Landroid/widget/TextView;", 0);
    }

    public Object get() {
        TextView r0 = ((p) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("text");
    L5:
        return r0;
    }

    public void set(Object r2) {
        TextView r3 = (TextView) r2;
        ((p) ((CallableReference) this).receiver).d = r3;
    }
}
