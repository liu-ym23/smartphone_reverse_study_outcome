package x68;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.larus.im.service.audio.y;
import com.larus.voicecall.impl.plugins.o2;
import com.larus.voicecall.impl.plugins.p2;
import com.larus.voicecall.impl.plugins.q2;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class u {
    public static final AtomicBoolean G = null;
    public static final AtomicBoolean H = null;
    public final r A;
    public final w B;
    public final s C;
    public final f2a.d D;
    public String E;
    public boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f562662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<y> f562663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f562664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Unit> f562665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f562666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f562667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f562668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f562669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f562670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f562671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f562672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f562673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public tf9.b f562674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f562675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f562676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f562677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Long> f562678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f562679r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f562680s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f562681t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public da9.e f562682u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f562683v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f562684w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f562685x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f562686y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f562687z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f562688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f562689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f562690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f562691d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f562688a == r101.f562688a) goto L12;
            return false;
        L12:
            if (this.f562689b == r101.f562689b) goto L15;
            return false;
        L15:
            if (this.f562690c == r101.f562690c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f562691d, r101.f562691d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f562688a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f562689b) * 31;
            long r102 = this.f562690c;
            return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f562691d.hashCode();
        }

        public final String toString() {
            return "PushDiagnosticsSnapshot(durationMs=" + this.f562688a + ", targetFps=" + this.f562689b + ", minPushFrameIntervalMs=" + this.f562690c + ", stats=" + this.f562691d + ')';
        }

        public b(long r100, int r101, long r102, c r103) {
            Intrinsics.checkNotNullParameter(r103, "stats");
            this.f562688a = r100;
            this.f562689b = r101;
            this.f562690c = r102;
            this.f562691d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f562692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f562693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f562694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f562695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f562696e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f562697f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f562698g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f562699h;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f562692a == r101.f562692a) goto L12;
            return false;
        L12:
            if (this.f562693b == r101.f562693b) goto L15;
            return false;
        L15:
            if (this.f562694c == r101.f562694c) goto L18;
            return false;
        L18:
            if (this.f562695d == r101.f562695d) goto L21;
            return false;
        L21:
            if (this.f562696e == r101.f562696e) goto L24;
            return false;
        L24:
            if (this.f562697f == r101.f562697f) goto L27;
            return false;
        L27:
            if (this.f562698g == r101.f562698g) goto L30;
            return false;
        L30:
            if (this.f562699h == r101.f562699h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f562692a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f562693b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f562694c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f562695d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f562696e;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f562697f;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f562698g;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f562699h;
            return r113 + ((int) (r114 ^ (r114 >>> 32)));
        }

        public final String toString() {
            return "PushDiagnosticsStats(captureFrames=" + this.f562692a + ", serviceNullDrops=" + this.f562693b + ", realPushes=" + this.f562694c + ", repeatedPushes=" + this.f562695d + ", pushAttempts=" + this.f562696e + ", pushFailures=" + this.f562697f + ", pushDurationUs=" + this.f562698g + ", maxPushDurationUs=" + this.f562699h + ')';
        }

        public /* synthetic */ c(int r110) {
            this(0, 0, 0, 0, 0, 0, 0, 0);
        }

        public c(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114) {
            this.f562692a = r100;
            this.f562693b = r101;
            this.f562694c = r102;
            this.f562695d = r110;
            this.f562696e = r111;
            this.f562697f = r112;
            this.f562698g = r113;
            this.f562699h = r114;
        }
    }

    static {
        G = new AtomicBoolean(false);
        H = new AtomicBoolean(false);
    }

    public final Handler a() {
        return (Handler) this.f562687z.getValue();
    }

    public final void c() {
        if (this.f562667f == true) goto L5;
        return;
    L5:
        if (this.f562668g == false) goto L7;
        return;
    L7:
        if (this.f562671j <= 0) goto L77;
        Object r100 = this.f562684w;
        monitor-enter(r100);
    L65:
        th = move-exception;
        throw th;
    L13:
        if ((SystemClock.elapsedRealtime() - this.f562672k) >= this.f562671j) goto L16;
        monitor-exit(r100);
        return;
    L16:
        tf9.b r101 = this.f562674m;     // Catch: Throwable -> L65
        if (r101 != null) goto L20;
        monitor-exit(r100);
        return;
    L20:
        String r102 = this.f562675n;     // Catch: Throwable -> L65
        if (r102 != null) goto L24;
        monitor-exit(r100);
        return;
    L24:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r100);
        y r104 = this.f562663b.invoke();
        boolean r105 = false;
        if (r104 != null) goto L69;
        this.f562680s.f562693b++;
        this.f562681t.f562693b++;
        long r110 = SystemClock.elapsedRealtime();
        Long r106 = (Long) ((LinkedHashMap) this.f562678q).get("screen_share_service_null");
        if (r106 == null) goto L31;
        long r111 = r106.longValue();
    L33:
        if (r111 != 0) goto L35;
    L37:
        this.f562678q.put("screen_share_service_null", Long.valueOf(r110));
        r105 = true;
    L38:
        if (r105 == false) goto L73;
        Map r107 = MapsKt.mapOf(TuplesKt.to("isRepeatedFrame", Boolean.TRUE));
        f2a.c r108 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r108.f475230c.f475256d = "AVKitScreenManager";
        r108.f475230c.f475254b = CollectionsKt.listOf(r102);
        r108.f(new v("screen_share_service_null", r107));
        f2a.c.c(r108, null, 15);
        return;
    L73:
        return;
    L35:
        if ((r110 - r111) >= 30000) goto L37;
    L31:
        r111 = 0;
        goto L33
    L69:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L44
        d(r104, r102, r101, true);     // Catch: Throwable -> L44
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);
        if (r113 == null) goto L74;
        long r114 = SystemClock.elapsedRealtime();
        Long r115 = (Long) ((LinkedHashMap) this.f562678q).get("repeated_push_failure");
        if (r115 == null) goto L51;
        long r116 = r115.longValue();
    L53:
        if (r116 != 0) goto L55;
    L57:
        this.f562678q.put("repeated_push_failure", Long.valueOf(r114));
        boolean r117 = true;
    L58:
        if (r117 == false) goto L75;
        Pair[] r118 = new Pair[2];
        r118[0] = TuplesKt.to("error", r113.getClass().getSimpleName());
        String r119 = r113.getMessage();
        if (r119 != null) goto L63;
        r119 = "";
    L63:
        r118[1] = TuplesKt.to("error_msg", r119);
        Map r120 = MapsKt.mapOf(r118);
        f2a.c r121 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r121.f475230c.f475256d = "AVKitScreenManager";
        r121.f475230c.f475254b = CollectionsKt.listOf(r102);
        r121.f(new v("repeated_push_failure", r120));
        f2a.c.c(r121, null, 15);
        return;
    L75:
        return;
    L55:
        if ((r114 - r116) >= 30000) goto L57;
        r117 = false;
        goto L58
    L51:
        r116 = 0;
        goto L53
    L74:
        return;
    L44:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    }

    public final void e() {
        f2a.c r100 = this.D.b("ScreenShareManagerRelease");
        r100.f475230c.f475256d = "AVKitScreenManager.release";
        String r101 = this.E;
        if (r101 == null) goto L5;
        List<String> r102 = CollectionsKt.listOf(r101);
    L6:
        r100.f475230c.f475254b = r102;
        f2a.c.c(r100, null, 15);
        i();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        ((ba9.a) this.f562666e.getValue()).release();     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void f() {
        if (this.f562670i == true) goto L5;
        return;
    L5:
        double r100 = RangesKt.coerceAtLeast(this.f562683v, 1);
        z68.c.f570543a.getClass();
        Object r101 = z68.c.f570544b;
        monitor-enter(r101);
        z68.a r102 = z68.c.f570546d;     // Catch: Throwable -> L13
        monitor-exit(r101);
        if (r102 == null) goto L18;
        z68.c.g("flow_screen_share_capture_fps", MapsKt.mapOf(new Pair[]{TuplesKt.to("sample_interval_ms", 1000), TuplesKt.to("capture_fps", Double.valueOf(r100)), TuplesKt.to("output_fps", Double.valueOf(r100)), TuplesKt.to("profile", z68.c.e(r102.f570533e, r102.f570534f, r102.f570535g)), TuplesKt.to("resolution", z68.c.k(r102.f570533e, r102.f570534f))}));
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void h() {
        if (this.f562671j > 0) goto L5;
        return;
    L5:
        if (this.f562667f == true) goto L7;
        return;
    L7:
        if (this.f562668g == true) goto L13;
        a().removeCallbacks(this.A);
        a().postDelayed(this.A, this.f562671j);
        return;
    }

    public final void i() {
        this.f562685x.set(false);
        a().removeCallbacks(this.B);
        b(true);
    }

    public final void j() {
        if (this.f562671j <= 0) goto L5;
    L6:
        a().removeCallbacks(this.A);
    L7:
        Object r100 = this.f562684w;
        monitor-enter(r100);
        this.f562672k = 0;     // Catch: Throwable -> L12
        this.f562673l = 0;     // Catch: Throwable -> L12
        this.f562674m = null;     // Catch: Throwable -> L12
        this.f562675n = null;     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f562674m == null) goto L7;
        goto L6
    }

    public final void g() {
        a().removeCallbacks(this.C);
        if (this.f562670i == true) goto L5;
        return;
    L5:
        a().postDelayed(this.C, 1000);
    }

    public final void b(boolean r310) {
        if (r310 == false) goto L6;
        this.f562685x.set(false);
    L6:
        if (this.f562676o != 0) goto L8;
    L22:
        b r110 = null;
    L23:
        if (r110 != null) goto L25;
        return;
    L25:
        c r100 = r110.f562691d;
        long r101 = r100.f562694c + r100.f562695d;
        final Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("durationMs", Long.valueOf(r110.f562688a)), TuplesKt.to("targetFps", Integer.valueOf(r110.f562689b)), TuplesKt.to("captureFrameCount", Long.valueOf(r100.f562692a)), TuplesKt.to("captureFps", Double.valueOf((r100.f562692a * 1000.0d) / r110.f562688a)), TuplesKt.to("serviceNullDropCount", Long.valueOf(r100.f562693b)), TuplesKt.to("realPushCount", Long.valueOf(r100.f562694c)), TuplesKt.to("realPushFps", Double.valueOf((r100.f562694c * 1000.0d) / r110.f562688a)), TuplesKt.to("repeatedPushCount", Long.valueOf(r100.f562695d)), TuplesKt.to("outputPushCount", Long.valueOf(r101)), TuplesKt.to("outputPushFps", Double.valueOf((r101 * 1000.0d) / r110.f562688a)), TuplesKt.to("pushAttemptCount", Long.valueOf(r100.f562696e)), TuplesKt.to("pushFailureCount", Long.valueOf(r100.f562697f)), TuplesKt.to("avgPushDurationUs", Double.valueOf(r100.f562698g / RangesKt.coerceAtLeast(r100.f562696e, 1))), TuplesKt.to("maxPushDurationUs", Long.valueOf(r100.f562699h)), TuplesKt.to("minPushFrameIntervalMs", Long.valueOf(r110.f562690c))});
        f2a.d r103 = this.D;
        if (r310 == false) goto L28;
        String r104 = "ScreenSharePushDiagnosticsFinal";
    L29:
        f2a.c r105 = r103.b(r104);
        r105.f475230c.f475256d = "AVKitScreenManager.logDiagnosticsSummary";
        String r106 = this.E;
        if (r106 == null) goto L32;
        List<String> r107 = CollectionsKt.listOf(r106);
    L33:
        r105.f475230c.f475254b = r107;
        r105.f(new x68.c(r102));
        f2a.c.c(r105, null, 15);
        return;
    L32:
        r107 = null;
        goto L33
    L28:
        r104 = "ScreenSharePushDiagnostics";
        goto L29
    L8:
        if (this.f562679r == true) goto L22;
        long r108 = SystemClock.elapsedRealtime();
        if (r310 == false) goto L13;
        long r111 = this.f562676o;
    L14:
        long r112 = RangesKt.coerceAtLeast(r108 - r111, 1);
        if (r310 == false) goto L17;
        c r113 = this.f562680s;
    L18:
        r110 = new b(r112, this.f562683v, this.f562671j, new c(r113.f562692a, r113.f562693b, r113.f562694c, r113.f562695d, r113.f562696e, r113.f562697f, r113.f562698g, r113.f562699h));
        if (r310 == false) goto L21;
        this.f562679r = true;
        goto L23
    L21:
        this.f562677p = r108;
        c r109 = this.f562681t;
        r109.f562692a = 0;
        r109.f562693b = 0;
        r109.f562694c = 0;
        r109.f562695d = 0;
        r109.f562696e = 0;
        r109.f562697f = 0;
        r109.f562698g = 0;
        r109.f562699h = 0;
        goto L23
    L17:
        r113 = this.f562681t;
        goto L18
    L13:
        r111 = this.f562677p;
        goto L14
    }

    public static tf9.b k(da9.b r110, boolean r111) {
        int r100 = com.larus.im.internal.delegate.w.n().f348432a;
        int r101 = com.larus.im.internal.delegate.w.n().f348433b;
        da9.a r102 = r110.f467720g;
        return new tf9.b(r102.f467713c, r102.f467711a, r102.f467712b, Math.min(r100, r101), Math.max(r100, r101), r110.f467718e, 1000 * r110.f467715b, r111);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [x68.r] */
    /* JADX WARN: Type inference failed for: r3v14, types: [x68.s] */
    /* JADX WARN: Type inference failed for: r3v22, types: [x68.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [x68.t] */
    public u(Context r100, o2 r101, p2 r102, q2 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "screenShareServiceProvider");
        Intrinsics.checkNotNullParameter(r102, "useExternalCaptureProvider");
        this.f562662a = r100;
        this.f562663b = r101;
        this.f562664c = r102;
        this.f562665d = r103;
        Lazy r104 = LazyKt.lazy(new o(this));
        this.f562666e = r104;
        this.f562678q = new LinkedHashMap();
        int r105 = 0;
        this.f562680s = new c(r105);
        this.f562681t = new c(r105);
        da9.e r106 = new da9.e(0);
        this.f562682u = r106;
        this.f562683v = r106.f467728b;
        this.f562684w = new Object();
        this.f562685x = new AtomicBoolean(false);
        this.f562686y = LazyKt.lazy(new p());
        this.f562687z = LazyKt.lazy(new q(this));
        this.A = new r(this);
        this.B = new w(this);
        this.C = new s(this);
        this.D = new f2a.d("ScreenShare", "AVKit");
        if (G.compareAndSet(false, true) == false) goto L6;
        ca9.c r107 = ca9.b.f22972a;
        ca9.b.f22972a = new y68.d();
    L6:
        if (H.compareAndSet(false, true) == false) goto L8;
        fe9.j r108 = fe9.i.f476629a;
        fe9.i.f476629a = new y68.g();
    L8:
        ((ba9.a) r104.getValue()).c(new t(this));
        ((ba9.a) r104.getValue()).a(new x68.b(this));
    }

    public final void d(y r210, String r211, tf9.b r212, boolean r213) {
        tf9.b r100 = r212;
        Object r101 = this.f562684w;
        monitor-enter(r101);
        if (r213 == false) goto L11;
        long r102 = SystemClock.elapsedRealtimeNanos() / 1000;     // Catch: Throwable -> L76
        long r110 = this.f562673l;     // Catch: Throwable -> L76
        if (r102 > r110) goto L10;
        r102 = r110 + 1;     // Catch: Throwable -> L76
    L10:
        r100 = tf9.b.a(r100, r102, 63);     // Catch: Throwable -> L76
    L19:
        tf9.b r103 = r100;
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L76
        r210.p(r103);     // Catch: Throwable -> L23 Exception -> L26
        long r112 = (SystemClock.elapsedRealtimeNanos() - r111) / 1000;     // Catch: Throwable -> L76
        e = null;
    L28:
        boolean r113 = true;
        if (e != null) goto L34;
        if (r213 == false) goto L32;
        long r114 = SystemClock.elapsedRealtime() - this.f562672k;     // Catch: Throwable -> L76
    L33:
        z68.c r115 = z68.c.f570543a;     // Catch: Throwable -> L76
        int r116 = r103.f545780d;     // Catch: Throwable -> L76
        int r117 = r103.f545781e;     // Catch: Throwable -> L76
        int r118 = RangesKt.coerceAtLeast(this.f562683v, 1);     // Catch: Throwable -> L76
        r115.getClass();     // Catch: Throwable -> L76
        z68.c.d(r211, r116, r117, r118, r213);     // Catch: Throwable -> L76
        this.f562672k = SystemClock.elapsedRealtime();     // Catch: Throwable -> L76
        this.f562673l = r103.f545783g;     // Catch: Throwable -> L76
        this.f562674m = tf9.b.a(r103, 0, 127);     // Catch: Throwable -> L76
        this.f562675n = r211;     // Catch: Throwable -> L76
    L35:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r101);
        c r105 = this.f562680s;
        r105.f562696e++;
        this.f562681t.f562696e++;
        r105.f562698g += r112;
        long r119 = r112;
        r105.f562699h = Math.max(r105.f562699h, r119);
        c r106 = this.f562681t;
        r106.f562698g += r119;
        r106.f562699h = Math.max(r106.f562699h, r119);
        if (e == null) goto L40;
        this.f562680s.f562697f++;
        this.f562681t.f562697f++;
    L44:
        if (r119 < 100000) goto L58;
        long r120 = SystemClock.elapsedRealtime();
        Long r107 = (Long) ((LinkedHashMap) this.f562678q).get("slow_downstream_push");
        if (r107 == null) goto L48;
        long r121 = r107.longValue();
    L50:
        if (r121 != 0) goto L52;
    L54:
        this.f562678q.put("slow_downstream_push", Long.valueOf(r120));
        boolean r108 = true;
    L55:
        if (r108 == false) goto L58;
        Map r109 = MapsKt.mapOf(new Pair[]{TuplesKt.to("pushDurationUs", Long.valueOf(r119)), TuplesKt.to("isRepeatedFrame", Boolean.valueOf(r213))});
        f2a.c r122 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r122.f475230c.f475256d = "AVKitScreenManager";
        r122.f475230c.f475254b = CollectionsKt.listOf(r211);
        r122.f(new v("slow_downstream_push", r109));
        f2a.c.c(r122, null, 15);
        goto L58
    L52:
        if ((r120 - r121) >= 30000) goto L54;
        r108 = false;
        goto L55
    L48:
        r121 = 0;
    L58:
        if (e != null) goto L75;
        if (r213 == false) goto L73;
        long r123 = SystemClock.elapsedRealtime();
        Long r124 = (Long) ((LinkedHashMap) this.f562678q).get("repeated_frame_push");
        if (r124 == null) goto L63;
        long r125 = r124.longValue();
    L65:
        if (r125 != 0) goto L67;
    L69:
        this.f562678q.put("repeated_frame_push", Long.valueOf(r123));
    L70:
        if (r113 == false) goto L73;
        Map r126 = MapsKt.mapOf(TuplesKt.to("sinceLastPushMs", Long.valueOf(r114)));
        f2a.c r127 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r127.f475230c.f475256d = "AVKitScreenManager";
        r127.f475230c.f475254b = CollectionsKt.listOf(r211);
        r127.f(new v("repeated_frame_push", r126));
        f2a.c.c(r127, null, 15);
        goto L73
    L67:
        if ((r123 - r125) >= 30000) goto L69;
        r113 = false;
        goto L70
    L63:
        r125 = 0;
    L73:
        h();
        return;
    L75:
        throw e;
    L40:
        if (r213 == false) goto L42;
        this.f562680s.f562695d++;
        this.f562681t.f562695d++;
        goto L44
    L42:
        this.f562680s.f562694c++;
        this.f562681t.f562694c++;
        goto L44
    L32:
        r114 = 0;
        goto L33
    L34:
        r112 = r112;
        r114 = 0;
        goto L35
    L26:
        e = e;
        r112 = (SystemClock.elapsedRealtimeNanos() - r111) / 1000;     // Catch: Throwable -> L76
    L23:
        th = move-exception;
        long r128 = (SystemClock.elapsedRealtimeNanos() - r111) / 1000;     // Catch: Throwable -> L76
        throw th;     // Catch: Throwable -> L76
    L11:
        long r129 = r100.f545783g;     // Catch: Throwable -> L76
        long r130 = this.f562673l;     // Catch: Throwable -> L76
        if (r129 <= r130) goto L14;
        long r131 = r129;
    L16:
        if (r131 == r129) goto L19;
        r100 = tf9.b.a(r100, r131, 191);     // Catch: Throwable -> L76
        goto L19
    L14:
        r131 = r130 + 1;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        throw th;
    }
}
