package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.viewmodel.CartState;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewCartActivity$initView$2 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new NewCartActivity$initView$2();
    }

    public NewCartActivity$initView$2() {
        super(CartState.class, "fpsValue", "getFpsValue()I", 0);
    }

    public Object get(Object r1) {
        return Integer.valueOf(((CartState) r1).b);
    }

    public void set(Object r1, Object r2) {
        int r3 = ((Number) r2).intValue();
        ((CartState) r1).b = r3;
    }
}
