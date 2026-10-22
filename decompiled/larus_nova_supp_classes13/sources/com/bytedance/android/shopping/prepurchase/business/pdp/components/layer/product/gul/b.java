package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ECMallFeedState.values().length];
        a = r0;
        r0[ECMallFeedState.INIT_FAILED.ordinal()] = 1;
        r0[ECMallFeedState.INITIALIZING.ordinal()] = 2;
        r0[ECMallFeedState.INIT_DATA_PREPARED.ordinal()] = 3;
        r0[ECMallFeedState.INIT_WITH_CACHE_SUCCESS.ordinal()] = 4;
        r0[ECMallFeedState.INIT_SUCCESS.ordinal()] = 5;
    }
}
