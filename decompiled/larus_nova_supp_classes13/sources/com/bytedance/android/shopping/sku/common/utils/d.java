package com.bytedance.android.shopping.sku.common.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final void b(List<? extends a> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$startSkuTaskList");
        Iterator<T> r0 = r4.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r5 = (a) CollectionsKt.getOrNull(r4, r3);
        ((a) r2).a = r5;
        r1 = r3;
        goto L4
    L9:
        a r6 = (a) CollectionsKt.firstOrNull(r4);
        if (r6 == null) goto L16;
        r6.a();
        return;
    }

    public static final SkuCommonTaskUtilsKt$newSkuTask$1 a(String r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "taskName");
        Intrinsics.checkNotNullParameter(r2, "action");
        return new SkuCommonTaskUtilsKt$newSkuTask$1(r1, r2);
    }
}
