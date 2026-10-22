package com.bytedance.android.shopping.card_list.container.init;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BaseCardListContainer$release$3 extends MutablePropertyReference0Impl {
    public BaseCardListContainer$release$3(BaseCardListContainer r7) {
        super(r7, BaseCardListContainer.class, "yataInstance", "getYataInstance()Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", 0);
    }

    public Object get() {
        AndroidYaTaInstance r0 = ((BaseCardListContainer) ((CallableReference) this).receiver).k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L5:
        return r0;
    }

    public void set(Object r2) {
        AndroidYaTaInstance r3 = (AndroidYaTaInstance) r2;
        ((BaseCardListContainer) ((CallableReference) this).receiver).k = r3;
    }
}
