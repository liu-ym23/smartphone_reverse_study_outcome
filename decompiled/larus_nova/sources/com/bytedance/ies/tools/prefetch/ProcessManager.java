package com.bytedance.ies.tools.prefetch;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ProcessManager implements n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f248756f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0<String, PrefetchProcess> f248757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f248758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f248759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f248760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f248761e;

    public static final class a {
    }

    public static final class b implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProcessManager f248762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f248763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PrefetchProcess f248764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PrefetchRequest f248765d;

        @Override // com.bytedance.ies.tools.prefetch.i.a
        public final void a(Throwable r100) {
            k r101 = p.f248826a;
            p.b("Request failed, url: " + this.f248763b);
            this.f248764c.a(r100);
        }

        @Override // com.bytedance.ies.tools.prefetch.i.a
        public final void b(i.b r100) {
            k r101 = p.f248826a;
            p.b("Received response, url: " + this.f248763b);
            this.f248764c.b(r100);
            if (this.f248764c.f248742h <= 0) goto L6;
            p.b("Putting to cache, key: " + this.f248765d + ", expires: " + this.f248764c.f248742h);
            this.f248762a.j(this.f248765d, this.f248764c);
            return;
        }

        public b(ProcessManager r100, String r101, PrefetchProcess r102, PrefetchRequest r103) {
            this.f248762a = r100;
            this.f248763b = r101;
            this.f248764c = r102;
            this.f248765d = r103;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProcessManager f248766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrefetchProcess f248767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f248768c;

        public c(ProcessManager r100, PrefetchProcess r101, String r102) {
            this.f248766a = r100;
            this.f248767b = r101;
            this.f248768c = r102;
        }

        public final void a() {
            if (this.f248767b.f248738d == null) goto L26;
            ProcessManager r100 = this.f248766a;
            h r101 = r100.f248759c;
            if (r101 == null) goto L29;
            monitor-enter(r100);
        L23:
            th = move-exception;
            throw th;
        L8:
            if (this.f248766a.f248758b.add(this.f248768c) == false) goto L10;
            r101.a(this.f248766a.f248758b);     // Catch: Throwable -> L23
        L10:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r100);
            String r103 = this.f248768c;
            PrefetchProcess r104 = this.f248767b;
            r104.getClass();
            JSONObject r105 = new JSONObject().put("page_url", r104.f248739e);
            Lazy r106 = r104.f248740f.f248746b;
            KProperty r107 = PrefetchRequest.f248744l[1];
            JSONObject r108 = r105.put("request", (JSONObject) r106.getValue()).put("timestamp", r104.f248741g).put("expires", r104.f248742h);
            i.b r109 = r104.f248738d;
            JSONObject r110 = null;
            if (r109 == null) goto L22;
            JSONObject r111 = new JSONObject();
            Map<String, String> r112 = r109.f248822c;
            if (r112 == null) goto L17;
            JSONObject r113 = g0.c(r112);
        L18:
            r111.put("headers", r113);
            r111.put(ContainerPosition.BODY, r109.a());
            r111.put("status_code", r109.f248823d);
            Map<String, String> r114 = r109.f248824e;
            if (r114 == null) goto L21;
            r110 = g0.c(r114);
        L21:
            r111.put("extra", r110);
            r110 = r111;
            goto L22
        L17:
            r113 = null;
        L22:
            r101.putString(r103, r108.put("response", r110).toString());
            return;
        L29:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.tools.prefetch.n
    public final void a() {
        this.f248757a.d();
        monitor-enter(this);
        h r100 = this.f248759c;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.a(this.f248758b);     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean g(PrefetchProcess r100) {
        if (((System.currentTimeMillis() - r100.f248741g) - r100.f248742h) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ies.tools.prefetch.n
    public final PrefetchProcess b(PrefetchRequest r100) {
        k r101 = p.f248826a;
        p.b("Start to get from cache for " + r100 + '.');
        String r102 = r100.toString();
        PrefetchProcess r103 = this.f248757a.a(r102);
        if (r103 != null) goto L24;
        p.b("Not found in lruCache.");
        h r104 = this.f248759c;
        if (r104 == null) goto L30;
        String r105 = r104.getString(r102);
        if (r105 == null) goto L30;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        int r107 = PrefetchProcess.f248734i;     // Catch: Throwable -> L10
        Object r108 = Result.m9449constructorimpl(PrefetchProcess.a.a(new JSONObject(r105)));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r108) == false) goto L15;
        r108 = null;
    L15:
        PrefetchProcess r109 = (PrefetchProcess) r108;
        if (r109 != null) goto L18;
    L22:
        p.b("Found in local storage but expired.");
        k(r100);
        goto L30
    L18:
        if (g(r109) == true) goto L22;
        p.b("Found in local storage.");
        r109.f248736b = PrefetchProcess.HitState.CACHED;
        j(r100, r109);
        return r109;
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        p.b("Fallback to normal fetch.");
        return h(null, r100, -1, true, true);
    L24:
        if (g(r103) == true) goto L29;
        p.b("Found in lruCache.");
        if (r103.f248738d == null) goto L28;
        r103.f248736b = PrefetchProcess.HitState.CACHED;
    L28:
        return r103;
    L29:
        p.b("Found in lruCache but expired.");
        k(r100);
        goto L30
    }

    @Override // com.bytedance.ies.tools.prefetch.n
    public final PrefetchProcess c(PrefetchRequest r100) {
        k r101 = p.f248826a;
        p.b("Skip Cache to normal fetch for " + r100 + '.');
        return h(null, r100, -1, true, true);
    }

    @Override // com.bytedance.ies.tools.prefetch.n
    public final void d(PrefetchHandler$1.a r100) {
        this.f248761e.execute(new y(this, r100));
    }

    @Override // com.bytedance.ies.tools.prefetch.n
    public final List getCacheByScheme(String r100) {
        k r101 = p.f248826a;
        p.b("Start to get cache by " + r100 + '.');
        e0<String, PrefetchProcess> r102 = this.f248757a;
        monitor-enter(r102);
        LinkedHashMap r103 = new LinkedHashMap(r102.f248812a);     // Catch: Throwable -> L21
        monitor-exit(r102);
        Iterator r104 = r103.values().iterator();
        ArrayList r105 = null;
    L8:
        if (r104.hasNext() == false) goto L20;
        PrefetchProcess r106 = (PrefetchProcess) r104.next();
        if (Intrinsics.areEqual(r100, r106.f248739e) == false) goto L8;
        if (g(r106) == false) goto L13;
        k r107 = p.f248826a;
        p.b(r106.f248740f.f248748d + " found in lruCache but expired.");
        k(r106.f248740f);
        goto L8
    L13:
        k r108 = p.f248826a;
        p.b(r106.f248740f.f248748d + " found in lruCache.");
        if (r106.f248738d == null) goto L16;
        r106.f248736b = PrefetchProcess.HitState.CACHED;
    L16:
        if (r105 != null) goto L18;
        r105 = new ArrayList();
    L18:
        r105.add(r106);
        goto L8
    L20:
        return r105;
    L21:
        th = move-exception;
        throw th;
    }

    public final void k(PrefetchRequest r100) {
        String r101 = r100.toString();
        this.f248757a.b(r101);
        h r102 = this.f248759c;
        if (r102 == null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.f248758b.remove(r101) == false) goto L8;
        r102.a(this.f248758b);     // Catch: Throwable -> L11
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        r102.remove(r101);
        return;
    }

    public final void j(PrefetchRequest r100, PrefetchProcess r101) {
        if (r101.f248742h > 0) goto L5;
        return;
    L5:
        String r102 = r100.toString();
        this.f248757a.c(r102, r101);
        this.f248761e.execute(new c(this, r101, r102));
    }

    public ProcessManager(h r100, i r101, Executor r102) {
        this.f248759c = r100;
        this.f248760d = r101;
        this.f248761e = r102;
        this.f248757a = new e0(new ProcessManager$lruCache$1(this), new ProcessManager$lruCache$2(this));
        this.f248758b = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object f(ProcessManager r100, f0 r101, String r102) {
        r100.getClass();
        ProcessManager$toSpecifiedType$1 r103 = ProcessManager$toSpecifiedType$1.INSTANCE;
        if (r102 != null) goto L5;
        return null;
    L5:
        String r104 = ((f0.a) r101).getDataType();
        int r105 = r104.hashCode();
        if (r105 == (-1034364087)) goto L13;
        Object r106 = r102;
        if (r105 != 3029738) goto L17;
        r106 = r102;
        if (r104.equals("bool") == false) goto L17;
        r106 = r103.invoke2(r102, ProcessManager$toSpecifiedType$3.INSTANCE);
    L17:
        return r106;
    L13:
        r106 = r102;
        if (r104.equals("number") == false) goto L17;
        r106 = r103.invoke2(r102, ProcessManager$toSpecifiedType$2.INSTANCE);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.tools.prefetch.n
    public final void e(String r110, final SortedMap r111, final SortedMap r210, a0 r211) {
        k r100 = p.f248826a;
        p.b("Start request: " + r211);
        final SortedMap<String, f0<?>> r101 = r211.f248785e;
        JSONObject r102 = null;
        Object[] r103 = 0;
        if (r101 == null) goto L9;
        TreeMap r104 = new TreeMap();
        Sequence r105 = CollectionsKt.asSequence(r101.entrySet());
        final Object[] r106 = r103 == true ? 1 : 0;
        Iterator r107 = SequencesKt.mapNotNull(r105, new ProcessManager$parseQueryToValues$$inlined$also$lambda$1(r101, r106, r111, r210)).iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        Pair r108 = (Pair) r107.next();
        String r109 = (String) r108.component1();
        Object r112 = r108.component2();
        r104.put(r109, r112);
        k r113 = p.f248826a;
        p.b("Append param: " + r109 + " = " + r112);
        goto L6
    L8:
        TreeMap r114 = r104;
    L10:
        SortedMap<String, f0<?>> r115 = r211.f248786f;
        if (r115 == null) goto L13;
        r102 = i(r111, r210, null, r115);
    L13:
        PrefetchRequest r116 = new PrefetchRequest(r211.f248781a, r211.f248782b, r211.f248784d, r114, r102, r211.f248788h, r211.f248789i, r211.f248790j);
        PrefetchProcess r117 = this.f248757a.a(r116.toString());
        if (r117 == null) goto L16;
        boolean r118 = g(r117);
    L17:
        h(r110, r116, r211.f248787g, false, r118);
        return;
    L16:
        r118 = true;
        goto L17
    L9:
        r114 = null;
        goto L10
    }

    public final JSONObject i(final SortedMap<String, String> r110, final SortedMap<String, String> r111, final SortedMap<String, ? extends Object> r112, final SortedMap<String, f0<?>> r113) {
        JSONObject r100 = new JSONObject();
        Iterator r114 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r113.entrySet()), new ProcessManager$parsePostBodyToValues$$inlined$also$lambda$1(this, r113, r112, r110, r111)).iterator();
    L4:
        if (r114.hasNext() == false) goto L6;
        Pair r115 = (Pair) r114.next();
        String r116 = (String) r115.component1();
        Object r117 = r115.component2();
        r100.put(r116, r117);
        k r118 = p.f248826a;
        p.b("Append param: " + r116 + " = " + r117);
        goto L4
    L6:
        return r100;
    }

    public final PrefetchProcess h(String r110, PrefetchRequest r111, long r112, boolean r113, boolean r114) {
        String r115 = g0.a(r111.f248748d, r111.f248751g);
        if (r110 == null) goto L5;
        String r100 = r110;
    L6:
        PrefetchProcess r116 = new PrefetchProcess(r100, r111, System.currentTimeMillis(), r112);
        if (r114 == false) goto L9;
        j(r111, r116);
    L9:
        b r101 = new b(this, r115, r116, r111);
        String r102 = r111.f248749e;
        Locale r103 = Locale.ROOT;
        if (r102 == null) goto L50;
        String r104 = r102.toLowerCase(r103);
        int r105 = r104.hashCode();
        if (r105 == 102230) goto L34;
        if (r105 == 3446944) goto L17;
    L40:
        k r106 = p.f248826a;
        p.f248826a.a();
    L42:
        if (r112 == (-1)) goto L46;
        if (r113 == true) goto L46;
        PrefetchProcess.HitState r107 = PrefetchProcess.HitState.PENDING;
    L47:
        r116.f248736b = r107;
        return r116;
    L46:
        r107 = PrefetchProcess.HitState.FALLBACK;
        goto L47
    L17:
        if (r104.equals(UGCMonitor.TYPE_POST) == false) goto L40;
        k r108 = p.f248826a;
        p.a("[request_key:" + r110 + "] post");
        i r109 = this.f248760d;
        Map r117 = r111.f248750f;
        if (r117 != null) goto L22;
        r117 = MapsKt.emptyMap();
    L22:
        Map r118 = r117;
        SortedMap<String, String> r119 = r111.f248750f;
        if (r119 == null) goto L27;
        String r120 = r119.get("Content-Type");
        if (r120 == null) goto L27;
    L28:
        String r121 = r120;
        JSONObject r122 = r111.f248752h;
        if (r122 != null) goto L32;
        r122 = new JSONObject();
    L32:
        r109.b(r115, r118, r121, r122, r111.f248754j, r101);
    L27:
        r120 = "application/x-www-form-urlencoded";
        goto L28
    L34:
        if (r104.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L40;
        k r123 = p.f248826a;
        p.a("[request_key:" + r110 + "] get");
        i r124 = this.f248760d;
        Map r125 = r111.f248750f;
        if (r125 != null) goto L39;
        r125 = MapsKt.emptyMap();
    L39:
        r124.a(r115, r125, r111.f248754j, r101);
        goto L42
    L50:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        r100 = "";
        goto L6
    }
}
