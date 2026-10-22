package hv3;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final int[] a(List<? extends List<String>> r8, List<? extends Number> r9) {
        Intrinsics.checkNotNullParameter(r8, "columns");
        int[] r0 = new int[r8.size()];
        Iterator<T> r10 = r8.iterator();
        int r2 = 0;
    L4:
        if (r10.hasNext() == false) goto L25;
        Object r3 = r10.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        List r5 = (List) r3;
        if (r9 == null) goto L20;
        Number r6 = (Number) CollectionsKt.getOrNull(r9, r2);
        if (r6 == null) goto L20;
        Integer r7 = Integer.valueOf(r6.intValue());
        int r11 = r7.intValue();
        if (r11 >= 0) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L20;
    L21:
        if (r7 == null) goto L23;
        int r13 = r7.intValue();
    L24:
        r0[r2] = r13;
        r2 = r4;
        goto L4
    L23:
        r13 = r5.size() / 2;
        goto L24
    L15:
        if (r11 >= r5.size()) goto L17;
        r12 = true;
    L20:
        r7 = null;
        goto L21
    L25:
        return r0;
    }
}
