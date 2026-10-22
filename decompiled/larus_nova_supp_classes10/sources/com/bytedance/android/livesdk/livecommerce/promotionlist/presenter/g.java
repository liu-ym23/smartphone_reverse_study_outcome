package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PageListLoadStatus.values().length];
        a = r0;
        r0[PageListLoadStatus.Initialize.ordinal()] = 1;
        r0[PageListLoadStatus.InitializeSuccess.ordinal()] = 2;
        r0[PageListLoadStatus.InitializeEmpty.ordinal()] = 3;
        r0[PageListLoadStatus.InitializeError.ordinal()] = 4;
    }
}
