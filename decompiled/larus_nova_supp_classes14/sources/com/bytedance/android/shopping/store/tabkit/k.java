package com.bytedance.android.shopping.store.tabkit;

import android.util.SparseArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static Long a;
    public static final SparseArray<Long> b = null;

    static {
        b = new SparseArray();
    }

    public static Long a(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
        return b.get(r2);
    L4:
        return null;
    }
}
