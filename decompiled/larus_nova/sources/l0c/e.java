package l0c;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zyb.c f506908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f506909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f506910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f506911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f506912e;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r101).getValue(), (Long) ((Map.Entry) r100).getValue());
        }
    }

    static {
    }

    @Override // l0c.c
    public final void d() {
        zyb.a.b r100 = this.f506908a.a();
        HashMap<String, Long> r101 = new HashMap();     // Catch: Exception -> L8
        j(r101);     // Catch: Exception -> L8
        k(r101);     // Catch: Exception -> L8
        Iterator<T> r102 = r101.entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L15;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Exception -> L8
        r100.a((String) r103.getKey(), (Number) r103.getValue());     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        Log.e("PassportUserFlowMonitorImpl", "endRustInfraFlow exception:" + e);
    }

    @Override // l0c.c
    public final void e() {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", "name");
        this.f506910c.put("rust_infra_user_notify_total", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    @Override // l0c.c
    public final void f() {
        ConcurrentHashMap<String, Long> r100 = this.f506910c;
        monitor-enter(r100);
        this.f506910c.clear();     // Catch: Throwable -> L21
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r100);
        ConcurrentHashMap<String, Long> r102 = this.f506911d;
        monitor-enter(r102);
        this.f506911d.clear();     // Catch: Throwable -> L18
        monitor-exit(r102);
        ConcurrentHashMap<String, Long> r103 = this.f506912e;
        monitor-enter(r103);
        this.f506912e.clear();     // Catch: Throwable -> L15
        monitor-exit(r103);
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void h() {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", "name");
        Long r100 = this.f506910c.get("rust_infra_user_notify_total");
        if (r100 == null) goto L16;
        long r101 = SystemClock.elapsedRealtime() - r100.longValue();
        Log.i("PassportUserFlowMonitorImpl", "endCountStep name:rust_infra_user_notify_total duration:" + r101);
        ConcurrentHashMap<String, Long> r102 = this.f506911d;
        monitor-enter(r102);
        ConcurrentHashMap<String, Long> r103 = this.f506911d;     // Catch: Throwable -> L13
        Long r104 = r103.get("rust_infra_user_notify_total");     // Catch: Throwable -> L13
        if (r104 == null) goto L9;
        long r105 = r104.longValue();     // Catch: Throwable -> L13
    L10:
        r103.put("rust_infra_user_notify_total", Long.valueOf(r105 + r101));     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        return;
    L9:
        r105 = 0;
    L13:
        th = move-exception;
        throw th;
    }

    @Inject
    public e(zyb.c r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorService");
        this.f506908a = r100;
        this.f506909b = 10;
        this.f506910c = new ConcurrentHashMap();
        this.f506911d = new ConcurrentHashMap();
        this.f506912e = new ConcurrentHashMap();
    }

    @Override // l0c.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter("rust_online_scenario", "name");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f506908a.a().d(r100);
    }

    @Override // l0c.c
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f506908a.a().b(r100);
    }

    @Override // l0c.c
    public final void g(long r100) {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", "name");
        ConcurrentHashMap<String, Long> r101 = this.f506911d;
        monitor-enter(r101);
        ConcurrentHashMap<String, Long> r102 = this.f506911d;     // Catch: Throwable -> L11
        Long r103 = r102.get("rust_infra_user_notify_total");     // Catch: Throwable -> L11
        if (r103 == null) goto L7;
        long r104 = r103.longValue();     // Catch: Throwable -> L11
    L8:
        r102.put("rust_infra_user_notify_total", Long.valueOf(r104 + r100));     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L7:
        r104 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f506908a.a().c(r100, MapsKt.emptyMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(HashMap<String, Long> r100) {
        ConcurrentHashMap<String, Long> r101 = this.f506911d;
        monitor-enter(r101);
        Iterator<T> r102 = this.f506911d.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L11
        r100.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(HashMap<String, Long> r100) {
        ConcurrentHashMap<String, Long> r101 = this.f506911d;
        monitor-enter(r101);
        Iterator r102 = CollectionsKt.sortedWith(this.f506912e.entrySet(), new b()).iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L13
        if (((Number) r103.getValue()).longValue() < this.f506909b) goto L6;
        r100.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, Long> r102 = this.f506912e;
        monitor-enter(r102);
        ConcurrentHashMap<String, Long> r103 = this.f506912e;     // Catch: Throwable -> L11
        Long r104 = r103.get(r100);     // Catch: Throwable -> L11
        if (r104 == null) goto L7;
        long r105 = r104.longValue();     // Catch: Throwable -> L11
    L8:
        r103.put(r100, Long.valueOf(r105 + r101));     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L7:
        r105 = 0;
    L11:
        th = move-exception;
        throw th;
    }
}
