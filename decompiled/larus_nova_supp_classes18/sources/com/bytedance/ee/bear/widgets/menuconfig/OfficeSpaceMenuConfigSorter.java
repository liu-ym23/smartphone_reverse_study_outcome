package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSpaceMenuConfigSorter {

    public static final class a<T> implements Comparator {
        public final /* synthetic */ Map a;

        public a(Map r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r5 = (Integer) this.a.get(((g) r3).c);
            if (r5 != null) goto L6;
            r5 = Integer.MAX_VALUE;
        L6:
            int r6 = (Integer) this.a.get(((g) r4).c);
            if (r6 != null) goto L11;
            r6 = Integer.MAX_VALUE;
        L11:
            return ComparisonsKt.compareValues(r5, r6);
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((g) r2).d), Integer.valueOf(((g) r3).d));
        }
    }

    static {
    }

    public static List a(e r5) {
        Intrinsics.checkNotNullParameter(r5, "menu");
        List<f> r0 = r5.c;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((f) r3).b == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        final LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r6 = r1.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Object r7 = r6.next();
        r4.put(((f) r7).a, r7);
        goto L10
    L12:
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r9 = r4.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.put(r10.getKey(), Integer.valueOf(((f) r10.getValue()).c));
        goto L14
    L17:
        return SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r5.d), OfficeSpaceMenuConfigSorter$orderedVisibleItems$1.INSTANCE), new OfficeSpaceMenuConfigSorter$orderedVisibleItems$2(r4)), new b(new a(r8))));
    }
}
