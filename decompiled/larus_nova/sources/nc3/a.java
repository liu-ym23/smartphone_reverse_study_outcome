package nc3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final List<Integer> f(List<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toIntList");
        List<?> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L24;
        Object r104 = r103.next();
        if ((r104 instanceof Integer) == false) goto L9;
        int r105 = ((Number) r104).intValue();
    L23:
        r102.add(Integer.valueOf(r105));
        goto L4
    L9:
        if ((r104 instanceof Float) == false) goto L12;
        r105 = (int) ((Number) r104).floatValue();
        goto L23
    L12:
        if ((r104 instanceof Double) == false) goto L15;
        r105 = (int) ((Number) r104).doubleValue();
        goto L23
    L15:
        if ((r104 instanceof Long) == false) goto L18;
        r105 = (int) ((Number) r104).longValue();
        goto L23
    L18:
        if ((r104 instanceof String) == false) goto L22;
        Integer r106 = StringsKt.toIntOrNull((String) r104);
        if (r106 == null) goto L22;
        r105 = r106.intValue();
    L22:
        r105 = 0;
        goto L23
    L24:
        return r102;
    }

    public static final Map<String, Object> g(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toStringAnyMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<?, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<?, ?> r103 = r102.next();
        if (r103.getKey() == null) goto L4;
        r101.put(String.valueOf(r103.getKey()), r103.getValue());
        goto L4
    L8:
        return r101;
    }

    public static /* synthetic */ long d(Map r100, String r101) {
        return c(r100, r101, 0);
    }

    public static final Boolean a(Map<?, ?> r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getBoolean");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);
        if ((r103 instanceof Boolean) == true) goto L5;
        r103 = null;
    L5:
        Boolean r104 = (Boolean) r103;
        if (r104 != null) goto L9;
        return r102;
    L9:
        return r104;
    }

    public static final int b(Map<?, ?> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getInt");
        Intrinsics.checkNotNullParameter(r101, "key");
        return (int) c(r100, r101, r102);
    }

    public static final long c(Map<?, ?> r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLong");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);
        if ((r103 instanceof Long) == false) goto L6;
        return ((Number) r103).longValue();
    L6:
        if ((r103 instanceof Integer) == false) goto L9;
        return ((Number) r103).intValue();
    L9:
        if ((r103 instanceof Float) == false) goto L12;
        return (long) ((Number) r103).floatValue();
    L12:
        if ((r103 instanceof Double) == false) goto L15;
        return (long) ((Number) r103).doubleValue();
    L15:
        if ((r103 instanceof String) == false) goto L24;
        Long r104 = StringsKt.toLongOrNull((String) r103);
        if (r104 != null) goto L19;
        return r102;
    L19:
        return r104.longValue();
    L24:
        return r102;
    }

    public static final String e(Map<?, ?> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getString");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);
        if (r103 == null) goto L9;
        String r104 = r103.toString();
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }
}
