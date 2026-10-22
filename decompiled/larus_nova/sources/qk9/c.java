package qk9;

import android.os.SystemClock;
import com.larus.im.internal.delegate.c0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public final AtomicLong A;
    public final AtomicLong B;
    public final AtomicInteger C;
    public final AtomicInteger D;
    public final AtomicInteger E;
    public final AtomicInteger F;
    public final AtomicLong G;
    public final AtomicLong H;
    public qk9.b I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.media.d f533603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f533604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f533605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f533606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f533607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f533608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f533609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f533610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f533611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f533612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f533613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f533614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f533615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicInteger f533616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicInteger f533617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f533618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f533619r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f533620s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicLong f533621t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicLong f533622u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicLong f533623v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicLong f533624w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f533625x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicLong f533626y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicLong f533627z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f533628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f533629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f533630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f533631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f533632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f533633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f533634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f533635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f533636i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f533637j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f533638k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f533639l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f533640m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f533641n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long f533642o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f533643p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final long f533644q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final long f533645r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final long f533646s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final long f533647t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f533648u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f533649v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f533650w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f533651x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final String f533652y;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f533628a == r101.f533628a) goto L12;
            return false;
        L12:
            if (this.f533629b == r101.f533629b) goto L15;
            return false;
        L15:
            if (this.f533630c == r101.f533630c) goto L18;
            return false;
        L18:
            if (this.f533631d == r101.f533631d) goto L21;
            return false;
        L21:
            if (this.f533632e == r101.f533632e) goto L24;
            return false;
        L24:
            if (this.f533633f == r101.f533633f) goto L27;
            return false;
        L27:
            if (this.f533634g == r101.f533634g) goto L30;
            return false;
        L30:
            if (this.f533635h == r101.f533635h) goto L33;
            return false;
        L33:
            if (this.f533636i == r101.f533636i) goto L36;
            return false;
        L36:
            if (this.f533637j == r101.f533637j) goto L39;
            return false;
        L39:
            if (this.f533638k == r101.f533638k) goto L42;
            return false;
        L42:
            if (this.f533639l == r101.f533639l) goto L45;
            return false;
        L45:
            if (this.f533640m == r101.f533640m) goto L48;
            return false;
        L48:
            if (this.f533641n == r101.f533641n) goto L51;
            return false;
        L51:
            if (this.f533642o == r101.f533642o) goto L54;
            return false;
        L54:
            if (this.f533643p == r101.f533643p) goto L57;
            return false;
        L57:
            if (this.f533644q == r101.f533644q) goto L60;
            return false;
        L60:
            if (this.f533645r == r101.f533645r) goto L63;
            return false;
        L63:
            if (this.f533646s == r101.f533646s) goto L66;
            return false;
        L66:
            if (this.f533647t == r101.f533647t) goto L69;
            return false;
        L69:
            if (this.f533648u == r101.f533648u) goto L72;
            return false;
        L72:
            if (this.f533649v == r101.f533649v) goto L75;
            return false;
        L75:
            if (this.f533650w == r101.f533650w) goto L78;
            return false;
        L78:
            if (this.f533651x == r101.f533651x) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.f533652y, r101.f533652y) == true) goto L83;
            return false;
        L83:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f533628a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f533629b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f533630c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f533631d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f533632e;
            int r109 = (((((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.f533633f) * 31) + this.f533634g) * 31) + this.f533635h) * 31;
            long r110 = this.f533636i;
            int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f533637j) * 31;
            long r112 = this.f533638k;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f533639l;
            int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
            long r116 = this.f533640m;
            int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
            long r118 = this.f533641n;
            int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
            long r120 = this.f533642o;
            int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
            long r122 = this.f533643p;
            int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
            long r124 = this.f533644q;
            int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
            long r126 = this.f533645r;
            int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
            long r128 = this.f533646s;
            int r129 = (r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31;
            long r130 = this.f533647t;
            return ((((((((((r129 + ((int) (r130 ^ (r130 >>> 32)))) * 31) + this.f533648u) * 31) + this.f533649v) * 31) + this.f533650w) * 31) + this.f533651x) * 31) + this.f533652y.hashCode();
        }

        public final String toString() {
            return "MonitorSnapshot(round=" + this.f533628a + ", elapsedMs=" + this.f533629b + ", receivedMs=" + this.f533630c + ", consumedMs=" + this.f533631d + ", writtenMs=" + this.f533632e + ", receiveCount=" + this.f533633f + ", consumeCount=" + this.f533634g + ", writeCount=" + this.f533635h + ", queueMs=" + this.f533636i + ", queueItems=" + this.f533637j + ", maxInputGapMs=" + this.f533638k + ", maxConsumeGapMs=" + this.f533639l + ", maxWriteCostMs=" + this.f533640m + ", maxWorkerLoopGapMs=" + this.f533641n + ", maxWorkerLoopCostMs=" + this.f533642o + ", maxTakeWaitMs=" + this.f533643p + ", maxWriteToTrackCostMs=" + this.f533644q + ", maxPostWriteCostMs=" + this.f533645r + ", maxAudioTrackDumpCostMs=" + this.f533646s + ", maxReferenceCallbackCostMs=" + this.f533647t + ", partialWriteCount=" + this.f533648u + ", zeroWriteCount=" + this.f533649v + ", writeErrorCount=" + this.f533650w + ", nonPlayingWaitCount=" + this.f533651x + ", audioTrackUnderrunLog=" + this.f533652y + ')';
        }

        public final String b() {
            double r100 = RangesKt.coerceAtLeast(this.f533629b / 1000.0d, 0.001d);
            return "round=" + this.f533628a + " elapsedMs=" + this.f533629b + " receivedMs=" + this.f533630c + " consumedMs=" + this.f533631d + " writtenMs=" + this.f533632e + " receiveFps=" + a(((double) this.f533633f) / r100) + " consumeFps=" + a(((double) this.f533634g) / r100) + " writeFps=" + a(((double) this.f533635h) / r100) + " queueMs=" + this.f533636i + " queueItems=" + this.f533637j + " maxInputGapMs=" + this.f533638k + " maxConsumeGapMs=" + this.f533639l + " maxWriteCostMs=" + this.f533640m + " maxWorkerLoopGapMs=" + this.f533641n + " maxWorkerLoopCostMs=" + this.f533642o + " maxTakeWaitMs=" + this.f533643p + " maxWriteToTrackCostMs=" + this.f533644q + " maxPostWriteCostMs=" + this.f533645r + " maxAudioTrackDumpCostMs=" + this.f533646s + " maxReferenceCallbackCostMs=" + this.f533647t + " partialWrite=" + this.f533648u + " zeroWrite=" + this.f533649v + " writeError=" + this.f533650w + " nonPlayingWait=" + this.f533651x + this.f533652y;
        }

        public static String a(double r100) {
            StringCompanionObject r101 = StringCompanionObject.INSTANCE;
            return String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r100)}, 1));
        }

        public b(long r100, long r101, long r102, long r110, long r111, int r112, int r113, int r114, long r115, int r210, long r211, long r212, long r213, long r214, long r215, long r310, long r311, long r312, long r313, long r314, int r410, int r411, int r412, int r413, String r414) {
            Intrinsics.checkNotNullParameter(r414, "audioTrackUnderrunLog");
            this.f533628a = r100;
            this.f533629b = r101;
            this.f533630c = r102;
            this.f533631d = r110;
            this.f533632e = r111;
            this.f533633f = r112;
            this.f533634g = r113;
            this.f533635h = r114;
            this.f533636i = r115;
            this.f533637j = r210;
            this.f533638k = r211;
            this.f533639l = r212;
            this.f533640m = r213;
            this.f533641n = r214;
            this.f533642o = r215;
            this.f533643p = r310;
            this.f533644q = r311;
            this.f533645r = r312;
            this.f533646s = r313;
            this.f533647t = r314;
            this.f533648u = r410;
            this.f533649v = r411;
            this.f533650w = r412;
            this.f533651x = r413;
            this.f533652y = r414;
        }
    }

    static {
    }

    public final void e() {
        this.f533605d.set(0);
        this.f533619r.set(0);
        this.G.set(0);
        this.H.set(0);
        qk9.b r100 = this.I;
        if (r100 == null) goto L6;
        r100.f533590o.set(false);
        r100.f533599x.set(0);
        r100.f533600y.set(0);
        return;
    }

    public final long g(int r100) {
        com.larus.media.d r101 = this.f533603b;
        int r102 = 1;
        if (r101.f359016f.f359140a == true) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        r102 = uk9.a.c(r101.f359014d, 1);
    L13:
        int r104 = uk9.a.a(this.f533603b.f359015e) * r102;
        int r105 = this.f533603b.f359013c;
        if (r100 <= 0) goto L19;
        if (r105 <= 0) goto L19;
        if (r104 <= 0) goto L19;
        return (((long) r100) * 1000) / (((long) r105) * ((long) r104));
    L19:
        return 0;
    L5:
        if (r101.f359015e != 2) goto L9;
        if (r101.f359014d != 12) goto L9;
        r103 = true;
        goto L10
    }

    public static void h(AtomicLong r100, long r101) {
        long r102 = r100.get();
        if (r101 <= r102) goto L6;
        r100.compareAndSet(r102, r101);
        return;
    }

    public final b a(long r410, int r411) {
        long r100 = this.f533613l.get();
        long r101 = this.f533614m.get();
        long r110 = this.f533615n.get();
        int r111 = this.f533616o.get();
        int r112 = this.f533617p.get();
        int r113 = this.f533618q.get();
        return new b(this.f533610i.get(), r410 - this.f533612k.get(), r100, r101, r110, r111, r112, r113, this.f533619r.get(), r411, this.f533620s.get(), this.f533621t.get(), this.f533622u.get(), this.f533623v.get(), this.f533624w.get(), this.f533625x.get(), this.f533626y.get(), this.f533627z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.f533604c.invoke());
    }

    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        long r102 = SystemClock.elapsedRealtime();
        if (this.f533611j.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        b r103 = a(r102, r101);
        c0.f348199b.i(this.f533602a, "monitor_round_end: reason=" + r100 + ' ' + r103.b());
        qk9.b r104 = this.I;
        if (r104 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (r104.f533590o.getAndSet(false) == false) goto L11;
        r104.S.incrementAndGet();
        r104.T.set(r100);
    L11:
        this.f533619r.set(0);
    }

    public final void c(long r110, int r111) {
        if (this.f533611j.get() == true) goto L5;
        return;
    L5:
        if ((r110 - this.f533608g.get()) < 1000) goto L53;
        b r112 = a(r110, r111);
        if (r112.f533650w <= 0) goto L11;
        String r100 = "write_error";
    L45:
        if (r100 != null) goto L48;
        return;
    L48:
        if (f(this.f533608g, r110, 1000) == true) goto L50;
        return;
    L50:
        c0.f348199b.w(this.f533602a, "monitor_issue: type=" + r100 + ' ' + r112.b());
        return;
    L11:
        if (r112.f533649v <= 0) goto L14;
        r100 = "zero_write";
        goto L45
    L14:
        if (r112.f533648u <= 0) goto L17;
        r100 = "partial_write";
        goto L45
    L17:
        if (r112.f533651x <= 0) goto L20;
        r100 = "non_playing";
        goto L45
    L20:
        if (r112.f533639l <= 80) goto L25;
        if (r112.f533636i > 40) goto L25;
        r100 = "input_starvation";
    L25:
        if (r112.f533638k <= 80) goto L30;
        if (r112.f533636i > 40) goto L30;
        r100 = "underrun_risk";
    L30:
        if (r112.f533636i < 1000) goto L35;
        if (r112.f533630c <= (r112.f533631d + 1000)) goto L35;
        r100 = "playback_backlog";
    L35:
        if (r112.f533641n < 60) goto L37;
        r100 = "worker_jank";
        goto L45
    L37:
        long r101 = r112.f533640m;
        long r102 = r112.f533631d;
        if (r102 <= 0) goto L40;
        long r103 = RangesKt.coerceAtLeast(r112.f533632e / RangesKt.coerceAtLeast(r102, 1), 1);
    L42:
        if (r101 <= (r103 + 20)) goto L44;
        r100 = "slow_write";
        goto L45
    L44:
        r100 = null;
        goto L45
    L40:
        r103 = 20;
        goto L42
    }

    public c(String r100, com.larus.media.d r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "audioTrackUnderrunLogProvider");
        this.f533602a = r100;
        this.f533603b = r101;
        this.f533604c = r102;
        this.f533605d = new AtomicLong(0);
        this.f533606e = new AtomicLong(0);
        this.f533607f = new AtomicLong(0);
        this.f533608g = new AtomicLong(0);
        this.f533609h = new AtomicLong(0);
        this.f533610i = new AtomicLong(0);
        this.f533611j = new AtomicBoolean(false);
        this.f533612k = new AtomicLong(0);
        this.f533613l = new AtomicLong(0);
        this.f533614m = new AtomicLong(0);
        this.f533615n = new AtomicLong(0);
        this.f533616o = new AtomicInteger(0);
        this.f533617p = new AtomicInteger(0);
        this.f533618q = new AtomicInteger(0);
        this.f533619r = new AtomicLong(0);
        this.f533620s = new AtomicLong(0);
        this.f533621t = new AtomicLong(0);
        this.f533622u = new AtomicLong(0);
        this.f533623v = new AtomicLong(0);
        this.f533624w = new AtomicLong(0);
        this.f533625x = new AtomicLong(0);
        this.f533626y = new AtomicLong(0);
        this.f533627z = new AtomicLong(0);
        this.A = new AtomicLong(0);
        this.B = new AtomicLong(0);
        this.C = new AtomicInteger(0);
        this.D = new AtomicInteger(0);
        this.E = new AtomicInteger(0);
        this.F = new AtomicInteger(0);
        this.G = new AtomicLong(0);
        this.H = new AtomicLong(0);
    }

    public static boolean f(AtomicLong r100, long r101, long r102) {
        long r103 = r100.get();
        if ((r101 - r103) >= r102) goto L7;
        return false;
    L7:
        return r100.compareAndSet(r103, r101);
    }

    public final void d(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        c0.f348199b.i(this.f533602a, "monitor_state: " + r100 + " round=" + this.f533610i.get() + " playState=" + r101 + " queueMs=" + this.f533619r.get() + " queueItems=" + r102 + this.f533604c.invoke());
    }
}
