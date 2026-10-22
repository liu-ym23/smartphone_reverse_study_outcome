package h09;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zv9.p;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements vx5.b {
    public a() {
    }

    @Override // vx5.b
    public final vx5.e a(vx5.a r210) {
        int r100 = i.f483502a;
        long r101 = System.nanoTime();
        AtomicBoolean r102 = h.f483499a;
        String r103 = r210.f557485a;
        Intrinsics.checkNotNullParameter(r103, "url");
        if (Intrinsics.areEqual(h.b().i(), Boolean.FALSE) == true) goto L26;
        List<String> r104 = h.b().h();
        if (r104 == null) goto L22;
        List<String> r105 = r104;
        if ((r105 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L22;
        String r110 = (String) r106.next();
        if (r110 != null) goto L17;
    L19:
        boolean r111 = false;
    L20:
        if (r111 == false) goto L13;
        boolean r107 = true;
    L23:
        if (r107 == true) goto L26;
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        vx5.e r109 = new vx5.e();
        Object r112 = "skip audit path";
    L80:
        Pair r113 = TuplesKt.to(r109, Long.valueOf((System.nanoTime() - r101) / 1000));
        vx5.e r114 = (vx5.e) r113.component1();
        final long r115 = ((Number) r113.component2()).longValue();
        AtomicBoolean r116 = h.f483499a;
        final String r117 = r210.f557485a;
        Set<String> r118 = r114.f557492a;
        if (r118 != null) goto L83;
    L85:
        final boolean r211 = false;
    L86:
        final String r212 = (String) r112;
        Intrinsics.checkNotNullParameter(r117, "url");
        Intrinsics.checkNotNullParameter(TrafficMetrics.FRPM_TTNET, OnekeyLoginConstants.NET_TYPE);
        int r119 = u09.c.f548208a;
        u09.c.a("security_ttnet_audit_perf", h.b().e(), new f(r115, r117, r211, r212));
        return r114;
    L83:
        if ((!r118.isEmpty()) != true) goto L85;
        r211 = true;
        goto L86
    L30:
        r109 = new vx5.e();
        AtomicBoolean r120 = h.f483499a;
        final String r121 = r210.f557485a;
        List<Header> r122 = r210.f557486b;
        Intrinsics.checkNotNullParameter(TrafficMetrics.FRPM_TTNET, OnekeyLoginConstants.NET_TYPE);
        Intrinsics.checkNotNullParameter(r121, "url");
        Intrinsics.checkNotNullParameter(r122, "requestHeaders");
        List<String> r123 = h.b().b();
        if (r123 != null) goto L33;
    L35:
        boolean r124 = false;
    L36:
        if (r124 == false) goto L56;
        ArrayList r125 = new ArrayList();
        Iterator<T> r126 = r122.iterator();
    L39:
        if (r126.hasNext() == false) goto L49;
        Object r127 = r126.next();
        Header r128 = (Header) r127;
        p r129 = h.b();
        if (r129 == null) goto L44;
        List<String> r130 = r129.b();
        if (r130 == null) goto L44;
    L46:
        if (r130.contains(r128.getName()) == false) goto L39;
        r125.add(r127);
    L44:
        r130 = CollectionsKt.emptyList();
        goto L46
    L49:
        final ArrayList r131 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r132 = r125.iterator();
    L51:
        if (r132.hasNext() == false) goto L54;
        r131.add(((Header) r132.next()).getName());
        goto L51
    L54:
        if ((!r131.isEmpty()) == false) goto L56;
        int r133 = u09.c.f548208a;
        u09.c.a("security_ttnet_audit_report", h.b().g(), new d(r121, r131));
    L56:
        Lazy r134 = h.f483501c;
        if ((!((HashMap) r134.getValue()).isEmpty()) == false) goto L78;
        HashMap r135 = (HashMap) r134.getValue();
        LinkedHashMap r136 = new LinkedHashMap();
        Iterator r137 = r135.entrySet().iterator();
    L60:
        if (r137.hasNext() == false) goto L65;
        Map.Entry r138 = (Map.Entry) r137.next();
        if (StringsKt.contains$default(r121, (String) r138.getKey(), false, 2, null) == false) goto L60;
        r136.put(r138.getKey(), r138.getValue());
        goto L60
    L65:
        List r139 = CollectionsKt.filterNotNull(CollectionsKt.flatten(CollectionsKt.filterNotNull(r136.values())));
        if ((!r139.isEmpty()) == false) goto L77;
        final HashSet r140 = new HashSet();
        Iterator<Header> r141 = r122.iterator();
    L69:
        if (r141.hasNext() == false) goto L74;
        Header r142 = r141.next();
        if (r139.contains(r142.getName()) == false) goto L69;
        r140.add(r142.getName());
        goto L69
    L74:
        if ((!r140.isEmpty()) == false) goto L76;
        int r143 = u09.c.f548208a;
        u09.c.a("security_ttnet_audit_remove", h.b().f(), new e(r121, r140));
    L76:
        Pair r144 = new Pair(CollectionsKt.toSet(r139), "do_audit");
    L79:
        r109.f557492a = (Set) r144.getFirst();
        r112 = r144.getSecond();
        goto L80
    L77:
        r144 = new Pair(null, "not_match");
        goto L79
    L78:
        r144 = new Pair(null, "default");
        goto L79
    L33:
        if ((!r123.isEmpty()) != true) goto L35;
        r124 = true;
        goto L36
    L17:
        if (StringsKt.contains$default(r103, r110, false, 2, null) != true) goto L19;
        r111 = true;
        goto L20
    L9:
        if (r105.isEmpty() == false) goto L11;
    L22:
        r107 = false;
    L26:
        r108 = true;
        goto L28
    }
}
