package com.bytedance.ee.bear.office.common.screenmenu;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;

    public p(o r1, boolean r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.Comparator
    public final int compare(T r4, T r5) {
        int r0 = this.a.compare(r4, r5);
        if (r0 != 0) goto L19;
        Pair r6 = (Pair) r4;
        if (this.b == true) goto L8;
    L10:
        int r7 = 1;
    L11:
        Pair r8 = (Pair) r5;
        if (this.b == true) goto L14;
    L16:
        int r9 = 1;
    L18:
        return ComparisonsKt.compareValues(r7, r9);
    L14:
        if (((Number) r8.getFirst()).intValue() != this.c) goto L16;
        r9 = 0;
        goto L18
    L8:
        if (((Number) r6.getFirst()).intValue() != this.c) goto L10;
        r7 = 0;
        goto L11
    L19:
        return r0;
    }
}
