package com.bytedance.assem.arch.view;

import com.bytedance.assem.arch.core.InflateMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[InflateMode.values().length];
        a = r0;
        r0[InflateMode.ASYNC.ordinal()] = 1;
        r0[InflateMode.X2C.ordinal()] = 2;
        r0[InflateMode.SYNC.ordinal()] = 3;
    }
}
