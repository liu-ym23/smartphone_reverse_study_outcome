package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.utils.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 {
    public static final int[] a = null;
    public static int b;

    static {
        a = new int[2];
    }

    public static int a() {
        if (b > 0) goto L6;
        b = k1.p();
    L6:
        return b;
    }
}
