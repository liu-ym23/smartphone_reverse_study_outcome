package jc1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public static final List<String> a(List<Long> r100) {
        if (r100 == null) goto L4;
        List<Long> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(String.valueOf(((Number) r103.next()).longValue()));
        goto L7
    L9:
        return r102;
    L4:
        return CollectionsKt.emptyList();
    }
}
