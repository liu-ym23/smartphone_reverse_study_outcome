package qk9;

import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import com.larus.media.j;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public final AtomicLong A;
    public final AtomicLong B;
    public final AtomicLong C;
    public final AtomicLong D;
    public final AtomicLong E;
    public final AtomicLong F;
    public final AtomicLong G;
    public final AtomicInteger H;
    public final AtomicInteger I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final AtomicInteger f533568J;
    public final AtomicReference<String> K;
    public final AtomicLong L;
    public final AtomicLong M;
    public final AtomicLong N;
    public final AtomicInteger O;
    public final AtomicInteger P;
    public final AtomicInteger Q;
    public final AtomicInteger R;
    public final AtomicInteger S;
    public final AtomicReference<String> T;
    public final AtomicLong U;
    public final AtomicLong V;
    public final AtomicLong W;
    public final AtomicLong X;
    public final AtomicLong Y;
    public final AtomicLong Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533569a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final AtomicLong f533570a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f533571b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final AtomicLong f533572b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f533573c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final AtomicLong f533574c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f533575d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final AtomicLong f533576d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<Thread> f533577e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Object f533578e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f533579f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f533580f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f533581g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f533582g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f533583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f533584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f533585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f533586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f533587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f533588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f533589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f533590o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f533591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicLong f533592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f533593r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f533594s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicLong f533595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicInteger f533596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f533597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicInteger f533598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f533599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicInteger f533600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicLong f533601z;

    public static final class a {
    }

    /* JADX INFO: renamed from: qk9.b$b, reason: collision with other inner class name */
    public static final class C7352b {
        public static String a(double r100) {
            StringCompanionObject r101 = StringCompanionObject.INSTANCE;
            return String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r100)}, 1));
        }
    }

    static {
    }

    public final void c() {
        if (this.f533579f.compareAndSet(false, true) == false) goto L6;
        long r100 = SystemClock.elapsedRealtime();
        this.f533581g.incrementAndGet();
        this.f533583h.set(r100);
        this.I.incrementAndGet();
        return;
    }

    public final void e() {
        this.L.set(this.f533593r.get());
        this.M.set(this.f533594s.get());
        this.N.set(this.f533595t.get());
        this.O.set(this.f533596u.get());
        this.P.set(this.f533597v.get());
        this.Q.set(this.f533598w.get());
        this.R.set(0);
        this.S.set(0);
        this.T.set("");
        this.U.set(0);
        this.V.set(0);
        this.W.set(0);
        this.X.set(0);
        this.Y.set(0);
        this.Z.set(0);
        this.f533570a0.set(0);
        this.f533572b0.set(0);
        this.f533574c0.set(0);
        this.f533576d0.set(0);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f533590o.getAndSet(false) == false) goto L7;
        this.S.incrementAndGet();
        this.T.set(r100);
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f533579f.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        this.f533568J.incrementAndGet();
        this.K.set(r100);
    }

    public final void f(long r100) {
        this.E.set(r100);
        this.F.set(this.f533584i.get());
        this.G.set(this.f533585j.get());
        this.H.set(this.f533586k.get());
        this.I.set(0);
        this.f533568J.set(0);
        this.K.set("");
        e();
    }

    public final void h(com.larus.media.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        long r101 = RangesKt.coerceAtLeast(r100.f359017g, 1);
        this.A.set(r101);
        this.B.set(r101);
    }

    public final void i(j r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = uk9.a.b(r100.f359085d, r100.f359084c);
        this.f533588m.set(RangesKt.coerceAtLeast(r100.f359083b, 1));
        this.f533589n.set(RangesKt.coerceAtLeast(r101, 1));
        this.f533587l.set(RangesKt.coerceAtLeast(r100.f359090i, 1));
    }

    public b(long r100, Function1 r101) {
        Intrinsics.checkNotNullParameter("OmniAudioEngine", "tag");
        this.f533569a = "OmniAudioEngine";
        this.f533571b = r100;
        this.f533573c = r101;
        this.f533575d = new AtomicBoolean(false);
        this.f533577e = new AtomicReference(null);
        this.f533579f = new AtomicBoolean(false);
        this.f533581g = new AtomicLong(0);
        this.f533583h = new AtomicLong(0);
        this.f533584i = new AtomicLong(0);
        this.f533585j = new AtomicLong(0);
        this.f533586k = new AtomicInteger(0);
        this.f533587l = new AtomicLong(20);
        this.f533588m = new AtomicLong(16000);
        this.f533589n = new AtomicLong(2);
        this.f533590o = new AtomicBoolean(false);
        this.f533591p = new AtomicLong(0);
        this.f533592q = new AtomicLong(0);
        this.f533593r = new AtomicLong(0);
        this.f533594s = new AtomicLong(0);
        this.f533595t = new AtomicLong(0);
        this.f533596u = new AtomicInteger(0);
        this.f533597v = new AtomicInteger(0);
        this.f533598w = new AtomicInteger(0);
        this.f533599x = new AtomicLong(0);
        this.f533600y = new AtomicInteger(0);
        this.f533601z = new AtomicLong(20);
        this.A = new AtomicLong(20);
        this.B = new AtomicLong(20);
        this.C = new AtomicLong(24000);
        this.D = new AtomicLong(2);
        this.E = new AtomicLong(0);
        this.F = new AtomicLong(0);
        this.G = new AtomicLong(0);
        this.H = new AtomicInteger(0);
        this.I = new AtomicInteger(0);
        this.f533568J = new AtomicInteger(0);
        this.K = new AtomicReference("");
        this.L = new AtomicLong(0);
        this.M = new AtomicLong(0);
        this.N = new AtomicLong(0);
        this.O = new AtomicInteger(0);
        this.P = new AtomicInteger(0);
        this.Q = new AtomicInteger(0);
        this.R = new AtomicInteger(0);
        this.S = new AtomicInteger(0);
        this.T = new AtomicReference("");
        this.U = new AtomicLong(0);
        this.V = new AtomicLong(0);
        this.W = new AtomicLong(0);
        this.X = new AtomicLong(0);
        this.Y = new AtomicLong(0);
        this.Z = new AtomicLong(0);
        this.f533570a0 = new AtomicLong(0);
        this.f533572b0 = new AtomicLong(0);
        this.f533574c0 = new AtomicLong(0);
        this.f533576d0 = new AtomicLong(0);
        this.f533578e0 = new Object();
    }

    public static int a(long r100, long r101) {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return (int) RangesKt.coerceAtMost((r100 + (r101 / ((long) 2))) / r101, SieveCacheKt.NodeLinkMask);
    }

    public static void g(AtomicLong r100, long r101) {
        long r102 = r100.get();
        if (r101 <= r102) goto L6;
        r100.compareAndSet(r102, r101);
        return;
    }
}
