package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CartDialogFragment$onDestroy$2$1 extends MutablePropertyReference0Impl {
    public CartDialogFragment$onDestroy$2$1(CartDialogFragment r7) {
        super(r7, CartDialogFragment.class, "yataInstance", "getYataInstance()Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", 0);
    }

    public Object get() {
        return ((CartDialogFragment) ((CallableReference) this).receiver).ca0();
    }

    public void set(Object r3) {
        CartDialogFragment r0 = (CartDialogFragment) ((CallableReference) this).receiver;
        AndroidYaTaInstance r4 = (AndroidYaTaInstance) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.p = r4;
    }
}
