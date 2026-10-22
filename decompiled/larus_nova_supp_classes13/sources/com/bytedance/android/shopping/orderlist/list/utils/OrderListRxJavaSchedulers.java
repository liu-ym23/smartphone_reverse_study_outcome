package com.bytedance.android.shopping.orderlist.list.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListRxJavaSchedulers {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(OrderListRxJavaSchedulers$highPriorityExecutor$2.INSTANCE);
    }
}
