package com.bytedance.android.shopping.orderlist.common.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[InflaterPriority.values().length];
        a = r0;
        r0[InflaterPriority.ORIGIN_ASYNC_CONTEXT.ordinal()] = 1;
        r0[InflaterPriority.ASYNC_ORIGIN_CONTEXT.ordinal()] = 2;
        r0[InflaterPriority.CONTEXT_ORIGIN_ASYNC.ordinal()] = 3;
    }
}
