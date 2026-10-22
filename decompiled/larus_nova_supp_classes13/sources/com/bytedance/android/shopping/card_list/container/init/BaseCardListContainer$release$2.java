package com.bytedance.android.shopping.card_list.container.init;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BaseCardListContainer$release$2 extends MutablePropertyReference0Impl {
    public BaseCardListContainer$release$2(BaseCardListContainer r7) {
        super(r7, BaseCardListContainer.class, "objectContainer", "getObjectContainer()Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", 0);
    }

    public Object get() {
        return ((BaseCardListContainer) ((CallableReference) this).receiver).f();
    }

    public void set(Object r3) {
        BaseCardListContainer r0 = (BaseCardListContainer) ((CallableReference) this).receiver;
        CardListObjectContainer r4 = (CardListObjectContainer) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
