package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class x0 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LoadStatus.values().length];
        a = r0;
        LoadStatus r1 = LoadStatus.Initialize;
        r0[r1.ordinal()] = 1;
        LoadStatus r2 = LoadStatus.InitializeSuccess;
        r0[r2.ordinal()] = 2;
        LoadStatus r4 = LoadStatus.InitializeError;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[LoadStatus.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
    }
}
