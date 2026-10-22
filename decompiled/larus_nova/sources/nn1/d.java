package nn1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final Map<Long, a> a(Map<Long, b> r110) {
        Intrinsics.checkNotNullParameter(r110, "roomToTags");
        LinkedHashMap r100 = new LinkedHashMap(MapsKt.mapCapacity(r110.size()));
        Iterator<T> r111 = r110.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L15;
        Map.Entry r101 = (Map.Entry) r111.next();
        Object r102 = r101.getKey();
        List<e> r103 = ((b) r101.getValue()).a();
        if (r103 == null) goto L13;
        List<e> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        e r107 = (e) r106.next();
        r105.add(new c(r107.b(), r107.c(), r107.a()));
        goto L9
    L11:
        List r108 = CollectionsKt.toMutableList(r105);
        if (r108 == null) goto L13;
    L14:
        r100.put(r102, new a(r108));
    L13:
        r108 = new ArrayList();
        goto L14
    L15:
        return r100;
    }
}
