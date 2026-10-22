package ct3;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.d;
import com.bytedance.apm.internal.g;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import ms3.b;
import ns3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static volatile boolean f = true;
    public long a;
    public long b;
    public final ConcurrentHashMap<String, b> c;
    public final String d;
    public final String e;

    public final boolean c() {
        return "start_trace".equals(this.d);
    }

    public f(String r3, String r4) {
        this.c = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.d = r3;
        this.e = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    public final void a(String r6, String r7) {
        b r0 = this.c.get(r6 + "#" + r7);
        if (r0 != null) goto L5;
        return;
    L5:
        long r3 = System.currentTimeMillis();
        String r1 = ThreadMethodProxy.currentThread().getName();
        r0.b = r3;
        r0.c = r1;
        this.c.put(r6 + "#" + r7, r0);
    }

    public final void d(String r6, String r7) {
        if (this.c.get(r6 + "#" + r7) != null) goto L7;
        b r0 = new b(System.currentTimeMillis());
        this.c.put(r6 + "#" + r7, r0);
        return;
    }

    public final void b(int r17, String r18, long r19) {
        if (r17 == (-1)) goto L5;
    L9:
        long r2 = System.currentTimeMillis();
        this.b = r2;
        long r3 = r2 - this.a;
        if (r19 <= 0) goto L15;
        if (r3 <= r19) goto L15;
        return;
    L15:
        if (c() == true) goto L17;
    L82:
        e.b r0 = null;
    L84:
        if (c() == false) goto L93;
        if (a47.a.l == false) goto L93;
        if (f == false) goto L93;
        f = false;
        long r8 = this.a;
        long r6 = this.b;
        long[] r4 = MethodCollector.getInstance().copyAllData();
        long r5 = SystemClock.uptimeMillis();
        if (r4 == null) goto L93;
        bt3.b.d.a.e(new e(r4, r5, r6, r8, r17));
    L93:
        if (c() == false) goto L105;
        ns3.a r7 = ns3.a.a.a;
        monitor-enter(r7);
    L102:
        th = move-exception;
        throw th;
    L97:
        if (r7.b != null) goto L99;
        r7.b = new a.a(new a.a.a());     // Catch: Throwable -> L102
    L99:
        a.a r9 = r7.b;     // Catch: Throwable -> L102
        monitor-exit(r7);
        r9.getClass();
    L105:
        bt3.b.d.a.e(new d(this, r0, r17, r18));
        if (c() == false) goto L150;
        ExecutorService r1 = LaunchSleepDetector.a;
        return;
    L150:
        return;
    L17:
        if (ns3.b.a == true) goto L82;
        boolean r10 = true;
        ns3.b.a = true;
        if (ns3.a.a.a.a().a == false) goto L82;
        if ((g.c & 4) == 0) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L82;
        e.b r12 = new e.b();
        int r13 = Process.myPid();     // Catch: Throwable -> L76
        BufferedReader r14 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r13 + "/task/" + r13 + "/sched"), 100);     // Catch: Throwable -> L54
    L125:
        String r15 = r14.readLine();     // Catch: Throwable -> L53
        if (r15 != null) goto L35;
    L113:
        BufferedReader r16 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r13 + "/task/" + r13 + "/stat"), 100);     // Catch: Throwable -> L110
        String[] r20 = r16.readLine().split(" ");     // Catch: Throwable -> L59
        r12.l = Long.parseLong(r20[9]);     // Catch: Throwable -> L59
        r12.m = Long.parseLong(r20[11]);     // Catch: Throwable -> L59
    L123:
        if (Build.VERSION.SDK_INT < 23) goto L127;
        r12.a = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));     // Catch: Throwable -> L109
        r12.b = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));     // Catch: Throwable -> L109
        r12.c = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));     // Catch: Throwable -> L109
        r12.d = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));     // Catch: Throwable -> L109
    L127:
        e.b(r12);     // Catch: Throwable -> L71
        if ((g.c & 128) != 0) goto L68;
        r10 = false;
    L68:
        if (r10 == false) goto L72;
        e.a(r12, r13, g.f, r3);     // Catch: Throwable -> L71
    L72:
        if (r16 != null) goto L115;
    L79:
        r0 = r12;
        goto L84
    L115:
        r16.close();     // Catch: Throwable -> L75
    L59:
        r14 = r16;
    L60:
        r16 = r14;
        goto L123
    L35:
        if (r15.contains("se.statistics.iowait_sum") == true) goto L36;
        if (r15.contains("se.statistics.wait_sum") == true) goto L39;
        if (r15.contains("se.statistics.sum_sleep_runtime") == true) goto L42;
        if (r15.contains("nr_voluntary_switches") == true) goto L45;
        if (r15.contains("nr_involuntary_switches") == true) goto L48;
        if (r15.contains("se.sum_exec_runtime") == false) goto L125;
        r12.e = Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L48:
        r12.g = Long.parseLong(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L45:
        r12.f = Long.parseLong(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L42:
        r12.j = Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L39:
        r12.i = Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
        goto L125
    L36:
        r12.h = Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1));     // Catch: Throwable -> L53
    L53:
        BufferedReader r21 = r14;
    L55:
        r14 = r21;
    L54:
        r21 = null;
    L76:
        th = move-exception;
        ns3.a r22 = ns3.a.a.a;     // Catch: Throwable -> L80
        ns3.a r23 = ns3.a.a.a;     // Catch: Throwable -> L80
        th.getLocalizedMessage();     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    L25:
        r11 = false;
        goto L26
    L5:
        if (d.j() == false) goto L9;
        throw new IllegalArgumentException("Launch mode is both none");
    }
}
