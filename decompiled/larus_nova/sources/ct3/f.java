package ct3;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.internal.g;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f465339f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f465340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f465341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, ms3.b> f465342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f465343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465344e;

    public final boolean c() {
        return "start_trace".equals(this.f465343d);
    }

    public f(String r100, String r101) {
        this.f465342c = new ConcurrentHashMap(4);
        if ("start_trace".equals(r100) == false) goto L5;
    L9:
        this.f465343d = r100;
        this.f465344e = r101;
        return;
    L5:
        if ("page_load_trace".equals(r100) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    public final void a(String r100, String r101) {
        ms3.b r102 = this.f465342c.get(r100 + "#" + r101);
        if (r102 != null) goto L5;
        return;
    L5:
        long r103 = System.currentTimeMillis();
        String r104 = ThreadMethodProxy.currentThread().getName();
        r102.f515477b = r103;
        r102.f515478c = r104;
        this.f465342c.put(r100 + "#" + r101, r102);
    }

    public final void d(String r100, String r101) {
        if (this.f465342c.get(r100 + "#" + r101) != null) goto L7;
        ms3.b r102 = new ms3.b(System.currentTimeMillis());
        this.f465342c.put(r100 + "#" + r101, r102);
        return;
    }

    public final void b(int r110, String r111, long r112) {
        if (r110 == (-1)) goto L5;
    L9:
        long r100 = System.currentTimeMillis();
        this.f465341b = r100;
        long r101 = r100 - this.f465340a;
        if (r112 <= 0) goto L15;
        if (r101 <= r112) goto L15;
        return;
    L15:
        if (c() == true) goto L17;
    L82:
        ns3.e.b r102 = null;
    L84:
        if (c() == false) goto L93;
        if (a47.a.f1770l == false) goto L93;
        if (f465339f == false) goto L93;
        f465339f = false;
        long r103 = this.f465340a;
        long r104 = this.f465341b;
        long[] r105 = MethodCollector.getInstance().copyAllData();
        long r106 = SystemClock.uptimeMillis();
        if (r105 == null) goto L93;
        bt3.b.d.f20539a.e(new e(r105, r106, r104, r103, r110));
    L93:
        if (c() == false) goto L105;
        ns3.a r107 = ns3.a.C6968a.f520287a;
        monitor-enter(r107);
    L102:
        th = move-exception;
        throw th;
    L97:
        if (r107.f520286b != null) goto L99;
        r107.f520286b = new a.C5583a(new a.C5583a.C5584a());     // Catch: Throwable -> L102
    L99:
        a.C5583a r108 = r107.f520286b;     // Catch: Throwable -> L102
        monitor-exit(r107);
        r108.getClass();
    L105:
        bt3.b.d.f20539a.e(new d(this, r102, r110, r111));
        if (c() == false) goto L150;
        ExecutorService r109 = LaunchSleepDetector.f190615a;
        return;
    L150:
        return;
    L17:
        if (ns3.b.f520288a == true) goto L82;
        boolean r113 = true;
        ns3.b.f520288a = true;
        if (ns3.a.C6968a.f520287a.a().f520289a == false) goto L82;
        if ((g.f190601c & 4) == 0) goto L25;
        boolean r114 = true;
    L26:
        if (r114 == false) goto L82;
        ns3.e.b r115 = new ns3.e.b();
        int r116 = Process.myPid();     // Catch: Throwable -> L76
        BufferedReader r117 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r116 + "/task/" + r116 + "/sched"), 100);     // Catch: Throwable -> L54
    L125:
        String r118 = r117.readLine();     // Catch: Throwable -> L53
        if (r118 != null) goto L35;
    L113:
        BufferedReader r119 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r116 + "/task/" + r116 + "/stat"), 100);     // Catch: Throwable -> L110
        String[] r120 = r119.readLine().split(" ");     // Catch: Throwable -> L59
        r115.f520311l = Long.parseLong(r120[9]);     // Catch: Throwable -> L59
        r115.f520312m = Long.parseLong(r120[11]);     // Catch: Throwable -> L59
    L123:
        if (Build.VERSION.SDK_INT < 23) goto L127;
        r115.f520300a = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));     // Catch: Throwable -> L109
        r115.f520301b = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));     // Catch: Throwable -> L109
        r115.f520302c = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));     // Catch: Throwable -> L109
        r115.f520303d = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));     // Catch: Throwable -> L109
    L127:
        ns3.e.b(r115);     // Catch: Throwable -> L71
        if ((g.f190601c & 128) != 0) goto L68;
        r113 = false;
    L68:
        if (r113 == false) goto L72;
        ns3.e.a(r115, r116, g.f190604f, r101);     // Catch: Throwable -> L71
    L72:
        if (r119 != null) goto L115;
    L79:
        r102 = r115;
        goto L84
    L115:
        r119.close();     // Catch: Throwable -> L75
    L59:
        r117 = r119;
    L60:
        r119 = r117;
        goto L123
    L35:
        if (r118.contains("se.statistics.iowait_sum") == true) goto L36;
        if (r118.contains("se.statistics.wait_sum") == true) goto L39;
        if (r118.contains("se.statistics.sum_sleep_runtime") == true) goto L42;
        if (r118.contains("nr_voluntary_switches") == true) goto L45;
        if (r118.contains("nr_involuntary_switches") == true) goto L48;
        if (r118.contains("se.sum_exec_runtime") == false) goto L125;
        r115.f520304e = Double.parseDouble(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L48:
        r115.f520306g = Long.parseLong(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L45:
        r115.f520305f = Long.parseLong(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L42:
        r115.f520309j = Double.parseDouble(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L39:
        r115.f520308i = Double.parseDouble(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L36:
        r115.f520307h = Double.parseDouble(r118.substring(r118.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
    L53:
        BufferedReader r121 = r117;
    L55:
        r117 = r121;
    L54:
        r121 = null;
    L76:
        th = move-exception;
        ns3.a r122 = ns3.a.C6968a.f520287a;     // Catch: Throwable -> L80
        ns3.a r123 = ns3.a.C6968a.f520287a;     // Catch: Throwable -> L80
        th.getLocalizedMessage();     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    L25:
        r114 = false;
        goto L26
    L5:
        if (com.bytedance.apm.d.j() == false) goto L9;
        throw new IllegalArgumentException("Launch mode is both none");
    }
}
