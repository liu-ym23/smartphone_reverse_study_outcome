package hv3;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {
    public static final int[] a(List<? extends List<String>> r100, List<? extends Number> r101) {
        Intrinsics.checkNotNullParameter(r100, "columns");
        int[] r102 = new int[r100.size()];
        Iterator<T> r103 = r100.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L25;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        List r107 = (List) r105;
        if (r101 == null) goto L20;
        Number r108 = (Number) CollectionsKt.getOrNull(r101, r104);
        if (r108 == null) goto L20;
        Integer r109 = Integer.valueOf(r108.intValue());
        int r110 = r109.intValue();
        if (r110 >= 0) goto L15;
    L17:
        boolean r111 = false;
    L18:
        if (r111 == false) goto L20;
    L21:
        if (r109 == null) goto L23;
        int r112 = r109.intValue();
    L24:
        r102[r104] = r112;
        r104 = r106;
        goto L4
    L23:
        r112 = r107.size() / 2;
        goto L24
    L15:
        if (r110 >= r107.size()) goto L17;
        r111 = true;
    L20:
        r109 = null;
        goto L21
    L25:
        return r102;
    }
}
