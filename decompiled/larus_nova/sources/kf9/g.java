package kf9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes30.dex */
public final class g {
    public static final d0 b(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i r101 = sf9.a.e(r100);
        if ((r101 instanceof d0) == false) goto L5;
        d0 r102 = (d0) r101;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return new d0(MapsKt.emptyMap());
    L5:
        r102 = null;
        goto L6
    }

    public static final Map<String, Object> c(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Set<Map.Entry<String, i>> r101 = r100.entrySet();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        Pair r105 = TuplesKt.to((String) r104.getKey(), d((i) r104.getValue()));
        r102.put(r105.getFirst(), r105.getSecond());
        goto L4
    L6:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public static final Object d(i r100) {
        if (Intrinsics.areEqual(r100, a0.INSTANCE) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof d0) == false) goto L9;
        return c((d0) r100);
    L9:
        if ((r100 instanceof ouc.b) == false) goto L14;
        ouc.b r101 = k.m(r100);
        ?? r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<i> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L25;
        r102.add(d(r103.next()));
    L25:
        return r102;
    L14:
        g0 r104 = k.o(r100);
        if (r104.c() == true) goto L29;
        r102 = StringsKt.toBooleanStrictOrNull(r104.a());
        if (r102 != 0) goto L25;
        r102 = StringsKt.toLongOrNull(r104.a());
        if (r102 != 0) goto L25;
        r102 = StringsKt.toDoubleOrNull(r104.a());
        if (r102 != 0) goto L25;
        return r104.a();
    L29:
        return r104.a();
    }

    public static final void a(Map<String, Object> r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == null) goto L6;
        r100.put(r101, r102);
        return;
    }
}
