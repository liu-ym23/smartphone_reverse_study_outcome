package com.bytedance.android.shopping.sameproduct;

import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SameProductListFragment$initSubscribe$4 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SameProductListFragment$initSubscribe$4();
    }

    public SameProductListFragment$initSubscribe$4() {
        super(SameProductState.class, "loadedProductListApi", "getLoadedProductListApi()Z", 0);
    }

    public Object get(Object r1) {
        return Boolean.valueOf(((SameProductState) r1).h);
    }
}
