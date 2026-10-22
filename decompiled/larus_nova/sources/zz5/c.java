package zz5;

import com.bytedance.helios.api.config.ApiStatistics;
import com.bytedance.helios.api.consumer.EventHandler;
import com.bytedance.helios.api.consumer.FrequencyExtra;
import com.bytedance.helios.api.consumer.FrequencyLog;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import gz5.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements EventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<Pair<Long, Integer>>> f574094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f574095b = null;

    public c() {
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final int stage() {
        return 0;
    }

    static {
        f574095b = new c();
        f574094a = new ConcurrentHashMap();
    }

    public static List b(PrivacyEvent r100) {
        List<p> r101 = HeliosEnvImpl.get().f245470m.q();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((p) r104).a().a(r100.f245366c, r100.I) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public static void f(PrivacyEvent r100) {
        Iterator r101 = ((ArrayList) b(r100)).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        p r102 = (p) r101.next();
        e(r102.d(), r102.e());
        ConcurrentHashMap<String, CopyOnWriteArrayList<Pair<Long, Integer>>> r103 = f574094a;
        CopyOnWriteArrayList<Pair<Long, Integer>> r104 = r103.get(r102.d());
        if (r104 != null) goto L10;
        r104 = new CopyOnWriteArrayList();
    L10:
        if (r104.size() < r102.c()) goto L12;
        r104.remove(CollectionsKt.last(r104));
    L12:
        r104.add(new Pair(Long.valueOf(r100.f245376m), Integer.valueOf(r100.f245366c)));
        r103.put(r102.d(), r104);
        goto L4
    L13:
        ArrayList<ConcurrentHashMap<String, AtomicLong>> r105 = b.f574088a;
        Iterator<ApiStatistics> r106 = b.f574090c.iterator();
        int r107 = 0;
    L15:
        if (r106.hasNext() == false) goto L33;
        ApiStatistics r108 = r106.next();
        boolean r109 = true;
        if ((!Intrinsics.areEqual(r108.getType(), "api")) == false) goto L20;
    L29:
        r109 = false;
    L30:
        if (r109 == true) goto L34;
        r107 = r107 + 1;
    L34:
        b.d(r107, r100.K + '_' + r100.f245366c);
        return;
    L20:
        if (r108.e() == true) goto L27;
        if (r108.a().isEmpty() == true) goto L30;
        if (r108.a().contains(Integer.valueOf(r100.f245366c)) == false) goto L29;
    L27:
        if (r108.a().contains(Integer.valueOf(r100.f245366c)) == true) goto L29;
    L33:
        r107 = -1;
        goto L34
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final void a(PrivacyEvent r100) {
        f(r100);
    }

    public static void c(p r100, PrivacyEvent r110) {
        CopyOnWriteArrayList<Pair<Long, Integer>> r101 = f574094a.get(r100.d());
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L6:
        FrequencyLog r103 = new FrequencyLog(r100.d(), r102, r100.b(), null, 8, null);
        if (r101 == null) goto L19;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<T> r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        Integer r107 = Integer.valueOf(((Number) ((Pair) r106).getSecond()).intValue());
        Object r108 = r104.get(r107);
        if (r108 != null) goto L14;
        r108 = new ArrayList();
        r104.put(r107, r108);
    L14:
        ((List) r108).add(r106);
        goto L10
    L15:
        Iterator r109 = r104.entrySet().iterator();
    L17:
        if (r109.hasNext() == false) goto L19;
        Map.Entry r111 = (Map.Entry) r109.next();
        r103.getApiCallCountMap().put(String.valueOf(((Number) r111.getKey()).intValue()), Integer.valueOf(((List) r111.getValue()).size()));
    L19:
        FrequencyExtra r112 = r110.A;
        if (r112 != null) goto L23;
        r112 = new FrequencyExtra(null, null, 3, null);
    L23:
        r110.A = r112;
        Set<String> r113 = r112.getFrequencyNames();
        if (r113 == null) goto L26;
        r113.add(r103.getName());
    L26:
        FrequencyExtra r114 = r110.A;
        if (r114 == null) goto L36;
        Set<FrequencyLog> r115 = r114.getFrequencyLogs();
        if (r115 == null) goto L37;
        r115.add(r103);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static boolean d(List r100, PrivacyEvent r101) {
        Iterator r102 = r100.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L21;
        p r104 = (p) r102.next();
        e(r104.d(), r104.e());
        CopyOnWriteArrayList<Pair<Long, Integer>> r105 = f574094a.get(r104.d());
        if (r105 == null) goto L8;
        int r106 = r105.size();
    L10:
        if (r106 <= r104.b()) goto L12;
        boolean r107 = true;
    L13:
        if (r103 == true) goto L17;
        if (r107 == true) goto L17;
        r103 = false;
    L18:
        if (r107 == false) goto L4;
        if (r101 == null) goto L4;
        c(r104, r101);
    L17:
        r103 = true;
        goto L18
    L12:
        r107 = false;
        goto L13
    L8:
        r106 = 0;
        goto L10
    L21:
        return r103;
    }

    public static void e(String r100, long r110) {
        CopyOnWriteArrayList<Pair<Long, Integer>> r101 = f574094a.get(r100);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L28;
        long r103 = System.currentTimeMillis() - r110;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r101.iterator();
    L12:
        if (r112.hasNext() == false) goto L20;
        Object r104 = r112.next();
        if (((Number) ((Pair) r104).getFirst()).longValue() >= r103) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L12;
        r111.add(r104);
        goto L12
    L16:
        r105 = false;
        goto L17
    L20:
        if ((!r111.isEmpty()) == false) goto L29;
        r101.removeAll(CollectionsKt.toSet(r111));
        f574094a.put(r100, r101);
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
