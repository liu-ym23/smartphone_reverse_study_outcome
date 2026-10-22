package y84;

import com.bytedance.bdnavigationsdk.navigation.NavigationTransport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o {
    public static final Object a = null;
    public static final Map<NavigationTransport.TransportType, i> b = null;

    static {
        a = new Object();
        LinkedHashMap r0 = new LinkedHashMap();
        b = r0;
        r0.put(NavigationTransport.TransportType.Walking, new n());
        r0.put(NavigationTransport.TransportType.Bicycling, new l());
        r0.put(NavigationTransport.TransportType.EBicycling, new m());
    }

    public static i a(NavigationTransport.TransportType r2) {
        Intrinsics.checkNotNullParameter(r2, "transportType");
        Object r0 = a;
        monitor-enter(r0);
        i r3 = (i) ((LinkedHashMap) b).get(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(List r6) {
        Object r0 = a;
        monitor-enter(r0);
        if (r6 != null) goto L36;
    L33:
        monitor-exit(r0);
        return;
    L36:
        List r7 = r6;     // Catch: Throwable -> L14 Exception -> L16
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L14 Exception -> L16
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r8.hasNext() == false) goto L33;
        j r2 = (j) r8.next();     // Catch: Throwable -> L14 Exception -> L16
        int r3 = NavigationTransport.a;     // Catch: Throwable -> L14 Exception -> L16
        String r4 = r2.a;     // Catch: Throwable -> L14 Exception -> L16
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        Intrinsics.checkNotNullParameter(r4, "code");     // Catch: Throwable -> L14 Exception -> L16
        NavigationTransport.TransportType.Companion.getClass();     // Catch: Throwable -> L14 Exception -> L16
        Intrinsics.checkNotNullParameter(r4, "code");     // Catch: Throwable -> L14 Exception -> L16
        NavigationTransport.TransportType r5 = (NavigationTransport.TransportType) NavigationTransport.TransportType.access$getCodeMap$cp().get(r4);     // Catch: Throwable -> L14 Exception -> L16
        if (r5 != null) goto L18;
        r5 = NavigationTransport.TransportType.Walking;     // Catch: Throwable -> L14 Exception -> L16
    L18:
        Map<NavigationTransport.TransportType, i> r9 = b;     // Catch: Throwable -> L14 Exception -> L16
        if (((LinkedHashMap) r9).keySet().contains(r5) == false) goto L20;
        i r10 = (i) ((LinkedHashMap) r9).get(r5);     // Catch: Throwable -> L14 Exception -> L16
        if (r10 == null) goto L24;
        r10.a(r2);     // Catch: Throwable -> L14 Exception -> L16
        r1.add(Unit.INSTANCE);     // Catch: Throwable -> L14 Exception -> L16
        goto L6
    L24:
        monitor-exit(r0);
        return;
    L20:
        monitor-exit(r0);
        return;
    L16:
        e = move-exception;
        com.bytedance.bdnavigationsdk.e r11 = r84.a.a;     // Catch: Throwable -> L14
        r84.a.b("解析 JSON 失败，" + e.getMessage(), null, 5);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
