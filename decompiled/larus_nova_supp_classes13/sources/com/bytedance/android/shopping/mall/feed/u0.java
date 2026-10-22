package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class u0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ECMallFeedState.values().length];
        a = r0;
        r0[ECMallFeedState.PREPARING.ordinal()] = 1;
        r0[ECMallFeedState.INIT_SUCCESS.ordinal()] = 2;
        r0[ECMallFeedState.PREPARE_FAILED.ordinal()] = 3;
        r0[ECMallFeedState.INIT_FAILED.ordinal()] = 4;
        r0[ECMallFeedState.REFRESHING.ordinal()] = 5;
        r0[ECMallFeedState.REFRESH_SUCCESS.ordinal()] = 6;
    }
}
