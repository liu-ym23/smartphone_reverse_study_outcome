package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.h;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageBuilder$build$1 extends MutablePropertyReference0Impl {
    public PageBuilder$build$1(b r7) {
        super(r7, b.class, "eventTrackerService", "getEventTrackerService$ec_shopping_impl_saasRelease()Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/IEventTrackerService;", 0);
    }

    public Object get() {
        h r0 = ((b) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventTrackerService");
    L5:
        return r0;
    }

    public void set(Object r3) {
        b r0 = (b) ((CallableReference) this).receiver;
        h r4 = (h) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
