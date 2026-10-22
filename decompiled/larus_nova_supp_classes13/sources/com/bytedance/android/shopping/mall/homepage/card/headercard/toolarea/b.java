package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        a.C0099a r5 = (a.C0099a) r3;
        int r1 = 99;
        if (r5.b == null) goto L7;
        Integer r6 = r5.c;
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        Integer r8 = Integer.valueOf(r7);
        a.C0099a r9 = (a.C0099a) r4;
        if (r9.b == null) goto L14;
        Integer r10 = r9.c;
        if (r10 == null) goto L14;
        r1 = r10.intValue();
    L14:
        return ComparisonsKt.compareValues(r8, Integer.valueOf(r1));
    L7:
        r7 = 99;
        goto L8
    }
}
