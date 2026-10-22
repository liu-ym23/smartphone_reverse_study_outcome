package com.bytedance.android.shopping.api.image;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y {
    public static final boolean a(List<e> r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$operationIn");
        if ((!r4.isEmpty()) == false) goto L16;
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if (((e) r0).a(r5) == false) goto L6;
    L12:
        if (((e) r0) != null) goto L20;
        return false;
    L20:
        return true;
    L10:
        r0 = null;
        goto L12
    L16:
        return false;
    }
}
