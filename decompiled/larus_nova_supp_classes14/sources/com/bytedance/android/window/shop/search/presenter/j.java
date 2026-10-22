package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[WindowLayoutTypes.values().length];
        a = r0;
        WindowLayoutTypes r1 = WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        r0[r1.ordinal()] = 1;
        WindowLayoutTypes r2 = WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[WindowLayoutTypes.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
