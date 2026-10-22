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

/* JADX INFO: loaded from: classes10.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f566906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<NavigationTransport.TransportType, i> f566907b = null;

    static {
        f566906a = new Object();
        LinkedHashMap r100 = new LinkedHashMap();
        f566907b = r100;
        r100.put(NavigationTransport.TransportType.Walking, new n());
        r100.put(NavigationTransport.TransportType.Bicycling, new l());
        r100.put(NavigationTransport.TransportType.EBicycling, new m());
    }

    public static i a(NavigationTransport.TransportType r100) {
        Intrinsics.checkNotNullParameter(r100, "transportType");
        Object r101 = f566906a;
        monitor-enter(r101);
        i r102 = (i) ((LinkedHashMap) f566907b).get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(List r100) {
        Object r101 = f566906a;
        monitor-enter(r101);
        if (r100 != null) goto L36;
    L33:
        monitor-exit(r101);
        return;
    L36:
        List r102 = r100;     // Catch: Throwable -> L14 Exception -> L16
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));     // Catch: Throwable -> L14 Exception -> L16
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r104.hasNext() == false) goto L33;
        j r105 = (j) r104.next();     // Catch: Throwable -> L14 Exception -> L16
        int r106 = NavigationTransport.f200064a;     // Catch: Throwable -> L14 Exception -> L16
        String r107 = r105.f566899a;     // Catch: Throwable -> L14 Exception -> L16
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        Intrinsics.checkNotNullParameter(r107, "code");     // Catch: Throwable -> L14 Exception -> L16
        NavigationTransport.TransportType.Companion.getClass();     // Catch: Throwable -> L14 Exception -> L16
        Intrinsics.checkNotNullParameter(r107, "code");     // Catch: Throwable -> L14 Exception -> L16
        NavigationTransport.TransportType r108 = (NavigationTransport.TransportType) NavigationTransport.TransportType.access$getCodeMap$cp().get(r107);     // Catch: Throwable -> L14 Exception -> L16
        if (r108 != null) goto L18;
        r108 = NavigationTransport.TransportType.Walking;     // Catch: Throwable -> L14 Exception -> L16
    L18:
        Map<NavigationTransport.TransportType, i> r109 = f566907b;     // Catch: Throwable -> L14 Exception -> L16
        if (((LinkedHashMap) r109).keySet().contains(r108) == false) goto L20;
        i r110 = (i) ((LinkedHashMap) r109).get(r108);     // Catch: Throwable -> L14 Exception -> L16
        if (r110 == null) goto L24;
        r110.a(r105);     // Catch: Throwable -> L14 Exception -> L16
        r103.add(Unit.INSTANCE);     // Catch: Throwable -> L14 Exception -> L16
        goto L6
    L24:
        monitor-exit(r101);
        return;
    L20:
        monitor-exit(r101);
        return;
    L16:
        e = move-exception;
        com.bytedance.bdnavigationsdk.e r111 = r84.a.f536505a;     // Catch: Throwable -> L14
        r84.a.b("解析 JSON 失败，" + e.getMessage(), null, 5);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
