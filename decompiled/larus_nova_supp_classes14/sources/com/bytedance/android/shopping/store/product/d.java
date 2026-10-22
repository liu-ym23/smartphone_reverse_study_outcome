package com.bytedance.android.shopping.store.product;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LoadStatus.values().length];
        a = r0;
        r0[LoadStatus.LoadMoreEnd.ordinal()] = 1;
        r0[LoadStatus.LoadMoreIn.ordinal()] = 2;
        r0[LoadStatus.LoadMoreError.ordinal()] = 3;
    }
}
