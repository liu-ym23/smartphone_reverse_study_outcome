package com.bytedance.ee.bear.widgets.menuconfig;

import com.larus.platform.api.creation.TplType;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeSpaceMenuConfigSorter {

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f240240a;

        public a(Map r100) {
            this.f240240a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = (Integer) this.f240240a.get(((g) r100).f240259c);
            if (r102 != null) goto L6;
            r102 = Integer.MAX_VALUE;
        L6:
            int r103 = (Integer) this.f240240a.get(((g) r101).f240259c);
            if (r103 != null) goto L11;
            r103 = Integer.MAX_VALUE;
        L11:
            return ComparisonsKt.compareValues(r102, r103);
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f240241a;

        public b(a r100) {
            this.f240241a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f240241a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((g) r100).f240260d), Integer.valueOf(((g) r101).f240260d));
        }
    }

    static {
    }

    public static List a(e r100) {
        Intrinsics.checkNotNullParameter(r100, TplType.MENU);
        List<f> r101 = r100.f240252c;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((f) r104).f240255b == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        final LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        r105.put(((f) r107).f240254a, r107);
        goto L10
    L12:
        LinkedHashMap r108 = new LinkedHashMap(MapsKt.mapCapacity(r105.size()));
        Iterator r109 = r105.entrySet().iterator();
    L14:
        if (r109.hasNext() == false) goto L17;
        Map.Entry r110 = (Map.Entry) r109.next();
        r108.put(r110.getKey(), Integer.valueOf(((f) r110.getValue()).f240256c));
        goto L14
    L17:
        return SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r100.f240253d), OfficeSpaceMenuConfigSorter$orderedVisibleItems$1.INSTANCE), new OfficeSpaceMenuConfigSorter$orderedVisibleItems$2(r105)), new b(new a(r108))));
    }
}
