package c05;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.ProcessMonitorConfig;
import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final long a = 0;
    public static volatile ScheduledFuture<?> b;
    public static final long c = 0;
    public static final CopyOnWriteArrayList<InterfaceC0010a> d = null;
    public static final ConcurrentHashMap<String, Integer> e = null;
    public static final ConcurrentHashMap<String, Integer> f = null;
    public static final boolean g = false;
    public static final boolean h = false;
    public static final boolean i = false;
    public static volatile boolean j;
    public static final b k = null;

    /* JADX INFO: renamed from: c05.a$a, reason: collision with other inner class name */
    public interface InterfaceC0010a {
        void onProcessCpuChange(String r1, boolean r2, CpuInfo r3);
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public static void a() {
            tt5.a.h("ProcessMonitor_CpuCollectTimerService", "CpuTask coming");
        L52:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
            return;
        L4:
            if (a.b == null) goto L50;
            ScheduledFuture<?> r2 = a.b;     // Catch: Throwable -> L52
            if (r2 != null) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == true) goto L50;
            ConcurrentHashMap<String, Integer> r4 = a.e;     // Catch: Throwable -> L52
            if (r4.isEmpty() == true) goto L50;
            Iterator<Map.Entry<String, Integer>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L52
        L17:
            if (r5.hasNext() == false) goto L60;
            Map.Entry<String, Integer> r6 = r5.next();     // Catch: Throwable -> L52
            if (a.i == true) goto L21;
        L31:
            int r7 = c05.b.b;     // Catch: Throwable -> L52
            CpuInfo r8 = c05.b.a.a(r6.getKey(), a.h);     // Catch: Throwable -> L52
        L32:
            if (r8 == null) goto L36;
            Integer r9 = r8.getPid();     // Catch: Throwable -> L52
            if (r9 == null) goto L36;
            int r10 = r9.intValue();     // Catch: Throwable -> L52
        L37:
            ConcurrentHashMap<String, Integer> r11 = a.f;     // Catch: Throwable -> L52
            Integer r12 = r11.get(r6.getKey());     // Catch: Throwable -> L52
            if (r12 == null) goto L40;
            int r13 = r12.intValue();     // Catch: Throwable -> L52
        L41:
            if (r13 <= 0) goto L45;
            if (r10 <= 0) goto L45;
            if (r13 == r10) goto L45;
            tt5.a.k("ProcessMonitor_CpuCollectTimerService", "check process restarted, process=" + r6.getKey() + ", curPid=" + r10);     // Catch: Throwable -> L52
            boolean r14 = true;
        L46:
            r11.put(r6.getKey(), Integer.valueOf(r10));     // Catch: Throwable -> L52
            Iterator<InterfaceC0010a> r16 = a.d.iterator();     // Catch: Throwable -> L52
        L48:
            if (r16.hasNext() == false) goto L17;
            r16.next().onProcessCpuChange(r6.getKey(), r14, r8);     // Catch: Throwable -> L52
        L45:
            r14 = false;
            goto L46
        L40:
            r13 = 0;
        L36:
            r10 = 0;
            goto L37
        L21:
            if (TextUtils.equals("sandboxed_process", r6.getKey()) == false) goto L31;
            int r17 = c05.b.b;     // Catch: Throwable -> L28
            ISandboxProcessServer r18 = c05.b.a.b();     // Catch: Throwable -> L28
            if (r18 != null) goto L25;
            tt5.a.d("ProcessMonitor_CpuCollectTimerService", "sandboxServer is null");     // Catch: Throwable -> L28
        L25:
            if (r18 == null) goto L30;
            r8 = r18.getCurrentCpuRate(r6.getKey(), a.h);     // Catch: Throwable -> L28
        L30:
            r8 = null;
            goto L32
        L28:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);     // Catch: Throwable -> L52
            goto L30
        L60:
            return;
        L8:
            if (r2.isCancelled() != true) goto L10;
            r3 = true;
        L50:
            tt5.a.h("ProcessMonitor_CpuCollectTimerService", "CpuTask ignore run");     // Catch: Throwable -> L52
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

    public static void a() {
    L16:
        th = move-exception;
        tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
        return;
    L4:
        if (b == null) goto L21;
        ScheduledFuture<?> r1 = b;     // Catch: Throwable -> L16
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L22;
        ScheduledFuture<?> r3 = b;     // Catch: Throwable -> L16
        if (r3 == null) goto L23;
        r3.cancel(true);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r1.isCancelled() != true) goto L10;
        r2 = true;
        goto L11
    }

    static {
        a = 300000;
        c = 5000;
        d = new CopyOnWriteArrayList();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        j = true;
        k = b.a;
        ProcessMonitorConfig r0 = (ProcessMonitorConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(ProcessMonitorConfig.KEY, ProcessMonitorConfig.class, new ProcessMonitorConfig());
        c = r0.getCpuConfig().getIntervalInMills();
        g = r0.getCpuConfig().isDiscardInBackground();
        h = r0.getCpuConfig().isThreadCollectEnable();
        i = r0.getCpuConfig().isSandboxCollectFallback();
        a = r0.getCpuConfig().getBgIntervalInMills();
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "processMonitorConfig=" + r0);
    }

    public static void b(long r9, long r11) {
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "restartTask delay=" + r9 + " interval=" + r11);
        a();     // Catch: Throwable -> L8
        ScheduledExecutorService r2 = CoreThreadPool.getDefault().getScheduleThreadPool();     // Catch: Throwable -> L8
        b r3 = k;     // Catch: Throwable -> L8
        if (r11 > 0) goto L6;
        r11 = 5000;
    L6:
        b = r2.scheduleWithFixedDelay(r3, r9, r11, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
    }
}
