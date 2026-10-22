package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PackDataParser$updateResponse$1 extends MutablePropertyReference0Impl {
    public PackDataParser$updateResponse$1(g r7) {
        super(r7, g.class, "componentList", "getComponentList()Ljava/util/List;", 0);
    }

    public Object get() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = ((g) ((CallableReference) this).receiver).e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L5:
        return r0;
    }

    public void set(Object r2) {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r3 = (List) r2;
        ((g) ((CallableReference) this).receiver).e = r3;
    }
}
