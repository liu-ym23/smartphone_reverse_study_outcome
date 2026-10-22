package q68;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.e0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes24.dex */
public final class d {
    public static final d0 c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L20;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        Object r104 = r103.getValue();
        if (r104 != null) goto L9;
        Object r105 = a0.INSTANCE;
    L18:
        String r106 = r103.getKey();
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r105, "element");
        i r107 = (i) r101.put(r106, r105);
        goto L4
    L9:
        if ((r104 instanceof i) == false) goto L12;
        r105 = (i) r104;
        goto L18
    L12:
        if ((r104 instanceof Boolean) == false) goto L15;
        r105 = k.a((Boolean) r104);
        goto L18
    L15:
        if ((r104 instanceof Number) == false) goto L17;
        r105 = k.b((Number) r104);
        goto L18
    L17:
        r105 = k.c(r104.toString());
        goto L18
    L20:
        return new d0(r101);
    }

    public static final d0 a(d0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        return r100;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<String> r103 = r100.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (StringsKt.isBlank(r104) == true) goto L7;
        i r105 = (i) r100.get(r104);
        if (r105 == null) goto L7;
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r105, "element");
        i r106 = (i) r102.put(r104, r105);
        goto L7
    L14:
        Iterator<String> r107 = r101.keySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L24;
        String r108 = r107.next();
        if (StringsKt.isBlank(r108) == true) goto L16;
        i r109 = (i) r101.get(r108);
        if (r109 == null) goto L16;
        Intrinsics.checkNotNullParameter(r108, "key");
        Intrinsics.checkNotNullParameter(r109, "element");
        i r110 = (i) r102.put(r108, r109);
        goto L16
    L24:
        return new d0(r102);
    }

    public static final void b(e0 r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r100.b(r101, k.c(r102));
    }
}
