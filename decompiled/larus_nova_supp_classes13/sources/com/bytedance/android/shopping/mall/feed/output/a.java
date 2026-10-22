package com.bytedance.android.shopping.mall.feed.output;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        a = r0;
        r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r0[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
    }
}
