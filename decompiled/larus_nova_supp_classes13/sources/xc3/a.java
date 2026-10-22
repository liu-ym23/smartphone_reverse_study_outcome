package xc3;

import com.bytedance.android.shopping.deepfeed.slice.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r6, Map r7) {
        Iterator r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r0 = (Map.Entry) r8.next();
        String r1 = (String) r0.getKey();
        Object r2 = r0.getValue();
        if (r2 == null) goto L4;
        Object r3 = r6.get(r1);
        boolean r4 = r3 instanceof Map;
        if (r4 == false) goto L25;
        boolean r5 = r2 instanceof Map;
        if (r5 == false) goto L25;
        Map r9 = null;
        if (r4 == true) goto L14;
        r3 = null;
    L14:
        Map r10 = (Map) r3;
        if (r10 == null) goto L24;
        Map r11 = MapsKt.toMutableMap(r10);
        if (r11 == null) goto L24;
        if (r5 == true) goto L20;
        r2 = null;
    L20:
        Map r12 = (Map) r2;
        if (r12 != null) goto L23;
        r12 = MapsKt.emptyMap();
    L23:
        r11.putAll(r12);
        Unit r13 = Unit.INSTANCE;
        r9 = r11;
    L24:
        r6.put(r1, r9);
    L25:
        r6.put(r1, r2);
        goto L4
    }

    public static void b(c r5, Map r6) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r6, "data");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r6.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        if ((!Intrinsics.areEqual((String) r2.getKey(), "state")) == false) goto L4;
        r0.put(r2.getKey(), r2.getValue());
        goto L4
    L9:
        if ((!r0.isEmpty()) == false) goto L11;
        Map<String, ? extends Object> r3 = MapsKt.toMutableMap(r5.a);
        a(r3, r0);
        r5.c(r3);
    L11:
        Object r7 = r6.get("state");
        if ((r7 instanceof Map) == true) goto L14;
        r7 = null;
    L14:
        Map r8 = (Map) r7;
        if (r8 == null) goto L22;
        Map<String, Object> r4 = r5.c;
        if (r4 == null) goto L20;
        Map<String, ? extends Object> r9 = MapsKt.toMutableMap(r4);
        if (r9 == null) goto L20;
    L21:
        a(r9, r8);
        r5.e(r9);
    L20:
        r9 = new LinkedHashMap();
    L22:
        r5.b();
    }
}
