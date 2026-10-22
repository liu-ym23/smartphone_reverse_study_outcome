package com.bytedance.sdk.account.log.util;

import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final String a(long r100) {
        String r101 = String.valueOf(r100);
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        Iterator<Integer> r104 = RangesKt.downTo(r101.length() - 1, 0).iterator();
    L4:
        if (r104.hasNext() == false) goto L12;
        int r105 = ((IntIterator) r104).nextInt();
        if (r103 == 0) goto L10;
        if ((r103 % 3) != 0) goto L10;
        r102.append(',');
    L10:
        r102.append(r101.charAt(r105));
        r103 = r103 + 1;
        goto L4
    L12:
        return r102.reverse().toString();
    }
}
