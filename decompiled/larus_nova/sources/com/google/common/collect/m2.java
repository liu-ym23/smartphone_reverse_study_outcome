package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class m2 {
    public static boolean a(Comparator<?> r100, Iterable<?> r101) {
        r100.getClass();
        r101.getClass();
        if ((r101 instanceof SortedSet) == false) goto L8;
        Object r102 = ((SortedSet) r101).comparator();
        if (r102 != null) goto L11;
        r102 = Ordering.natural();
    L11:
        return r100.equals(r102);
    L8:
        if ((r101 instanceof l2) == false) goto L12;
        r102 = ((l2) r101).comparator();
        goto L11
    L12:
        return false;
    }
}
