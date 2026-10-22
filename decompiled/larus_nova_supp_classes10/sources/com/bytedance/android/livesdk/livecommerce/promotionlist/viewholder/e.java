package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PageListLoadStatus.values().length];
        a = r0;
        r0[PageListLoadStatus.LoadMoreIn.ordinal()] = 1;
        r0[PageListLoadStatus.LoadMoreError.ordinal()] = 2;
        r0[PageListLoadStatus.LoadMoreSuccess.ordinal()] = 3;
        r0[PageListLoadStatus.LoadMoreEnd.ordinal()] = 4;
    }
}
