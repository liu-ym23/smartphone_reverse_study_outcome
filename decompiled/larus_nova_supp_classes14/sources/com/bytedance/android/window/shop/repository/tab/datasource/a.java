package com.bytedance.android.window.shop.repository.tab.datasource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    static {
    }

    public static Integer a(Boolean r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L8;
        return 1;
    L8:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L12;
        return 0;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
