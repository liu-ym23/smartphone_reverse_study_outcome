package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final IntRange a = null;

    static {
        a = new IntRange(100000, 199999);
        new IntRange(600, 699);
    }

    public static final boolean a(int r2) {
        return a.contains(r2 & (-1073741825));
    }
}
