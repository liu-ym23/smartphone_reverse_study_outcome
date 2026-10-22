package com.bytedance.android.shopping.store.aggregate.presenter;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LayoutTypes.values().length];
        a = r0;
        LayoutTypes r1 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        r0[r1.ordinal()] = 1;
        LayoutTypes r2 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[LayoutTypes.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
