package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[WindowLoadStatus.values().length];
        a = r0;
        r0[WindowLoadStatus.LoadMoreEnd.ordinal()] = 1;
        r0[WindowLoadStatus.LoadMoreIn.ordinal()] = 2;
        r0[WindowLoadStatus.LoadMoreError.ordinal()] = 3;
    }
}
