package c05;

import android.app.ActivityManager;
import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.ThreadExceptionItem;
import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.LarkContext;
import eu5.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vt3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static long a;
    public static final /* synthetic */ int b = 0;

    public static final class a {
        public static ISandboxProcessServer b() {
            ArrayList r4 = g.g(LarkContext.getApplication());     // Catch: Throwable -> L13
            boolean r6 = true;
            if (r4.size() != 1) goto L15;
            String r5 = (String) ListProtector.get(r4, 0);     // Catch: Throwable -> L13
            if (r5 != null) goto L8;
        L10:
            r6 = false;
        L11:
            if (r6 == false) goto L15;
            jrc.b r1 = jrc.b.a.a;     // Catch: Throwable -> L13
            Application r7 = LarkContext.getApplication();     // Catch: Throwable -> L13
            r1.getClass();     // Catch: Throwable -> L13
            ISandboxProcessServer r2 = (ISandboxProcessServer) jrc.b.a(r7, ISandboxProcessServer.class);     // Catch: Throwable -> L13
        L16:
            if (r2 != null) goto L18;
            tt5.a.d("ProcessMonitor_CpuUtils", "sandboxServer is null");     // Catch: Throwable -> L13
        L18:
            return r2;
        L8:
            if (StringsKt.contains$default(r5, "sandboxed_process0", false, 2, null) != true) goto L10;
        L15:
            tt5.a.k("ProcessMonitor_CpuUtils", "sandBoxProcessNames is " + r4);     // Catch: Throwable -> L13
            r2 = null;
        L13:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuUtils", th, false);
            return null;
        }

        public static CpuInfo c(int r18) {
            long r0 = System.currentTimeMillis();
            if ((r0 - b.a) >= ToastModel.DEFAULT_DURATION) goto L6;
            tt5.a.k("ProcessMonitor_CpuUtils", "getPidCpuRate(" + r18 + "), too frequently");
            return null;
        L6:
            b.a = r0;
            int r3 = com.bytedance.apm.util.b.b();
            if (r3 > 0) goto L9;
            tt5.a.k("ProcessMonitor_CpuUtils", "CommonMonitorUtil.getCpuCoreNum() is null");
            r3 = Runtime.getRuntime().availableProcessors();
        L9:
            if (r3 > 0) goto L12;
            tt5.a.k("ProcessMonitor_CpuUtils", "cpuNum is null");
            return null;
        L12:
            long r4 = com.bytedance.apm.util.b.d(r18);
            long r8 = com.bytedance.monitor.collector.c.e().d(r3);
            Thread.sleep(360);     // Catch: Throwable -> L24 InterruptedException -> L15
        L15:
            boolean r10 = true;
        L16:
            if (r10 == false) goto L18;
            return null;
        L18:
            long r11 = com.bytedance.apm.util.b.d(r18);
            long r12 = com.bytedance.monitor.collector.c.e().d(r3);
            long r14 = r12 - r8;
            if (r14 <= 0) goto L21;
            double r6 = ((r11 - r4) * 1.0f) / r14;
        L22:
            tt5.a.h("ProcessMonitor_CpuUtils", "pidCpuRate -> appCpuRate=" + r6 + ". appCpuStat2=" + r11 + " appCpuStat=" + r4 + " totalCpuStat2=" + r12 + " totalCpuStat=" + r8);
            double r13 = (((((double) r11) - ((double) r4)) * ((double) UploadResult.UPLOAD_CACELL)) / ((double) (System.currentTimeMillis() - r0))) / ((double) com.bytedance.apm.util.b.f());
            StringBuilder r1 = new StringBuilder("pidCpuSpeed -> ");
            r1.append(r13);
            tt5.a.h("ProcessMonitor_CpuUtils", r1.toString());
            return new CpuInfo(Integer.valueOf(r18), Double.valueOf(r6), Double.valueOf(r13), null);
        L21:
            r6 = -1.0d;
        L14:
            r10 = false;
            goto L16
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static CpuInfo a(String r12, boolean r13) {
            if (TextUtils.isEmpty(r12) == false) goto L31;
            return null;
        L31:
            Object r3 = LarkContext.getApplication().getSystemService("activity");     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L26
            Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3).getRunningAppProcesses().iterator();     // Catch: Throwable -> L26
        L8:
            if (r4.hasNext() == false) goto L28;
            ActivityManager.RunningAppProcessInfo r5 = r4.next();     // Catch: Throwable -> L26
            String r6 = r5.processName;     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L26
            if (StringsKt.contains$default(r6, r12, false, 2, null) == false) goto L8;
            int r14 = r5.pid;     // Catch: Throwable -> L26
            CpuInfo r7 = c(r14);     // Catch: Throwable -> L26
            if (r13 == false) goto L25;
            HashMap r16 = new HashMap();     // Catch: Throwable -> L26
            long r8 = SystemClock.uptimeMillis();     // Catch: Throwable -> L26
            vt3.g.a(r14, r16);     // Catch: Throwable -> L16
        L18:
            HashMap r17 = new HashMap();     // Catch: Throwable -> L26
            Iterator r9 = r16.entrySet().iterator();     // Catch: Throwable -> L26
        L20:
            if (r9.hasNext() == false) goto L22;
            Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L26
            r17.put(r10.getKey(), new ThreadExceptionItem(Long.valueOf(((h) r10.getValue()).c), ((h) r10.getValue()).b, Integer.valueOf(((h) r10.getValue()).a)));     // Catch: Throwable -> L26
            goto L20
        L22:
            if (r7 == 0) goto L24;
            r7.setThreadMap(r17);     // Catch: Throwable -> L26
        L24:
            tt5.a.h("ProcessMonitor_CpuUtils", "thread cost=" + (SystemClock.uptimeMillis() - r8) + " size=" + r16.size() + " val=" + r16);     // Catch: Throwable -> L26
            goto L25
        L16:
            th = move-exception;
            tt5.a.d("ProcessMonitor_CpuUtils", "getThreadInfo error-> " + th.getMessage());     // Catch: Throwable -> L26
        L25:
            return r7;
        L28:
            return null;
        L26:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuUtils", th, false);
            goto L28
        }
    }

    static {
    }
}
