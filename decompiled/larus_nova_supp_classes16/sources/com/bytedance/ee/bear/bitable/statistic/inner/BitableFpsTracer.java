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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableFpsTracer extends BitableInnerTrace implements com.bytedance.ee.bear.bitable.statistic.c {
    public static final /* synthetic */ int u = 0;
    public final AtomicInteger k;
    public long l;
    public long m;
    public final Set<Runnable> n;
    public volatile boolean o;
    public final HashMap<String, Long> p;
    public final List<com.bytedance.ee.bear.bitable.statistic.h> q;
    public int r;
    public final et3.h s;
    public final c t;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BitableFpsTracer a;

        public b(BitableFpsTracer r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o = true;     // Catch: Throwable -> L4
            BitableFpsTracer.n(this.a);     // Catch: Throwable -> L4
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
        public final /* synthetic */ BitableFpsTracer a;
        public final /* synthetic */ com.bytedance.ee.bear.bitable.statistic.inner.e b;

        public c(BitableFpsTracer r1, com.bytedance.ee.bear.bitable.statistic.inner.e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements et3.c.d {
        public final /* synthetic */ BitableFpsTracer a;

        public static final class a implements Runnable {
            public final /* synthetic */ BitableFpsTracer a;
            public final /* synthetic */ double b;

            public a(BitableFpsTracer r1, double r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                c r0 = this.a.t;
                double r8 = this.b;
                BitableFpsTracer r1 = r0.a;
                long r10 = r1.m - r1.l;
                if (((Boolean) BitableStatisticConstant$Debug.b.getValue()).booleanValue() == false) goto L5;
                int r2 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
                tt5.a.h("BitableStatistic", "BitableFpsTracer " + ("fpsCallBack " + r8 + ", duration:" + r10));
            L5:
                BitableFpsTracer r12 = r0.a;
                List<com.bytedance.ee.bear.bitable.statistic.h> r3 = r12.q;
                com.bytedance.ee.bear.bitable.statistic.inner.e r4 = r0.b;
                Iterator r13 = ((CopyOnWriteArrayList) r3).iterator();
            L7:
                if (r13.hasNext() == false) goto L9;
                ((com.bytedance.ee.bear.bitable.statistic.h) r13.next()).a(r4.getLogger(), r12, r8, r10);
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

        public d(BitableFpsTracer r1) {
            this.a = r1;
        }

        public final void fpsCallBack(double r4) {
            this.a.l().post(new a(this.a, r4));
        }
    }

    public static final class e implements et3.c.c {
        public final /* synthetic */ BitableFpsTracer a;

        public static final class a implements Runnable {
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ BitableFpsTracer b;

            public a(JSONObject r1, BitableFpsTracer r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Iterator<String> r0 = this.a.keys();
                JSONObject r1 = this.a;
                BitableFpsTracer r2 = this.b;
            L4:
                if (r0.hasNext() == false) goto L12;
                String r3 = r0.next();
                int r4 = r1.optInt(r3, 0);
                if (r4 == 0) goto L4;
                HashMap<String, Long> r5 = r2.p;
                Long r6 = r5.get(r3);
                if (r6 == null) goto L10;
                long r7 = r6.longValue();
            L11:
                r5.put(r3, Long.valueOf(r7 + ((long) r4)));
                goto L4
            L10:
                r7 = 0;
                goto L11
            L12:
                BitableFpsTracer r8 = this.b;
                int r9 = BitableFpsTracer.u;
                r8.o();
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

        public e(BitableFpsTracer r1) {
            this.a = r1;
        }

        public final void dropFrame(JSONObject r4) {
            BitableFpsTracer r0 = this.a;
            r0.r = i.e;
            r0.l().post(new a(r4, this.a));
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ BitableFpsTracer a;

        public f(BitableFpsTracer r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableFpsTracer r0 = this.a;     // Catch: Throwable -> L4
            r0.o = false;     // Catch: Throwable -> L4
            r0.l = System.currentTimeMillis();     // Catch: Throwable -> L4
            r0.s.c();     // Catch: Throwable -> L4
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
        public final /* synthetic */ BitableFpsTracer a;
        public final /* synthetic */ long b;

        public static final class a implements Runnable {
            public final /* synthetic */ BitableFpsTracer a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (this.a.n.contains(this) == false) goto L9;
                this.a.n.remove(this);     // Catch: Throwable -> L6
                this.a.stop();     // Catch: Throwable -> L6
                return;
            }

            public a(BitableFpsTracer r1) {
                this.a = r1;
            }
        }

        public g(BitableFpsTracer r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.start();     // Catch: Throwable -> L4
            BitableFpsTracer r1 = this.a;     // Catch: Throwable -> L4
            a r0 = new a(r1);     // Catch: Throwable -> L4
            r1.n.add(r0);     // Catch: Throwable -> L4
            this.a.l().postDelayed(r0, this.b);     // Catch: Throwable -> L4
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
        public final /* synthetic */ BitableFpsTracer a;

        public h(BitableFpsTracer r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = this.a.k.decrementAndGet();
            if (r0 >= 0) goto L6;
            int r1 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
            com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableFpsTracer", this.a.h + " stop count error: " + r0);
            BitableFpsTracer.n(this.a);
            return;
        L6:
            if (r0 != 0) goto L9;
            BitableFpsTracer r2 = this.a;
            r2.f.set(true);
            r2.m = System.currentTimeMillis();
            r2.s.d();
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
        ((CopyOnWriteArrayList) this.q).clear();
    }

    public final void o() {
        BitableFpsTracer r0 = this;
        if ((!r0.p.isEmpty()) == false) goto L44;
        c r1 = r0.t;
        HashMap<String, Long> r12 = r0.p;
        boolean r13 = r0.o;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "frames");
        if (((Boolean) BitableStatisticConstant$Debug.b.getValue()).booleanValue() == false) goto L7;
        int r4 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "BitableFpsTracer " + ("dropFrameCallBack isForceStop:" + r13 + ' ' + r12));
    L7:
        HashMap r5 = new HashMap();
        BitableFpsTracer r6 = r1.a;
        Iterator<Map.Entry<String, Long>> r7 = r12.entrySet().iterator();
        long r2 = 0;
        long r8 = 0;
        long r9 = 0;
        long r11 = 0;
        long r14 = 0;
    L9:
        if (r7.hasNext() == false) goto L27;
        Map.Entry<String, Long> r20 = r7.next();
        Integer r21 = StringsKt.toIntOrNull(r20.getKey());
        if (r21 == null) goto L26;
        long r22 = r20.getValue().longValue();
        long r3 = ((long) r21.intValue()) * r22;
        long r10 = r9 + r22;
        r14 = r14 + r3;
        BitableStatisticConstant$FpsDropState.a r16 = BitableStatisticConstant$FpsDropState.Companion;
        int r26 = r21.intValue();
        r16.getClass();
        BitableStatisticConstant$FpsDropState r17 = BitableStatisticConstant$FpsDropState.a.a(r26);
        Long r18 = (Long) r5.get(r17.getTitle());
        if (r18 == null) goto L15;
        long r19 = r18.longValue();
    L16:
        r5.put(r17.getTitle(), Long.valueOf(r19 + r22));
        float r23 = (r21.intValue() * 60) / r6.r;
        if (r23 < 3.0f) goto L24;
        r2 = r2 + r3;
        if (r23 < 7.0f) goto L22;
        r11 = r11 + r3;
    L22:
        if (r23 < 25.0f) goto L24;
        r8 = r8 + r3;
    L24:
        r9 = r10;
        goto L26
    L15:
        r19 = 0;
    L26:
        r7 = r7;
        r1 = r1;
        goto L9
    L27:
        c r24 = r1;
        HashMap r27 = new HashMap();
        if (r9 <= 0) goto L33;
        Iterator r28 = r5.entrySet().iterator();
    L31:
        if (r28.hasNext() == false) goto L33;
        Map.Entry r29 = (Map.Entry) r28.next();
        r27.put(r29.getKey(), Float.valueOf(((Number) r29.getValue()).longValue() / r9));
        r8 = r8;
    L33:
        float r30 = r9 + r14;
        HashMap r31 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hitch_dur_ratio", Float.valueOf(r14 / r30)), TuplesKt.to("drop3_dur_ratio", Float.valueOf(r2 / r30)), TuplesKt.to("drop7_dur_ratio", Float.valueOf(r11 / r30)), TuplesKt.to("drop25_dur_ratio", Float.valueOf(r8 / r30))});
        int r32 = i.f;
        BitableFpsTracer r110 = r24.a;
        com.bytedance.ee.bear.bitable.statistic.a r33 = new com.bytedance.ee.bear.bitable.statistic.a(r32, r110.r);
        List<com.bytedance.ee.bear.bitable.statistic.h> r34 = r110.q;
        com.bytedance.ee.bear.bitable.statistic.inner.e r111 = r24.b;
        Iterator r112 = ((CopyOnWriteArrayList) r34).iterator();
    L34:
        boolean r113 = false;
    L36:
        if (r112.hasNext() == false) goto L41;
        if (((com.bytedance.ee.bear.bitable.statistic.h) r112.next()).d(r111.getLogger(), r110, r12, r27, r31, r13, r33) == true) goto L40;
        if (r113 == false) goto L34;
    L40:
        r113 = true;
        goto L36
    L41:
        r0 = this;
        if (r113 == false) goto L44;
        r0.p.clear();
    L44:
        r0.f.set(false);
        j();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void start() {
        if (this.k.getAndIncrement() != 0) goto L6;
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

    public static final void n(BitableFpsTracer r3) {
        r3.getClass();
        int r0 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "BitableFpsTracer " + (r3.h + " clear"));
        if (r3.k.get() == 0) goto L6;
        r3.f.set(true);
        r3.m = System.currentTimeMillis();
        r3.s.d();
    L8:
        r3.k.set(0);
        Iterator<T> r1 = r3.n.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r3.l().removeCallbacks((Runnable) r1.next());
        goto L10
    L12:
        r3.n.clear();
        return;
    L6:
        if (r3.o == false) goto L8;
        r3.f.set(true);
        r3.o();
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void a(long r3) {
        l().post(new g(this, r3));
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace, com.bytedance.ee.bear.bitable.statistic.n
    public final synchronized void b(Boolean r1) {
        monitor-enter(this);
        g();     // Catch: Throwable -> L6
        super.b(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void d(com.bytedance.ee.bear.bitable.statistic.h r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        ((CopyOnWriteArrayList) this.q).add(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void f(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        r2.addOnScrollListener(new BitableFpsTracer$bindRecyclerView$1(this));
    }

    public BitableFpsTracer(String r4, com.bytedance.ee.bear.bitable.statistic.inner.e r5) {
        Intrinsics.checkNotNullParameter(r5, "traceProvider");
        super(r4, r5);
        this.k = new AtomicInteger();
        this.n = new LinkedHashSet();
        this.p = new HashMap();
        this.q = new CopyOnWriteArrayList();
        this.r = 60;
        et3.h r6 = new et3.h("", true, null);
        r6.d = new d(this);
        r6.e = new e(this);
        this.s = r6;
        this.t = new c(this, r5);
    }
}
