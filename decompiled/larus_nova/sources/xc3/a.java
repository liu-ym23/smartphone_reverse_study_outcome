package xc3;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563207a = 0;

    static {
    }

    public static void a(Map r100, Map r101) {
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L26;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L4;
        Object r106 = r100.get(r104);
        boolean r107 = r106 instanceof Map;
        if (r107 == false) goto L25;
        boolean r108 = r105 instanceof Map;
        if (r108 == false) goto L25;
        Map r109 = null;
        if (r107 == true) goto L14;
        r106 = null;
    L14:
        Map r110 = (Map) r106;
        if (r110 == null) goto L24;
        Map r111 = MapsKt.toMutableMap(r110);
        if (r111 == null) goto L24;
        if (r108 == true) goto L20;
        r105 = null;
    L20:
        Map r112 = (Map) r105;
        if (r112 != null) goto L23;
        r112 = MapsKt.emptyMap();
    L23:
        r111.putAll(r112);
        Unit r113 = Unit.INSTANCE;
        r109 = r111;
    L24:
        r100.put(r104, r109);
    L25:
        r100.put(r104, r105);
        goto L4
    }

    public static void b(c r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "data");
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        if ((!Intrinsics.areEqual((String) r104.getKey(), "state")) == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L9:
        if ((!r102.isEmpty()) == false) goto L11;
        Map<String, ? extends Object> r105 = MapsKt.toMutableMap(r100.f173408a);
        a(r105, r102);
        r100.c(r105);
    L11:
        Object r106 = r101.get("state");
        if ((r106 instanceof Map) == true) goto L14;
        r106 = null;
    L14:
        Map r107 = (Map) r106;
        if (r107 == null) goto L22;
        Map<String, Object> r108 = r100.f173410c;
        if (r108 == null) goto L20;
        Map<String, ? extends Object> r109 = MapsKt.toMutableMap(r108);
        if (r109 == null) goto L20;
    L21:
        a(r109, r107);
        r100.e(r109);
    L20:
        r109 = new LinkedHashMap();
    L22:
        r100.b();
    }
}
