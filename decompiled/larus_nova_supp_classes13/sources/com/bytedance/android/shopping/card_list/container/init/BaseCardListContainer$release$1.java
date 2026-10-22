package com.bytedance.android.shopping.card_list.container.init;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BaseCardListContainer$release$1 extends MutablePropertyReference0Impl {
    public BaseCardListContainer$release$1(BaseCardListContainer r7) {
        super(r7, BaseCardListContainer.class, "sessionId", "getSessionId()Ljava/lang/String;", 0);
    }

    public Object get() {
        String r0 = ((BaseCardListContainer) ((CallableReference) this).receiver).l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
    L5:
        return r0;
    }

    public void set(Object r2) {
        String r3 = (String) r2;
        ((BaseCardListContainer) ((CallableReference) this).receiver).l = r3;
    }
}
