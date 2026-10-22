package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PageListLoadStatus.values().length];
        a = r0;
        PageListLoadStatus r1 = PageListLoadStatus.LoadMoreIn;
        r0[r1.ordinal()] = 1;
        PageListLoadStatus r2 = PageListLoadStatus.LoadMoreError;
        r0[r2.ordinal()] = 2;
        PageListLoadStatus r4 = PageListLoadStatus.LoadMoreEnd;
        r0[r4.ordinal()] = 3;
        PageListLoadStatus r6 = PageListLoadStatus.LoadMoreSuccess;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[PageListLoadStatus.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
    }
}
