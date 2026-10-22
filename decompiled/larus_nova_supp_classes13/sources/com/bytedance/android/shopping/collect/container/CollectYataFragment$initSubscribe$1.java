package com.bytedance.android.shopping.collect.container;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CollectYataFragment$initSubscribe$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new CollectYataFragment$initSubscribe$1();
    }

    public CollectYataFragment$initSubscribe$1() {
        super(CollectYataState.class, "refreshProtocolAction", "getRefreshProtocolAction()Lcom/bytedance/android/ec/core/data/Action;", 0);
    }

    public Object get(Object r1) {
        return ((CollectYataState) r1).b;
    }
}
