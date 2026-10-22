package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LoadStatus.values().length];
        a = r0;
        r0[LoadStatus.Initialize.ordinal()] = 1;
        r0[LoadStatus.InitializeSuccess.ordinal()] = 2;
        r0[LoadStatus.InitializeError.ordinal()] = 3;
    }
}
