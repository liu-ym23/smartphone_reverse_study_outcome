package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageBuilder$build$3 extends MutablePropertyReference0Impl {
    public PageBuilder$build$3(b r7) {
        super(r7, b.class, "monitorService", "getMonitorService$ec_shopping_impl_saasRelease()Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/IMonitorService;", 0);
    }

    public Object get() {
        i r0 = ((b) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("monitorService");
    L5:
        return r0;
    }

    public void set(Object r3) {
        b r0 = (b) ((CallableReference) this).receiver;
        i r4 = (i) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.c = r4;
    }
}
