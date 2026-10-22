package com.bytedance.android.shopping.prepurchase.arch.container;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageBuilder$build$2 extends MutablePropertyReference0Impl {
    public PageBuilder$build$2(b r7) {
        super(r7, b.class, "logService", "getLogService$ec_shopping_impl_saasRelease()Lcom/bytedance/android/ec/host/api/log/ILogService;", 0);
    }

    public Object get() {
        xi.b r0 = ((b) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logService");
    L5:
        return r0;
    }

    public void set(Object r3) {
        b r0 = (b) ((CallableReference) this).receiver;
        xi.b r4 = (xi.b) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
    }
}
