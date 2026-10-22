package com.bytedance.android.shopping.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static String a(List r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$toSplitString");
        Intrinsics.checkNotNullParameter(",", "split");
        StringBuilder r0 = new StringBuilder();
        Iterator r2 = r6.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r0.append((String) r4);
        if (r3 == (((ArrayList) r6).size() - 1)) goto L11;
        r0.append(",");
    L11:
        r3 = r5;
        goto L4
    L13:
        return r0.toString();
    }
}
