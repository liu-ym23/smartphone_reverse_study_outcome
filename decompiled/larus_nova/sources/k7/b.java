package k7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final <K, V> Map<K, V> a(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<K, ? extends V> r103 = r102.next();
        V r104 = r103.getValue();
        if (r104 == null) goto L4;
        r101.put(r103.getKey(), r104);
        goto L4
    L8:
        return r101;
    }
}
