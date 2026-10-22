package lk9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((f) r101).f509628a.f509612d, ((f) r100).f509628a.f509612d);
        }
    }

    static {
    }

    public static Map a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "applicants");
        List r101 = CollectionsKt.sortedWith(r100, new a());
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L10;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r102.add(TuplesKt.to((f) r105, Float.valueOf((float) Math.pow(0.2f, r104))));
        r104 = r106;
        goto L4
    L10:
        return MapsKt.toMap(r102);
    }
}
