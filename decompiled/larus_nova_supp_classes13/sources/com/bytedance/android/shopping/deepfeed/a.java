package com.bytedance.android.shopping.deepfeed;

import com.bytedance.android.shopping.inflow.common.base.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LoadStatus.values().length];
        a = r0;
        r0[LoadStatus.LOADING.ordinal()] = 1;
        r0[LoadStatus.FINISH_NO_MORE.ordinal()] = 2;
        r0[LoadStatus.PACK_ERROR.ordinal()] = 3;
        r0[LoadStatus.FINISH_ERROR.ordinal()] = 4;
    }
}
