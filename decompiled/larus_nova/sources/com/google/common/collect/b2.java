package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class b2 {
    public static void a(Object[] r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r100[r102] == null) goto L8;
        r102 = r102 + 1;
        goto L3
    L8:
        throw new NullPointerException("at index " + r102);
    }

    public static void b(Iterable r100, Object[] r101) {
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        r101[r103] = r102.next();
        r103 = r103 + 1;
        goto L4
    }

    public static <T> T[] c(Collection<?> r100, T[] r101) {
        int r102 = r100.size();
        if (r101.length < r102) goto L5;
    L9:
        b(r100, r101);
        if (r101.length <= r102) goto L12;
        r101[r102] = null;
    L12:
        return r101;
    L5:
        if (r101.length == 0) goto L8;
        r101 = (T[]) Arrays.copyOf(r101, 0);
    L8:
        r101 = (T[]) Arrays.copyOf(r101, r102);
        goto L9
    }
}
