package com.bytedance.locallife.biz.fmp;

import android.os.SystemClock;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiChainDurationMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f256671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f256672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f256673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f256674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f256675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f256676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f256677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f256678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f256679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f256680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f256681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.locallife.biz.mob.a f256682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f256683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f256684o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f256685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f256686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f256687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f256688d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f256689a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f256690b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Map<String, String> f256691c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f256692d;

            public final b b() {
                b r100 = new b();
                r100.f256687c = this.f256689a;
                long r101 = this.f256690b;
                if (r101 != Long.MAX_VALUE) goto L5;
                r101 = SystemClock.elapsedRealtime();
            L5:
                r100.f256685a = r101;
                r100.f256688d = this.f256692d;
                Map<String, String> r102 = r100.f256686b;
                ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
                r103.putAll(this.f256691c);
                return r100;
            }

            public a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "mName");
                this.f256689a = r100;
                this.f256690b = Long.MAX_VALUE;
                this.f256691c = new ConcurrentHashMap();
            }

            public final void a(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "key");
                if (r101 == null) goto L6;
                String r102 = (String) ((ConcurrentHashMap) this.f256691c).put(r100, r101);
                return;
            }
        }

        public b() {
            this.f256685a = Long.MAX_VALUE;
            this.f256686b = new ConcurrentHashMap();
            this.f256687c = "";
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Long) ((Pair) r100).getSecond(), (Long) ((Pair) r101).getSecond());
        }
    }

    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f256693a = null;

        static {
            f256693a = new d();
        }

        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            b r102 = (b) r100;
            b r103 = (b) r101;
            long r104 = 0;
            if (r103 == null) goto L5;
            long r105 = r103.f256685a;
        L6:
            if (r102 == null) goto L9;
            r104 = r102.f256685a;
        L9:
            return (int) (r105 - r104);
        L5:
            r105 = 0;
            goto L6
        }
    }

    static {
    }

    public PoiChainDurationMonitor() {
        throw null;
    }

    public final Pair<Integer, Integer> d() {
        Iterator<T> r100 = this.f256676g.iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L14;
        b r103 = (b) r100.next();
        if (((ConcurrentHashMap) r103.f256686b).containsKey("type") == false) goto L4;
        if (Intrinsics.areEqual(((ConcurrentHashMap) r103.f256686b).get("type"), "0") == true) goto L9;
        if (Intrinsics.areEqual(((ConcurrentHashMap) r103.f256686b).get("type"), "1") == false) goto L4;
        r101 = r101 + 1;
        goto L4
    L9:
        r102 = r102 + 1;
        goto L4
    L14:
        return new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    }

    public final String b(long r100) {
        Object r101 = this.f256673d.get("card_tags");
        if (TypeIntrinsics.isMutableMap(r101) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        if (r102 != null) goto L8;
        r102 = new LinkedHashMap();
    L8:
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (((Number) r105.getValue()).longValue() > r100) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L10;
        r103.put(r105.getKey(), r105.getValue());
        goto L10
    L14:
        r106 = false;
        goto L15
    L17:
        List r107 = CollectionsKt.sortedWith(MapsKt.toList(r103), new c());
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L19:
        if (r109.hasNext() == false) goto L22;
        r108.add((String) ((Pair) r109.next()).getFirst());
        goto L19
    L22:
        return com.bytedance.locallife.common.utils.d.c(r108);
    L5:
        r102 = null;
        goto L6
    }

    public final void c(final long r100) {
        CollectionsKt.removeAll(this.f256676g, new PoiChainDurationMonitor$filterMobPendingEvent$1(r100));
        ArrayList r101 = new ArrayList();
        List<b> r102 = this.f256676g;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r105 = r104.next();
        String r106 = (String) ((ConcurrentHashMap) ((b) r105).f256686b).get("name");
        Object r107 = r103.get(r106);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r103.put(r106, r107);
    L8:
        ((List) r107).add(r105);
        goto L4
    L9:
        Iterator r108 = r103.entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L15;
        List r109 = CollectionsKt.sortedWith((Iterable) ((Map.Entry) r108.next()).getValue(), d.f256693a);
        if ((!r109.isEmpty()) == false) goto L11;
        r101.add(ListProtector.get(r109, 0));
        goto L11
    L15:
        ((ArrayList) this.f256676g).clear();
        ((ArrayList) this.f256676g).addAll(r101);
    }

    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        monitor-enter(this);
    L53:
        th = move-exception;
        throw th;
    L5:
        if (this.f256683n == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r100.f256688d == false) goto L28;
        Iterator r101 = ((ArrayList) this.f256675f).iterator();     // Catch: Throwable -> L53
    L12:
        if (r101.hasNext() == false) goto L22;
        Object r102 = r101.next();     // Catch: Throwable -> L53
        b r103 = (b) r102;     // Catch: Throwable -> L53
        if (Intrinsics.areEqual(r103.f256687c, r100.f256687c) == true) goto L16;
        boolean r104 = false;
    L20:
        if (r104 == false) goto L12;
    L24:
        if (((b) r102) == null) goto L28;
        monitor-exit(this);
        return;
    L16:
        if (Intrinsics.areEqual(r100.f256687c, "poi_card_fill") == false) goto L18;
        r104 = Intrinsics.areEqual(((ConcurrentHashMap) r103.f256686b).get("name"), ((ConcurrentHashMap) r100.f256686b).get("name"));     // Catch: Throwable -> L53
        goto L20
    L18:
        r104 = true;
        goto L20
    L22:
        r102 = null;
    L28:
        if (Intrinsics.areEqual("poi_card_fill", r100.f256687c) == false) goto L37;
        if (this.f256677h == null) goto L37;
        if (this.f256679j == true) goto L34;
        ((ArrayList) this.f256676g).add(r100);     // Catch: Throwable -> L53
    L34:
        monitor-exit(this);
        return;
    L37:
        if (Intrinsics.areEqual("poi_fmp_complete", r100.f256687c) == false) goto L48;
        if (StringsKt.equals$default((String) ((ConcurrentHashMap) r100.f256686b).get("is_new"), "1", false, 2, null) == false) goto L48;
        this.f256679j = true;     // Catch: Throwable -> L53
        c(r100.f256685a);     // Catch: Throwable -> L53
        final Pair<Integer, Integer> r105 = d();     // Catch: Throwable -> L53
        Iterator r106 = ((ArrayList) this.f256676g).iterator();     // Catch: Throwable -> L53
    L42:
        if (r106.hasNext() == false) goto L44;
        f((b) r106.next(), null);     // Catch: Throwable -> L53
        goto L42
    L44:
        ((ArrayList) this.f256676g).clear();     // Catch: Throwable -> L53
        final String r107 = b(r100.f256685a);     // Catch: Throwable -> L53
        final int r108 = r107.hashCode();     // Catch: Throwable -> L53
        f(r100, new PoiChainDurationMonitor$logEvent$1$3(r105, r107, r108));     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L48:
        if (Intrinsics.areEqual("poi_content_fill_start", r100.f256687c) == false) goto L50;
        this.f256677h = r100;     // Catch: Throwable -> L53
    L50:
        f(r100, null);     // Catch: Throwable -> L53
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(this);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((ConcurrentHashMap) this.f256674e).put(r100, r101);
    }

    public final void f(b r110, Function1<? super Map<String, String>, Unit> r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r111 == null) goto L5;
        r111.invoke(r100);
    L5:
        r100.put("session_id", this.f256670a);
        long r101 = r110.f256685a - this.f256671b;
        r100.put("total_duration", String.valueOf(r101));
        b r102 = this.f256678i;
        if (r102 == null) goto L8;
        r100.put("last_event", r102.f256687c);
        long r103 = r110.f256685a;
        long r104 = r102.f256685a;
    L9:
        long r105 = r103 - r104;
        String r106 = r110.f256687c;
        if (Intrinsics.areEqual(r106, "poi_page_create") == false) goto L12;
    L23:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L27;
    L31:
        ((ArrayList) this.f256675f).add(r110);
        r100.put("last_duration", String.valueOf(r105));
        if (HostServiceUtilsKt.u().i() == false) goto L39;
        if (StringsKt.equals$default((String) ((ConcurrentHashMap) r110.f256686b).get("is_new"), "1", false, 2, null) == false) goto L39;
        if (this.f256684o == false) goto L39;
        Map r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("last_duration", String.valueOf(r105)), TuplesKt.to("total_duration", String.valueOf(r101))});
        vn6.b.a(new com.bytedance.locallife.biz.fmp.d(r108));
        r108.toString();
    L39:
        Iterator r109 = ((ConcurrentHashMap) r110.f256686b).entrySet().iterator();
    L41:
        if (r109.hasNext() == false) goto L44;
        Map.Entry r112 = (Map.Entry) r109.next();
        r100.put(r112.getKey(), r112.getValue());
        goto L41
    L44:
        if (Intrinsics.areEqual(r110.f256687c, "poi_fmp_complete") == true) goto L46;
    L48:
        boolean r113 = false;
    L49:
        if (r113 == false) goto L51;
        this.f256680k = r100;
    L51:
        this.f256682m.a(r110.f256687c, r100);
        r100.toString();
        return;
    L46:
        if (Intrinsics.areEqual(r100.get("is_page_fmp"), "1") == false) goto L48;
        r113 = true;
        goto L49
    L27:
        if (Intrinsics.areEqual(r110.f256687c, "poi_fmp_complete") == true) goto L29;
    L30:
        this.f256678i = r110;
        goto L31
    L29:
        if (StringsKt.equals$default((String) ((ConcurrentHashMap) r110.f256686b).get("is_new"), "1", false, 2, null) == false) goto L31;
    L12:
        if (Intrinsics.areEqual(r106, "poi_request_send") == true) goto L23;
        if (Intrinsics.areEqual(r106, "poi_request_cost") == true) goto L23;
        if (Intrinsics.areEqual(r106, "poi_request_finish") == true) goto L23;
        if (Intrinsics.areEqual(r106, "poi_content_fill_start") == true) goto L23;
        if (Intrinsics.areEqual(r106, "poi_fmp_complete") == true) goto L23;
        r107 = false;
        goto L25
    L8:
        r103 = r110.f256685a;
        r104 = this.f256671b;
        goto L9
    }

    public final void g(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        this.f256682m.a(r100, r101);
    }

    public final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L6;
        this.f256672c.put(r100, r101);
        return;
    }

    public PoiChainDurationMonitor(String r100, String r101, long r102, ConcurrentHashMap r103) {
        ConcurrentHashMap<String, Object> r104 = new ConcurrentHashMap();
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "mPublicProps");
        Intrinsics.checkNotNullParameter(r104, "mExtraPublicProps");
        this.f256670a = r101;
        this.f256671b = r102;
        this.f256672c = r103;
        this.f256673d = r104;
        this.f256674e = new ConcurrentHashMap();
        this.f256675f = new ArrayList();
        this.f256676g = new ArrayList();
        com.bytedance.locallife.biz.fmp.b r105 = new com.bytedance.locallife.biz.fmp.b(this);
        com.bytedance.locallife.biz.fmp.c r106 = new com.bytedance.locallife.biz.fmp.c();
        ArrayList r107 = new ArrayList();
        Intrinsics.checkNotNullParameter(r105, "eventTrackNode");
        r107.add(r105);
        Intrinsics.checkNotNullParameter(r106, "eventTrackNode");
        r107.add(r106);
        com.bytedance.locallife.biz.mob.a r108 = new com.bytedance.locallife.biz.mob.a(null);
        r108.f256705b.addAll(r107);
        this.f256682m = r108;
        r103.put("page", r100);
        this.f256684o = true;
    }
}
