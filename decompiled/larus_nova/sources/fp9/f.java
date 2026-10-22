package fp9;

import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.os.SystemClock;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.perfdegrade.api.model.PerfDegradeScrollEvent;
import com.larus.perfdegrade.api.model.PerfDegradeType;
import com.larus.settings.value.dx;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f478305n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ep9.a f478306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PerfDegradeType f478307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f478308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f478309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f478310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f478311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f478312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f478313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile rv9.a f478314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f478315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f478316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f478317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f478318m;

    public static final class a {
    }

    static {
        f478305n = bp9.a.a("DiskOccupancyDegrader");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [fp9.e] */
    public f() {
        ep9.a r100 = ep9.a.f473438a;
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f478306a = r100;
        this.f478307b = PerfDegradeType.DISK_OCCUPANCY;
        this.f478308c = LazyKt.lazy(new c());
        this.f478309d = LazyKt.lazy(new d());
        this.f478310e = new Object();
        this.f478317l = new e(this);
        this.f478318m = new g(this);
    }

    public static long g() {
        long r100 = AppHost.f326268a.getAppStartTime().getFirst().longValue();
        return RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r100, 0);
    }

    public final void e() {
        ((Handler) this.f478308c.getValue()).removeCallbacks(this.f478317l);
        Object r100 = this.f478310e;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f478315j == false) goto L7;
        AppHost.f326268a.a().c(this.f478318m);     // Catch: Throwable -> L10
        this.f478315j = false;     // Catch: Throwable -> L10
    L7:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
    }

    public final void f() {
        Object r100 = this.f478310e;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f478315j == true) goto L7;
        AppHost.f326268a.a().j(this.f478318m);     // Catch: Throwable -> L10
        this.f478315j = true;     // Catch: Throwable -> L10
    L7:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
    }

    public final void j() {
        FLogger.f375446a.i(f478305n, "reset disk occupancy schedule state");
        Object r100 = this.f478310e;
        monitor-enter(r100);
        this.f478311f = false;     // Catch: Throwable -> L9
        this.f478312g = false;     // Catch: Throwable -> L9
        this.f478313h = false;     // Catch: Throwable -> L9
        this.f478314i = null;     // Catch: Throwable -> L9
        this.f478316k = System.nanoTime();     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        e();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // fp9.h
    public PerfDegradeType getType() {
        return this.f478307b;
    }

    public static String l(rv9.a r100) {
        return "enable=" + r100.a() + ",occupySizeMb=" + r100.c() + ",delayMs=" + r100.d() + ",minFreeSpaceMb=" + r100.b();
    }

    @Override // fp9.h
    public final cp9.b a(cp9.a r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        this.f478306a.getClass();
        e10 r100 = e10.f368561a;
        rv9.a r101 = (rv9.a) l0.a(new rv9.a(0), new dx());
        r110.getClass();
        Map<String, String> r102 = MapsKt.emptyMap();
        if (r102.isEmpty() == true) goto L64;
        String r103 = r102.get("enable");
        if (r103 == null) goto L10;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L10;
        String r105 = r104.toLowerCase(Locale.ROOT);
    L11:
        if (r105 != null) goto L13;
    L47:
        Boolean r106 = null;
    L48:
        if (r106 == null) goto L50;
        boolean r107 = r106.booleanValue();
    L51:
        boolean r108 = r107;
        Long r109 = h(r102, "occupy_size_mb");
        if (r109 == null) goto L54;
        long r111 = r109.longValue();
    L55:
        long r112 = r111;
        Long r113 = h(r102, "trigger_delay_ms");
        if (r113 == null) goto L58;
        long r114 = r113.longValue();
    L59:
        long r115 = r114;
        Long r116 = h(r102, "min_free_space_mb");
        if (r116 == null) goto L62;
        long r117 = r116.longValue();
    L63:
        r101.getClass();
        r101 = new rv9.a(r108, r112, r115, r117);
        goto L64
    L62:
        r117 = r101.b();
        goto L63
    L58:
        r114 = r101.d();
        goto L59
    L54:
        r111 = r101.c();
        goto L55
    L50:
        r107 = r101.a();
        goto L51
    L13:
        switch(r105.hashCode()) {
            case 48: goto L44;
            case 49: goto L40;
            case 110: goto L37;
            case 121: goto L34;
            case 3521: goto L31;
            case 3551: goto L28;
            case 109935: goto L25;
            case 119527: goto L22;
            case 3569038: goto L19;
            case 97196323: goto L16;
            default: goto L47;
        };
    L16:
        if (r105.equals("false") == false) goto L47;
    L46:
        r106 = Boolean.FALSE;
        goto L48
    L19:
        if (r105.equals("true") == false) goto L47;
    L42:
        r106 = Boolean.TRUE;
        goto L48
    L22:
        if (r105.equals(BdpAppEventConstant.YES) == true) goto L42;
    L25:
        if (r105.equals("off") == true) goto L46;
    L28:
        if (r105.equals("on") == false) goto L47;
    L31:
        if (r105.equals(BdpAppEventConstant.NO) == true) goto L46;
    L34:
        if (r105.equals("y") == true) goto L42;
    L37:
        if (r105.equals(OfficeSDKRequestTag.KEY_NEW_USER) == true) goto L46;
    L40:
        if (r105.equals("1") == true) goto L42;
    L44:
        if (r105.equals("0") == true) goto L46;
    L10:
        r105 = null;
    L64:
        r110.getClass();
        FLogger r118 = FLogger.f375446a;
        String r119 = f478305n;
        StringBuilder r120 = new StringBuilder("receive disk occupancy degrade request, scene=");
        r120.append(r110.f464727b);
        r120.append(", forceTrigger=");
        r120.append(false);
        r120.append(", hasDebugOverrides=");
        r120.append(!true);
        r120.append(", config=");
        r120.append(l(r101));
        r118.i(r119, r120.toString());
        if (r101.a() == true) goto L72;
        j();
        if (aa9.a.f2357a.c("perf_degrade", false).exists() == true) goto L69;
        r118.i(r119, "skip disk occupancy cleanup, mock dir not exist");
        return new cp9.b(false, "disk occupancy disabled");
    L69:
        ((ExecutorService) this.f478309d.getValue()).execute(new fp9.a(this));
        return new cp9.b(true, "disk occupancy cleanup scheduled");
    L72:
        if (r101.d() >= 0) goto L75;
        String r121 = "invalid trigger delay";
    L87:
        if (r121 == null) goto L90;
        r118.w(r119, "skip disk occupancy degrade, scene=" + r110.f464727b + ", reason=" + r121 + ", forceTrigger=false, config=" + l(r101));
        return new cp9.b(false, r121);
    L90:
        Object r122 = this.f478310e;
        monitor-enter(r122);
    L111:
        th = move-exception;
        throw th;
    L93:
        if (this.f478311f == true) goto L95;
        long r123 = g();     // Catch: Throwable -> L111
        long r124 = RangesKt.coerceAtLeast(r101.d() - r123, 0);     // Catch: Throwable -> L111
        this.f478311f = true;     // Catch: Throwable -> L111
        boolean r125 = false;
        this.f478312g = false;     // Catch: Throwable -> L111
        if (r124 > 0) goto L104;
        r125 = true;
    L104:
        this.f478313h = r125;     // Catch: Throwable -> L111
        this.f478314i = r101;     // Catch: Throwable -> L111
        this.f478316k = System.nanoTime();     // Catch: Throwable -> L111
        r118.i(r119, "init disk occupancy schedule state, scene=" + r110.f464727b + ", elapsedSinceAppStartMs=" + r123 + ", remainingDelayMs=" + r124 + ", appStartElapsedRealtime=" + AppHost.f326268a.getAppStartTime().getFirst().longValue() + ", scheduleToken=" + this.f478316k);     // Catch: Throwable -> L111
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L111
        monitor-exit(r122);
        if (this.f478313h == true) goto L109;
        ((Handler) this.f478308c.getValue()).postDelayed(this.f478317l, RangesKt.coerceAtLeast(r101.d() - g(), 0));
    L109:
        f();
        r118.i(r119, "schedule disk occupancy degrade, scene=" + r110.f464727b + ", forceTrigger=false, elapsedSinceAppStartMs=" + g() + ", remainingDelayMs=" + RangesKt.coerceAtLeast(r101.d() - g(), 0) + ", config=" + l(r101) + ", debugOverrides=null");
        d("trigger_request");
        return new cp9.b(true, "disk occupancy degrade scheduled");
    L95:
        if (this.f478312g == false) goto L97;
        String r127 = "disk occupancy degrade already executed";
    L98:
        r118.i(r119, "ignore duplicate disk occupancy request, scene=" + r110.f464727b + ", reason=" + r127 + ", config=" + l(r101));     // Catch: Throwable -> L111
        cp9.b r128 = new cp9.b(false, r127);     // Catch: Throwable -> L111
        monitor-exit(r122);
        return r128;
    L97:
        r127 = "disk occupancy degrade already scheduled";
        goto L98
    L75:
        if (r101.c() > 0) goto L78;
        r121 = "invalid occupy size";
        goto L87
    L78:
        if (r101.b() >= 0) goto L81;
        r121 = "invalid min free space";
        goto L87
    L81:
        if (r101.c() <= 8796093022207L) goto L84;
        r121 = "occupy size is too large";
        goto L87
    L84:
        if (r101.b() <= 8796093022207L) goto L86;
        r121 = "min free space is too large";
        goto L87
    L86:
        r121 = null;
        goto L87
    }

    @Override // fp9.h
    public final void b(PerfDegradeScrollEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // fp9.h
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return false;
    }

    public final void d(final String r100) {
        final rv9.a r101 = this.f478314i;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f478313h == true) goto L10;
        FLogger.f375446a.d(f478305n, "wait disk occupancy delay, source=".concat(r100));
        return;
    L10:
        if (AppHost.f326268a.a().isAppBackground() == true) goto L13;
        FLogger.f375446a.d(f478305n, "wait app background for disk occupancy degrade, source=".concat(r100));
        f();
        return;
    L13:
        Object r102 = this.f478310e;
        monitor-enter(r102);
    L31:
        th = move-exception;
        throw th;
    L16:
        if (this.f478312g == false) goto L18;
    L26:
        Long r103 = null;
    L27:
        monitor-exit(r102);
        if (r103 == null) goto L36;
        final long r104 = r103.longValue();
        e();
        ((ExecutorService) this.f478309d.getValue()).execute(new b(this, r104, r101, r100));
        return;
    L36:
        return;
    L18:
        if (this.f478314i == null) goto L26;
        if (Intrinsics.areEqual(this.f478314i, r101) == false) goto L26;
        if (this.f478313h == false) goto L26;
        this.f478312g = true;     // Catch: Throwable -> L31
        r103 = Long.valueOf(this.f478316k);     // Catch: Throwable -> L31
        goto L27
    }

    public static void k(rv9.a r210, String r211) {
        long r100 = System.currentTimeMillis();
        aa9.a.C0042a r101 = aa9.a.f2357a;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.c("perf_degrade", true), "mock_disk_occupancy.bin");
        if (r102.exists() == false) goto L5;
        PolarisFileWrapper r103 = r102;
    L7:
        if (r103 == null) goto L9;
        long r104 = r103.length();
    L10:
        int r105 = com.larus.utils.k.f375427a;
        StatFs r110 = new StatFs(Environment.getDataDirectory().getPath());
        long r111 = r110.getBlockSizeLong() * r110.getAvailableBlocksLong();
        long r112 = r210.b() * 1048576;
        long r106 = r210.c() * 1048576;
        long r107 = Math.min(r106, RangesKt.coerceAtLeast(r111 - r112, 0));
        FLogger r113 = FLogger.f375446a;
        String r108 = f478305n;
        r113.i(r108, "execute disk occupancy degrade, source=" + r211 + ", availableBytes=" + r111 + ", currentFileBytes=" + r104 + ", targetBytes=" + r106 + ", actualTargetBytes=" + r107 + ", minFreeSpaceBytes=" + r112);
        if (r107 > 0) goto L21;
        PolarisFileWrapper r109 = r101.c("perf_degrade", false);     // Catch: Throwable -> L16
        if (r109.exists() == false) goto L18;
        com.larus.utils.r.f(r109);     // Catch: Throwable -> L16
    L18:
        r113.w(r108, "skip disk occupancy degrade, no safe writable bytes");
        return;
    L16:
        th = move-exception;
        FLogger.f375446a.e(f478305n, "cleanup disk occupancy mock files failed", th);
        goto L18
    L21:
        if (r104 != r107) goto L24;
        r113.i(r108, "disk occupancy file already matches target size=" + r107);
        PolarisFileWrapper r114 = r102;
    L41:
        long r115 = r114.length();
        FLogger.f375446a.i(f478305n, "finish disk occupancy degrade, finalSize=" + r115 + ", costMs=" + (System.currentTimeMillis() - r100));
        return;
    L24:
        if (r104 <= r107) goto L34;
        r114 = r102;
        RandomAccessFile r116 = new RandomAccessFile(r114, "rw");
        r116.setLength(r107);     // Catch: Throwable -> L28
        r116.getFD().sync();     // Catch: Throwable -> L28
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r116, null);
        r113.i(r108, "shrink disk occupancy file from=" + r104 + " to=" + r107);
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);
        throw th;
    L34:
        r114 = r102;
        byte[] r118 = new byte[1048576];
        RandomAccessFile r119 = new RandomAccessFile(r114, "rw");
        r119.seek(r104);     // Catch: Throwable -> L43
        long r120 = r107 - r104;     // Catch: Throwable -> L43
    L37:
        if (r120 <= 0) goto L39;
        int r121 = (int) Math.min(1048576, r120);     // Catch: Throwable -> L43
        r119.write(r118, 0, r121);     // Catch: Throwable -> L43
        r120 = r120 - ((long) r121);     // Catch: Throwable -> L43
        goto L37
    L39:
        r119.getFD().sync();     // Catch: Throwable -> L43
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r119, null);
        FLogger.f375446a.i(f478305n, "expand disk occupancy file from=" + r104 + " to=" + r107);
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r119, th);
        throw th;
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public final Long h(Map<String, String> r100, String r101) {
        String r102 = r100.get(r101);
        if (r102 == null) goto L7;
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L7;
        return StringsKt.toLongOrNull(r103);
    L7:
        return null;
    }

    public final void i(long r100, rv9.a r101, String r102, Throwable r103) {
        Object r104 = this.f478310e;
        monitor-enter(r104);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f478314i, r101) == false) goto L10;
        if (this.f478316k != r100) goto L10;
        boolean r105 = true;
    L11:
        monitor-exit(r104);
        FLogger.f375446a.e(f478305n, "disk occupancy degrade failed, source=" + r102 + ", scheduleToken=" + r100, r103);
        if (r105 == false) goto L21;
        j();
        return;
    L21:
        return;
    L10:
        r105 = false;
        goto L11
    }
}
