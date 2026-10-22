package com.bytedance.android.shopping.feed.utils;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final HashSet<String> a = null;

    static {
        a = new HashSet();
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r1 = a.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L13;
        String r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r0.append(r3);
        if (r2 >= (a.size() - 1)) goto L11;
        r0.append(",");
    L11:
        r2 = r4;
        goto L4
    L13:
        return r0.toString();
    }
}
