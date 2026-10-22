package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.util.SparseArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 {
    public static final <T> void a(SparseArray<T> r3, Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$forEachValue");
        Intrinsics.checkNotNullParameter(r4, "action");
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.invoke(r3.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }
}
