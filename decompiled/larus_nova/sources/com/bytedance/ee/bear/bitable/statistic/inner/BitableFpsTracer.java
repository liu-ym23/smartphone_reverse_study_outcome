package com.bytedance.ee.bear.bitable.statistic.inner;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.util.i;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Debug;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$FpsDropState;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableFpsTracer extends BitableInnerTrace implements com.bytedance.ee.bear.bitable.statistic.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f215652u = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f215653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f215654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f215655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<Runnable> f215656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f215657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<String, Long> f215658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.statistic.h> f215659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f215660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final et3.h f215661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f215662t;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215663a;

        public b(BitableFpsTracer r100) {
            this.f215663a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f215663a.f215657o = true;     // Catch: Throwable -> L4
            BitableFpsTracer.n(this.f215663a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.statistic.inner.e f215667b;

        public c(BitableFpsTracer r100, com.bytedance.ee.bear.bitable.statistic.inner.e r101) {
            this.f215666a = r100;
            this.f215667b = r101;
        }
    }

    public static final class d implements et3.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215668a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BitableFpsTracer f215669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f215670b;

            public a(BitableFpsTracer r100, double r101) {
                this.f215669a = r100;
                this.f215670b = r101;
            }

            public final void a() {
                c r100 = this.f215669a.f215662t;
                double r101 = this.f215670b;
                BitableFpsTracer r102 = r100.f215666a;
                long r110 = r102.f215655m - r102.f215654l;
                if (((Boolean) BitableStatisticConstant$Debug.f215589b.getValue()).booleanValue() == false) goto L5;
                int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
                tt5.a.h("BitableStatistic", "BitableFpsTracer " + ("fpsCallBack " + r101 + ", duration:" + r110));
            L5:
                BitableFpsTracer r111 = r100.f215666a;
                List<com.bytedance.ee.bear.bitable.statistic.h> r104 = r111.f215659q;
                com.bytedance.ee.bear.bitable.statistic.inner.e r105 = r100.f215667b;
                Iterator r112 = ((CopyOnWriteArrayList) r104).iterator();
            L7:
                if (r112.hasNext() == false) goto L9;
                ((com.bytedance.ee.bear.bitable.statistic.h) r112.next()).a(r105.getLogger(), r111, r101, r110);
                goto L7
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

        public d(BitableFpsTracer r100) {
            this.f215668a = r100;
        }

        @Override // et3.c.d
        public final void fpsCallBack(double r100) {
            this.f215668a.l().post(new a(this.f215668a, r100));
        }
    }

    public static final class e implements et3.c.InterfaceC5817c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215671a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f215672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BitableFpsTracer f215673b;

            public a(JSONObject r100, BitableFpsTracer r101) {
                this.f215672a = r100;
                this.f215673b = r101;
            }

            public final void a() {
                Iterator<String> r100 = this.f215672a.keys();
                JSONObject r101 = this.f215672a;
                BitableFpsTracer r102 = this.f215673b;
            L4:
                if (r100.hasNext() == false) goto L12;
                String r103 = r100.next();
                int r104 = r101.optInt(r103, 0);
                if (r104 == 0) goto L4;
                HashMap<String, Long> r105 = r102.f215658p;
                Long r106 = r105.get(r103);
                if (r106 == null) goto L10;
                long r107 = r106.longValue();
            L11:
                r105.put(r103, Long.valueOf(r107 + ((long) r104)));
                goto L4
            L10:
                r107 = 0;
                goto L11
            L12:
                BitableFpsTracer r108 = this.f215673b;
                int r109 = BitableFpsTracer.f215652u;
                r108.o();
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

        public e(BitableFpsTracer r100) {
            this.f215671a = r100;
        }

        @Override // et3.c.InterfaceC5817c
        public final void dropFrame(JSONObject r100) {
            BitableFpsTracer r101 = this.f215671a;
            r101.f215660r = i.f190673e;
            r101.l().post(new a(r100, this.f215671a));
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215674a;

        public f(BitableFpsTracer r100) {
            this.f215674a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableFpsTracer r100 = this.f215674a;     // Catch: Throwable -> L4
            r100.f215657o = false;     // Catch: Throwable -> L4
            r100.f215654l = System.currentTimeMillis();     // Catch: Throwable -> L4
            r100.f215661s.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f215676b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BitableFpsTracer f215677a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (this.f215677a.f215656n.contains(this) == false) goto L9;
                this.f215677a.f215656n.remove(this);     // Catch: Throwable -> L6
                this.f215677a.stop();     // Catch: Throwable -> L6
                return;
            }

            public a(BitableFpsTracer r100) {
                this.f215677a = r100;
            }
        }

        public g(BitableFpsTracer r100, long r101) {
            this.f215675a = r100;
            this.f215676b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f215675a.start();     // Catch: Throwable -> L4
            BitableFpsTracer r100 = this.f215675a;     // Catch: Throwable -> L4
            a r101 = new a(r100);     // Catch: Throwable -> L4
            r100.f215656n.add(r101);     // Catch: Throwable -> L4
            this.f215675a.l().postDelayed(r101, this.f215676b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFpsTracer f215678a;

        public h(BitableFpsTracer r100) {
            this.f215678a = r100;
        }

        public final void a() {
            int r100 = this.f215678a.f215653k.decrementAndGet();
            if (r100 >= 0) goto L6;
            int r101 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
            com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableFpsTracer", this.f215678a.f215687h + " stop count error: " + r100);
            BitableFpsTracer.n(this.f215678a);
            return;
        L6:
            if (r100 != 0) goto L9;
            BitableFpsTracer r102 = this.f215678a;
            r102.f215685f.set(true);
            r102.f215655m = System.currentTimeMillis();
            r102.f215661s.d();
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

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace, com.bytedance.ee.bear.bitable.statistic.n
    public /* bridge */ /* synthetic */ BitableTraceType getType() {
        return com.bytedance.ee.bear.bitable.statistic.b.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace
    public final void m() {
        ((CopyOnWriteArrayList) this.f215659q).clear();
    }

    public final void o() {
        BitableFpsTracer r100 = this;
        if ((!r100.f215658p.isEmpty()) == false) goto L44;
        c r101 = r100.f215662t;
        HashMap<String, Long> r110 = r100.f215658p;
        boolean r111 = r100.f215657o;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "frames");
        if (((Boolean) BitableStatisticConstant$Debug.f215589b.getValue()).booleanValue() == false) goto L7;
        int r102 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "BitableFpsTracer " + ("dropFrameCallBack isForceStop:" + r111 + ' ' + r110));
    L7:
        HashMap r103 = new HashMap();
        BitableFpsTracer r104 = r101.f215666a;
        Iterator<Map.Entry<String, Long>> r105 = r110.entrySet().iterator();
        long r106 = 0;
        long r107 = 0;
        long r108 = 0;
        long r112 = 0;
        long r113 = 0;
    L9:
        if (r105.hasNext() == false) goto L27;
        Map.Entry<String, Long> r210 = r105.next();
        Integer r211 = StringsKt.toIntOrNull(r210.getKey());
        if (r211 == null) goto L26;
        long r212 = r210.getValue().longValue();
        long r109 = ((long) r211.intValue()) * r212;
        long r114 = r108 + r212;
        r113 = r113 + r109;
        BitableStatisticConstant$FpsDropState.a r115 = BitableStatisticConstant$FpsDropState.Companion;
        int r213 = r211.intValue();
        r115.getClass();
        BitableStatisticConstant$FpsDropState r116 = BitableStatisticConstant$FpsDropState.a.a(r213);
        Long r117 = (Long) r103.get(r116.getTitle());
        if (r117 == null) goto L15;
        long r118 = r117.longValue();
    L16:
        r103.put(r116.getTitle(), Long.valueOf(r118 + r212));
        float r119 = (r211.intValue() * 60) / r104.f215660r;
        if (r119 < 3.0f) goto L24;
        r106 = r106 + r109;
        if (r119 < 7.0f) goto L22;
        r112 = r112 + r109;
    L22:
        if (r119 < 25.0f) goto L24;
        r107 = r107 + r109;
    L24:
        r108 = r114;
        goto L26
    L15:
        r118 = 0;
    L26:
        r105 = r105;
        r101 = r101;
        goto L9
    L27:
        c r214 = r101;
        HashMap r120 = new HashMap();
        if (r108 <= 0) goto L33;
        Iterator r121 = r103.entrySet().iterator();
    L31:
        if (r121.hasNext() == false) goto L33;
        Map.Entry r122 = (Map.Entry) r121.next();
        r120.put(r122.getKey(), Float.valueOf(((Number) r122.getValue()).longValue() / r108));
        r107 = r107;
    L33:
        float r123 = r108 + r113;
        HashMap r124 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hitch_dur_ratio", Float.valueOf(r113 / r123)), TuplesKt.to("drop3_dur_ratio", Float.valueOf(r106 / r123)), TuplesKt.to("drop7_dur_ratio", Float.valueOf(r112 / r123)), TuplesKt.to("drop25_dur_ratio", Float.valueOf(r107 / r123))});
        int r125 = i.f190674f;
        BitableFpsTracer r126 = r214.f215666a;
        com.bytedance.ee.bear.bitable.statistic.a r127 = new com.bytedance.ee.bear.bitable.statistic.a(r125, r126.f215660r);
        List<com.bytedance.ee.bear.bitable.statistic.h> r128 = r126.f215659q;
        com.bytedance.ee.bear.bitable.statistic.inner.e r129 = r214.f215667b;
        Iterator r130 = ((CopyOnWriteArrayList) r128).iterator();
    L34:
        boolean r131 = false;
    L36:
        if (r130.hasNext() == false) goto L41;
        if (((com.bytedance.ee.bear.bitable.statistic.h) r130.next()).d(r129.getLogger(), r126, r110, r120, r124, r111, r127) == true) goto L40;
        if (r131 == false) goto L34;
    L40:
        r131 = true;
        goto L36
    L41:
        r100 = this;
        if (r131 == false) goto L44;
        r100.f215658p.clear();
    L44:
        r100.f215685f.set(false);
        j();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void start() {
        if (this.f215653k.getAndIncrement() != 0) goto L6;
        l().post(new f(this));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void g() {
        l().post(new b(this));
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void stop() {
        l().post(new h(this));
    }

    public static final void n(BitableFpsTracer r100) {
        r100.getClass();
        int r101 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "BitableFpsTracer " + (r100.f215687h + " clear"));
        if (r100.f215653k.get() == 0) goto L6;
        r100.f215685f.set(true);
        r100.f215655m = System.currentTimeMillis();
        r100.f215661s.d();
    L8:
        r100.f215653k.set(0);
        Iterator<T> r102 = r100.f215656n.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        r100.l().removeCallbacks((Runnable) r102.next());
        goto L10
    L12:
        r100.f215656n.clear();
        return;
    L6:
        if (r100.f215657o == false) goto L8;
        r100.f215685f.set(true);
        r100.o();
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void a(long r100) {
        l().post(new g(this, r100));
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace, com.bytedance.ee.bear.bitable.statistic.n
    public final synchronized void b(Boolean r100) {
        monitor-enter(this);
        g();     // Catch: Throwable -> L6
        super.b(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void d(com.bytedance.ee.bear.bitable.statistic.h r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        ((CopyOnWriteArrayList) this.f215659q).add(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void f(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.addOnScrollListener(new BitableFpsTracer$bindRecyclerView$1(this));
    }

    public BitableFpsTracer(String r100, com.bytedance.ee.bear.bitable.statistic.inner.e r101) {
        Intrinsics.checkNotNullParameter(r101, "traceProvider");
        super(r100, r101);
        this.f215653k = new AtomicInteger();
        this.f215656n = new LinkedHashSet();
        this.f215658p = new HashMap();
        this.f215659q = new CopyOnWriteArrayList();
        this.f215660r = 60;
        et3.h r102 = new et3.h("", true, null);
        r102.f473916d = new d(this);
        r102.f473917e = new e(this);
        this.f215661s = r102;
        this.f215662t = new c(this, r101);
    }
}
