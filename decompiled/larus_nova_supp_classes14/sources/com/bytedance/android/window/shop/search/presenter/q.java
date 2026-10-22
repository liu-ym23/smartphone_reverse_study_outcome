package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class q {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[WindowLoadStatus.values().length];
        a = r0;
        r0[WindowLoadStatus.Initialize.ordinal()] = 1;
        r0[WindowLoadStatus.InitializeSuccess.ordinal()] = 2;
        r0[WindowLoadStatus.InitializeError.ordinal()] = 3;
        r0[WindowLoadStatus.InitializeEmpty.ordinal()] = 4;
    }
}
