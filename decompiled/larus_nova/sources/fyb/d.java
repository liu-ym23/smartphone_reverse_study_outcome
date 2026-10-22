package fyb;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.config.OPMonitorHeartBeatConfig;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d f479333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f479334i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OPMonitorHeartBeatConfig f479335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OPMonitorCode f479336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f479337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f479338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledExecutorService f479339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, OPMonitorHeartBeatMonitorData> f479340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, byb.a> f479341g;

    public final synchronized void b() {
        monitor-enter(this);
        ScheduledExecutorService r100 = this.f479339e;     // Catch: Throwable -> L18
        if (r100 != null) goto L6;
    L15:
        Log.i("OPMonitorHeartBeatManager", "reStartTimer fail, last timer not shutdown");     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L6:
        if (r100.isShutdown() == false) goto L15;
        OPMonitorHeartBeatConfig r101 = this.f479335a;     // Catch: Throwable -> L18
        if (r101.f437594a > 0) goto L10;
        r101.f437594a = 30;     // Catch: Throwable -> L18
    L10:
        int r102 = r101.f437594a;     // Catch: Throwable -> L18
        ScheduledExecutorService r103 = PThreadExecutorsUtils.newScheduledThreadPool(1, this.f479338d);     // Catch: Throwable -> L18
        this.f479339e = r103;     // Catch: Throwable -> L18
        long r104 = r102;
        r103.scheduleWithFixedDelay(this.f479337c, r104, r104, TimeUnit.SECONDS);     // Catch: RejectedExecutionException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "scheduleWithFixedDelay is exception", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static d a() {
        if (f479333h != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f479333h != null) goto L9;
        f479333h = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f479333h;
    }

    public d() {
        this.f479340f = new ConcurrentHashMap();
        this.f479341g = new ConcurrentHashMap();
        if (f479334i == true) goto L40;
        f479334i = true;
        OPMonitorHeartBeatConfig r100 = new OPMonitorHeartBeatConfig();
        this.f479335a = r100;
        int r101 = iyb.a.f496623a;
        Intrinsics.checkNotNullParameter("ecosystem.monitor.heartbeat.enable", "fgKey");
        r100.f437595b = false;
        Intrinsics.checkNotNullParameter("opmonitor_heartbeat_conifg", "configKey");     // Catch: Exception -> L8
        JSONObject r102 = new JSONObject("");     // Catch: Exception -> L8
        this.f479335a.f437596c = JSONObjectProtectorUtils.getInt(r102, "maxReportCount");     // Catch: Exception -> L8
        this.f479335a.f437594a = JSONObjectProtectorUtils.getInt(r102, "heartBeatInterval");     // Catch: Exception -> L8
    L11:
        if (this.f479335a.f437595b == true) goto L14;
        this.f479340f.clear();
        this.f479341g.clear();
        return;
    L14:
        if (e.f479342b.f479343a == null) goto L16;
        this.f479336b = null;
    L17:
        this.f479337c = new b(this);
        this.f479338d = new c();
        monitor-enter(this);
        Log.i("OPMonitorHeartBeatManager", "startTimer");     // Catch: Throwable -> L30
        OPMonitorHeartBeatConfig r103 = this.f479335a;     // Catch: Throwable -> L30
        if (r103.f437594a > 0) goto L22;
        r103.f437594a = 30;     // Catch: Throwable -> L30
    L22:
        int r104 = r103.f437594a;     // Catch: Throwable -> L30
        ScheduledExecutorService r105 = PThreadExecutorsUtils.newScheduledThreadPool(1, this.f479338d);     // Catch: Throwable -> L30
        this.f479339e = r105;     // Catch: Throwable -> L30
        long r106 = r104;
        r105.scheduleWithFixedDelay(this.f479337c, r106, r106, TimeUnit.SECONDS);     // Catch: RejectedExecutionException -> L25 Throwable -> L30
    L27:
        monitor-exit(this);
        Log.i("OPMonitorHeartBeatManager", "OPMonitorHeartBeatManager is done config" + this.f479335a);
        Log.i("OPMonitorHeartBeatManager", "OPMonitorHeartBeatManager is done batchMonitorCode:" + this.f479336b);
        return;
    L25:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "scheduleWithFixedDelay is exception", e);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L16:
        this.f479336b = new OPMonitorCode("monitor.base.heartbeat", 10000, OPMonitorLevel.NORMAL, "heartbeat_report");
    L8:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "heartbeat settings parse is exception", e);
        goto L11
    }
}
