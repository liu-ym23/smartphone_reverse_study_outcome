package vn2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ig0;
import com.bytedance.android.livesdk.config.s31;
import com.bytedance.common.jato.gc.GCListener;
import com.bytedance.common.jato.gc.GCMonitor;
import com.bytedance.monitor.collector.MonitorJni;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f556416k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f556417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f556418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f556419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f556420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f556421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Long> f556422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f556423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f556424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s31 f556425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f556426j;

    /* JADX INFO: renamed from: vn2.a$a, reason: collision with other inner class name */
    public static final class C8023a {
    }

    public static final class b extends GCListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f556427a;

        public b(a r100) {
            this.f556427a = r100;
        }

        @Override // com.bytedance.common.jato.gc.GCListener
        public final void onGCStart(int r100, int r101, int r102) {
            if (a.f556416k == false) goto L6;
            ALogger.d("LiveGcMonitorImpl", "onGCStart, tid = " + r100 + ", type = " + r101 + ", cause = " + r102);
            return;
        }

        @Override // com.bytedance.common.jato.gc.GCListener
        public final void onWaitGc(int r100, int r101, int r102) {
            if (a.f556416k == false) goto L5;
            ALogger.d("LiveGcMonitorImpl", "onWaitGc, waitTid = " + r100 + ", gcTid = " + r101 + ", cause = " + r102);
        L5:
            a r103 = this.f556427a;
            monitor-enter(r103);
            this.f556427a.f556421e = System.currentTimeMillis();     // Catch: Throwable -> L10
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r103);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.jato.gc.GCListener
        public final void onGCEnd(int r110, int r111, int r210, long r211, boolean r212, long r213, long r214, long r215, long r310, long r311) {
            if (a.f556416k == false) goto L5;
            ALogger.d("LiveGcMonitorImpl", "onGCEnd, tid = " + r110 + ", type = " + r111 + ", cause = " + r210 + ", duration = " + r211 + ", isClearSoftRefs = " + r212 + ", freedBytes = " + r213 + ", freedObjects = " + r214 + ", freedLosBytes = " + r215 + ", freedLosObjects = " + r310 + ", pauseTime = " + r311);
        L5:
            a r100 = this.f556427a;
            monitor-enter(r100);
            c r101 = this.f556427a.f556419c;     // Catch: Throwable -> L33
            if (r101 != null) goto L11;
            monitor-exit(r100);
            return;
        L11:
            long r112 = 1000000;
            long r102 = r211 / r112;     // Catch: Throwable -> L33
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L33
            r101.f556431c++;     // Catch: Throwable -> L33
            if (r102 <= 0) goto L16;
            r101.f556432d += r102;     // Catch: Throwable -> L33
        L16:
            if (r213 <= 0) goto L18;
            r101.f556439k += r213 / ((long) 1024);     // Catch: Throwable -> L33
            long r103 = 0;
        L20:
            if (r311 <= r103) goto L23;
            r101.f556433e += r311 / r112;     // Catch: Throwable -> L33
        L23:
            if (r210 != 1) goto L28;
            r101.f556434f++;     // Catch: Throwable -> L33
            if (r102 <= 0) goto L28;
            r101.f556435g += r102;     // Catch: Throwable -> L33
        L28:
            if (this.f556427a.f556421e <= 0) goto L30;
            long r104 = System.currentTimeMillis();     // Catch: Throwable -> L33
            a r105 = this.f556427a;     // Catch: Throwable -> L33
            r101.f556429a += r104 - r105.f556421e;     // Catch: Throwable -> L33
            r105.f556421e = 0;     // Catch: Throwable -> L33
        L30:
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L33
            monitor-exit(r100);
            return;
        L18:
            r103 = 0;
        L33:
            th = move-exception;
            throw th;
        }
    }

    @Override // vn2.f
    public final void c() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f556417a == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        boolean r100 = true;
        this.f556417a = true;     // Catch: Throwable -> L20
        e();     // Catch: Throwable -> L20
        this.f556423g = System.currentTimeMillis();     // Catch: Throwable -> L20
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        if ((this.f556425i.b() & 1) != 0) goto L14;
        r100 = false;
    L14:
        if (r100 == true) goto L17;
        GCMonitor.getInstance().addListener(this.f556426j, this.f556425i.k());
    L17:
        if (f556416k == false) goto L25;
        ALogger.d("LiveGcMonitorImpl", "startMonitor, cur gcInfo = " + this.f556418b);
        return;
    }

    static {
        f556416k = ig0.f120451a.getValue().f();
    }

    @Override // vn2.f
    public final void a() {
        boolean r100 = true;
        if ((this.f556425i.b() & 1) != 0) goto L6;
        r100 = false;
    L6:
        if (r100 == true) goto L9;
        GCMonitor.getInstance().removeListener(this.f556426j, this.f556425i.k());
    L9:
        if (f556416k == false) goto L11;
        ALogger.d("LiveGcMonitorImpl", "stopMonitor");
    L11:
        monitor-enter(this);
        e();     // Catch: Throwable -> L15
        this.f556417a = false;     // Catch: Throwable -> L15
        this.f556420d = 0;     // Catch: Throwable -> L15
        this.f556423g = -1;     // Catch: Throwable -> L15
        this.f556424h = false;     // Catch: Throwable -> L15
        this.f556422f.clear();     // Catch: Throwable -> L15
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // vn2.f
    public final synchronized d b() {
        monitor-enter(this);
        d r100 = null;
        if (this.f556417a == false) goto L64;
        c r101 = this.f556418b;     // Catch: Throwable -> L67
        if (r101 == null) goto L64;
        long r102 = r101.f556440l;     // Catch: Throwable -> L67
        boolean r103 = false;
        if (r102 <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 != true) goto L64;
        c r105 = this.f556419c;     // Catch: Throwable -> L67
        if (r105 == null) goto L64;
        if (r105.f556440l <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 != true) goto L64;
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L67
        int r107 = this.f556420d + 1;     // Catch: Throwable -> L67
        this.f556420d = r107;     // Catch: Throwable -> L67
        r105.f556430b = r107;     // Catch: Throwable -> L67
        r105.f556440l = System.currentTimeMillis();     // Catch: Throwable -> L67
        if ((this.f556425i.b() & 2) == 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L27;
        long r109 = 0;
    L29:
        if ((this.f556425i.b() & 2) == 0) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == false) goto L34;
        long r111 = 0;
    L36:
        if (r109 <= 0) goto L39;
        r105.f556436h = r109;     // Catch: Throwable -> L67
    L39:
        if (r111 <= 0) goto L42;
        r105.f556437i = r111;     // Catch: Throwable -> L67
    L42:
        if ((this.f556425i.b() & 2) == 0) goto L44;
        boolean r112 = true;
    L45:
        if (r112 == false) goto L47;
        long r113 = 0;
    L49:
        if (r113 <= 0) goto L51;
        r105.f556438j = r113;     // Catch: Throwable -> L67
    L51:
        c r114 = this.f556418b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L67
        d r115 = r105.a(r114);     // Catch: Throwable -> L67
        float r116 = 0;
        if (r115.f556442b >= r116) goto L54;
    L56:
        if (r103 == false) goto L59;
        r100 = r115;
    L59:
        if (f556416k == false) goto L61;
        ALogger.d("LiveGcMonitorImpl", "computeGcInfo, diff gcInfo = " + r100);     // Catch: Throwable -> L67
    L61:
        e();     // Catch: Throwable -> L67
        monitor-exit(this);
        return r100;
    L54:
        if (r115.f556443c <= r116) goto L56;
        r103 = true;
        goto L56
    L47:
        r113 = MonitorJni.getBytesAllocatedEver() / ((long) 1204);     // Catch: Throwable -> L67
        goto L49
    L44:
        r112 = false;
        goto L45
    L34:
        r111 = MonitorJni.getMajorFaults();     // Catch: Throwable -> L67
        goto L36
    L31:
        r110 = false;
        goto L32
    L27:
        r109 = MonitorJni.getMinorFaults();     // Catch: Throwable -> L67
        goto L29
    L24:
        r108 = false;
        goto L25
    L18:
        r106 = false;
        goto L19
    L11:
        r104 = false;
    L64:
        Objects.toString(this.f556418b);     // Catch: Throwable -> L67
        monitor-exit(this);
        return null;
    L67:
        th = move-exception;
        throw th;
    }

    @Override // vn2.f
    public final Map<String, Long> d() {
        zn2.a.a(this.f556422f);
        if (this.f556423g <= 0) goto L13;
        long r100 = System.currentTimeMillis();
        if (this.f556424h == false) goto L10;
        if ((r100 - this.f556423g) < this.f556425i.a()) goto L13;
        ALogger.i("LiveGcMonitorImpl", "updateDetailMemInfo");
        this.f556423g = System.currentTimeMillis();
        zn2.a.b(this.f556422f);
        goto L13
    L10:
        if ((r100 - this.f556423g) < this.f556425i.j()) goto L13;
        this.f556424h = true;
        ALogger.i("LiveGcMonitorImpl", "updateDetailMemInfo");
        this.f556423g = System.currentTimeMillis();
        zn2.a.b(this.f556422f);
    L13:
        return this.f556422f;
    }

    public final synchronized void e() {
        monitor-enter(this);
        boolean r110 = true;
        if ((this.f556425i.b() & 2) == 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L10;
        long r111 = 0;
    L12:
        if ((this.f556425i.b() & 2) == 0) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == false) goto L17;
        long r210 = 0;
    L19:
        if ((this.f556425i.b() & 2) != 0) goto L22;
        r110 = false;
    L22:
        if (r110 == false) goto L24;
        long r211 = 0;
    L25:
        long r112 = r111;
        long r113 = r210;
        long r114 = r211;
        c r102 = new c(0, 0, 0, 0, 0, 0, r112, r113, r114, 0, System.currentTimeMillis());     // Catch: Throwable -> L33
        this.f556418b = r102;     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L33
        int r103 = r102.f556430b;     // Catch: Throwable -> L33
        long r104 = r102.f556431c;     // Catch: Throwable -> L33
        long r105 = r102.f556432d;     // Catch: Throwable -> L33
        long r106 = r102.f556433e;     // Catch: Throwable -> L33
        long r107 = r102.f556434f;     // Catch: Throwable -> L33
        long r115 = r102.f556435g;     // Catch: Throwable -> L33
        long r116 = r102.f556436h;     // Catch: Throwable -> L33
        long r117 = r102.f556437i;     // Catch: Throwable -> L33
        long r118 = r102.f556438j;     // Catch: Throwable -> L33
        long r119 = r102.f556439k;     // Catch: Throwable -> L33
        this.f556419c = new c(r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r102.f556440l);     // Catch: Throwable -> L33
        this.f556421e = 0;     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L31:
        th = th;
    L34:
        monitor-exit(this);
        throw th;
    L24:
        r211 = MonitorJni.getBytesAllocatedEver() / ((long) 1204);     // Catch: Throwable -> L33
        goto L25
    L17:
        r210 = MonitorJni.getMajorFaults();     // Catch: Throwable -> L33
        goto L19
    L14:
        r101 = false;
        goto L15
    L10:
        r111 = MonitorJni.getMinorFaults();     // Catch: Throwable -> L33
        goto L12
    L7:
        r100 = false;
    L33:
        th = th;
        goto L34
    }

    public a() {
        this.f556422f = new HashMap();
        this.f556423g = -1;
        this.f556425i = ig0.f120451a.getValue();
        this.f556426j = new b(this);
    }

    @Override // vn2.f
    public final s31 getConfig() {
        return this.f556425i;
    }
}
