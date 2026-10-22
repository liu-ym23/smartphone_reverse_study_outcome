package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class a1 {
    @ParametricNullness
    public static <T> T b(Iterable<T> r100) {
        Iterator<T> r101 = r100.iterator();
        T r102 = r101.next();
        if (r101.hasNext() == true) goto L5;
        return r102;
    L5:
        StringBuilder r103 = new StringBuilder("expected one element but was: <");
        r103.append(r102);
        int r104 = 0;
    L7:
        if (r104 >= 4) goto L12;
        if (r101.hasNext() == false) goto L12;
        r103.append(", ");
        r103.append(r101.next());
        r104 = r104 + 1;
    L12:
        if (r101.hasNext() == false) goto L14;
        r103.append(", ...");
    L14:
        r103.append(Typography.greater);
        throw new IllegalArgumentException(r103.toString());
    }

    public static <T> boolean a(Collection<T> r100, Iterable<? extends T> r101) {
        if ((r101 instanceof Collection) == true) goto L5;
        r101.getClass();
        return Iterators.a(r100, r101.iterator());
    L5:
        return r100.addAll((Collection) r101);
    }

    public static <T> boolean c(Iterable<T> r100, com.google.common.base.n<? super T> r101) {
        boolean r102 = false;
        if ((r100 instanceof RandomAccess) == true) goto L5;
    L23:
        Iterator<T> r103 = r100.iterator();
        r101.getClass();
    L25:
        if (r103.hasNext() == false) goto L29;
        if (r101.apply(r103.next()) == false) goto L25;
        r103.remove();
        r102 = true;
        goto L25
    L29:
        return r102;
    L5:
        if ((r100 instanceof List) == false) goto L23;
        List r104 = (List) r100;
        r101.getClass();
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104.size()) goto L18;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r107 = (Object) ListProtector.get(r104, r105);
        if (r101.apply(r107) == true) goto L17;
        if (r105 > r106) goto L30;
    L16:
        r106 = r106 + 1;
        goto L17
    L30:
        ListProtector.set(r104, r106, r107);     // Catch: IllegalArgumentException -> L14 UnsupportedOperationException -> L15
    L14:
        d(r104, r101, r106, r105);
        return true;
    L15:
        d(r104, r101, r106, r105);
        return true;
    L17:
        r105 = r105 + 1;
        goto L8
    L18:
        r104.subList(r106, r104.size()).clear();
        if (r105 == r106) goto L22;
        r102 = true;
    L22:
        return r102;
    }

    public static <T> void d(List<T> r100, com.google.common.base.n<? super T> r101, int r102, int r103) {
        int r104 = r100.size() - 1;
    L3:
        if (r104 <= r103) goto L8;
        if (r101.apply((Object) ListProtector.get(r100, r104)) == false) goto L7;
        ListProtector.remove(r100, r104);
    L7:
        r104 = r104 - 1;
        goto L3
    L8:
        int r105 = r103 - 1;
    L9:
        if (r105 < r102) goto L11;
        ListProtector.remove(r100, r105);
        r105 = r105 - 1;
        goto L9
    }
}
