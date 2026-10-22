package qk9;

import android.os.SystemClock;
import com.larus.im.internal.delegate.c0;
import com.larus.media.j;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f533654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f533655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f533656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f533657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f533658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f533659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f533660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f533661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f533662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f533663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f533664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f533665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f533666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f533667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f533668p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicLong f533669q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f533670r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f533671s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicInteger f533672t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicInteger f533673u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicLong f533674v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicLong f533675w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f533676x;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f533677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f533678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f533679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f533680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f533681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f533682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f533683g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f533684h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f533685i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f533686j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f533687k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f533677a == r101.f533677a) goto L12;
            return false;
        L12:
            if (this.f533678b == r101.f533678b) goto L15;
            return false;
        L15:
            if (this.f533679c == r101.f533679c) goto L18;
            return false;
        L18:
            if (this.f533680d == r101.f533680d) goto L21;
            return false;
        L21:
            if (this.f533681e == r101.f533681e) goto L24;
            return false;
        L24:
            if (this.f533682f == r101.f533682f) goto L27;
            return false;
        L27:
            if (this.f533683g == r101.f533683g) goto L30;
            return false;
        L30:
            if (this.f533684h == r101.f533684h) goto L33;
            return false;
        L33:
            if (this.f533685i == r101.f533685i) goto L36;
            return false;
        L36:
            if (this.f533686j == r101.f533686j) goto L39;
            return false;
        L39:
            if (this.f533687k == r101.f533687k) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f533677a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f533678b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f533679c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f533680d;
            int r107 = (((((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f533681e) * 31) + this.f533682f) * 31) + this.f533683g) * 31) + this.f533684h) * 31;
            long r108 = this.f533685i;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f533686j;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f533687k;
            return r111 + ((int) (r112 ^ (r112 >>> 32)));
        }

        public final String toString() {
            return "MonitorSnapshot(round=" + this.f533677a + ", elapsedMs=" + this.f533678b + ", readMs=" + this.f533679c + ", readBytes=" + this.f533680d + ", readCount=" + this.f533681e + ", idleReadCount=" + this.f533682f + ", readErrorCount=" + this.f533683g + ", readExceptionCount=" + this.f533684h + ", maxReadGapMs=" + this.f533685i + ", maxReadCostMs=" + this.f533686j + ", maxWorkerLoopGapMs=" + this.f533687k + ')';
        }

        public final String a() {
            double r100 = ((double) this.f533681e) / RangesKt.coerceAtLeast(this.f533678b / 1000.0d, 0.001d);
            StringBuilder r101 = new StringBuilder("round=");
            r101.append(this.f533677a);
            r101.append(" elapsedMs=");
            r101.append(this.f533678b);
            r101.append(" readMs=");
            r101.append(this.f533679c);
            r101.append(" readBytes=");
            r101.append(this.f533680d);
            r101.append(" readFps=");
            StringCompanionObject r102 = StringCompanionObject.INSTANCE;
            r101.append(String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r100)}, 1)));
            r101.append(" idleRead=");
            r101.append(this.f533682f);
            r101.append(" readError=");
            r101.append(this.f533683g);
            r101.append(" readException=");
            r101.append(this.f533684h);
            r101.append(" maxReadGapMs=");
            r101.append(this.f533685i);
            r101.append(" maxReadCostMs=");
            r101.append(this.f533686j);
            r101.append(" maxWorkerLoopGapMs=");
            r101.append(this.f533687k);
            return r101.toString();
        }

        public b(long r100, long r101, long r102, long r110, int r111, int r112, int r113, int r114, long r115, long r116, long r210) {
            this.f533677a = r100;
            this.f533678b = r101;
            this.f533679c = r102;
            this.f533680d = r110;
            this.f533681e = r111;
            this.f533682f = r112;
            this.f533683g = r113;
            this.f533684h = r114;
            this.f533685i = r115;
            this.f533686j = r116;
            this.f533687k = r210;
        }
    }

    static {
    }

    public final b a(long r210) {
        return new b(this.f533655c.get(), r210 - this.f533657e.get(), this.f533658f.get(), this.f533659g.get(), this.f533660h.get(), this.f533661i.get(), this.f533662j.get(), this.f533663k.get(), this.f533664l.get(), this.f533665m.get(), this.f533666n.get());
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        long r101 = SystemClock.elapsedRealtime();
        if (this.f533656d.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        c0.f348199b.i(this.f533653a, "recorder_monitor_round_end: reason=" + r100 + ' ' + a(r101).a());
    }

    public final void c(long r110) {
        if (this.f533656d.get() == true) goto L5;
        return;
    L5:
        if ((r110 - this.f533670r.get()) < 1000) goto L46;
        b r100 = a(r110);
        if (r100.f533684h <= this.f533673u.get()) goto L11;
        this.f533673u.set(r100.f533684h);
        String r101 = "read_exception";
    L38:
        if (r101 != null) goto L41;
        return;
    L41:
        if (f(this.f533670r, r110, 1000) == true) goto L43;
        return;
    L43:
        c0.f348199b.w(this.f533653a, "recorder_monitor_issue: type=" + r101 + ' ' + r100.a());
        return;
    L11:
        if (r100.f533683g <= this.f533672t.get()) goto L13;
        this.f533672t.set(r100.f533683g);
        r101 = "read_error";
        goto L38
    L13:
        long r102 = r100.f533678b;
        if (r102 > 1000) goto L16;
    L18:
        long r103 = r100.f533685i;
        if (r103 > 80) goto L21;
    L23:
        long r104 = r100.f533687k;
        if (r104 >= 80) goto L26;
    L28:
        long r105 = r100.f533686j;
        int r106 = r100.f533681e;
        if (r106 <= 0) goto L31;
        long r107 = RangesKt.coerceAtLeast(r100.f533679c / ((long) RangesKt.coerceAtLeast(r106, 1)), 1);
    L33:
        if (r105 > (r107 + 20)) goto L35;
    L37:
        r101 = null;
        goto L38
    L35:
        if (r100.f533686j <= this.f533675w.get()) goto L37;
        this.f533675w.set(r100.f533686j);
        r101 = "slow_read";
        goto L38
    L31:
        r107 = 20;
        goto L33
    L26:
        if (r104 <= this.f533676x.get()) goto L28;
        this.f533676x.set(r100.f533687k);
        r101 = "worker_jank";
        goto L38
    L21:
        if (r103 <= this.f533674v.get()) goto L23;
        this.f533674v.set(r100.f533685i);
        r101 = "capture_gap";
        goto L38
    L16:
        if ((r100.f533679c + 200) >= r102) goto L18;
        r101 = "capture_starvation";
        goto L38
    }

    public final void d(long r100) {
        if (this.f533656d.get() == true) goto L5;
        return;
    L5:
        if (f(this.f533671s, r100, 2000) == false) goto L10;
        c0.f348199b.i(this.f533653a, "recorder_monitor_summary: " + a(r100).a());
        return;
    }

    public d(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f533653a = r100;
        this.f533654b = r101;
        this.f533655c = new AtomicLong(0);
        this.f533656d = new AtomicBoolean(false);
        this.f533657e = new AtomicLong(0);
        this.f533658f = new AtomicLong(0);
        this.f533659g = new AtomicLong(0);
        this.f533660h = new AtomicInteger(0);
        this.f533661i = new AtomicInteger(0);
        this.f533662j = new AtomicInteger(0);
        this.f533663k = new AtomicInteger(0);
        this.f533664l = new AtomicLong(0);
        this.f533665m = new AtomicLong(0);
        this.f533666n = new AtomicLong(0);
        this.f533667o = new AtomicLong(0);
        this.f533668p = new AtomicLong(0);
        this.f533669q = new AtomicLong(0);
        this.f533670r = new AtomicLong(0);
        this.f533671s = new AtomicLong(0);
        this.f533672t = new AtomicInteger(0);
        this.f533673u = new AtomicInteger(0);
        this.f533674v = new AtomicLong(0);
        this.f533675w = new AtomicLong(0);
        this.f533676x = new AtomicLong(0);
    }

    public final void g(int r100, int r101) {
        long r102 = SystemClock.elapsedRealtime();
        if (this.f533656d.compareAndSet(false, true) == false) goto L6;
        long r103 = this.f533655c.incrementAndGet();
        this.f533657e.set(r102);
        this.f533658f.set(0);
        this.f533659g.set(0);
        this.f533660h.set(0);
        this.f533661i.set(0);
        this.f533662j.set(0);
        this.f533663k.set(0);
        this.f533664l.set(0);
        this.f533665m.set(0);
        this.f533666n.set(0);
        this.f533667o.set(0);
        this.f533668p.set(0);
        this.f533669q.set(0);
        this.f533670r.set(0);
        this.f533671s.set(0);
        this.f533672t.set(0);
        this.f533673u.set(0);
        this.f533674v.set(0);
        this.f533675w.set(0);
        this.f533676x.set(0);
        c0.f348199b.i(this.f533653a, "recorder_monitor_round_start: round=" + r103 + " recordingState=" + r100 + " bufferSize=" + r101);
        return;
    }

    public static boolean f(AtomicLong r100, long r101, long r102) {
        long r103 = r100.get();
        if ((r101 - r103) >= r102) goto L7;
        return false;
    L7:
        return r100.compareAndSet(r103, r101);
    }

    public final void e(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        c0.f348199b.i(this.f533653a, "recorder_monitor_state: " + r100 + " round=" + this.f533655c.get() + " recordingState=" + r101 + " bufferSize=" + r102);
    }
}
