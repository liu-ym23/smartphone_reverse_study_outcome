package nc3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final List<Integer> f(List<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toIntList");
        List<?> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L24;
        Object r1 = r6.next();
        if ((r1 instanceof Integer) == false) goto L9;
        int r2 = ((Number) r1).intValue();
    L23:
        r0.add(Integer.valueOf(r2));
        goto L4
    L9:
        if ((r1 instanceof Float) == false) goto L12;
        r2 = (int) ((Number) r1).floatValue();
        goto L23
    L12:
        if ((r1 instanceof Double) == false) goto L15;
        r2 = (int) ((Number) r1).doubleValue();
        goto L23
    L15:
        if ((r1 instanceof Long) == false) goto L18;
        r2 = (int) ((Number) r1).longValue();
        goto L23
    L18:
        if ((r1 instanceof String) == false) goto L22;
        Integer r3 = StringsKt.toIntOrNull((String) r1);
        if (r3 == null) goto L22;
        r2 = r3.intValue();
    L22:
        r2 = 0;
        goto L23
    L24:
        return r0;
    }

    public static final Map<String, Object> g(Map<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toStringAnyMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<?, ?>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map.Entry<?, ?> r1 = r4.next();
        if (r1.getKey() == null) goto L4;
        r0.put(String.valueOf(r1.getKey()), r1.getValue());
        goto L4
    L8:
        return r0;
    }

    public static /* synthetic */ long d(Map r2, String r3) {
        return c(r2, r3, 0);
    }

    public static final Boolean a(Map<?, ?> r1, String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$getBoolean");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.get(r2);
        if ((r4 instanceof Boolean) == true) goto L5;
        r4 = null;
    L5:
        Boolean r5 = (Boolean) r4;
        if (r5 != null) goto L9;
        return r3;
    L9:
        return r5;
    }

    public static final int b(Map<?, ?> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$getInt");
        Intrinsics.checkNotNullParameter(r3, "key");
        return (int) c(r2, r3, r4);
    }

    public static final long c(Map<?, ?> r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$getLong");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.get(r2);
        if ((r4 instanceof Long) == false) goto L6;
        return ((Number) r4).longValue();
    L6:
        if ((r4 instanceof Integer) == false) goto L9;
        return ((Number) r4).intValue();
    L9:
        if ((r4 instanceof Float) == false) goto L12;
        return (long) ((Number) r4).floatValue();
    L12:
        if ((r4 instanceof Double) == false) goto L15;
        return (long) ((Number) r4).doubleValue();
    L15:
        if ((r4 instanceof String) == false) goto L24;
        Long r5 = StringsKt.toLongOrNull((String) r4);
        if (r5 != null) goto L19;
        return r3;
    L19:
        return r5.longValue();
    L24:
        return r3;
    }

    public static final String e(Map<?, ?> r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$getString");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.get(r2);
        if (r4 == null) goto L9;
        String r5 = r4.toString();
        if (r5 != null) goto L8;
        return r3;
    L8:
        return r5;
    L9:
        return r3;
    }
}
