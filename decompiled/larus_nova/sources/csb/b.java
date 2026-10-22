package csb;

import android.os.Process;
import androidx.camera.video.AudioStats;
import com.bytedance.apm.util.n;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.cpu.CpuSceneMonitor;
import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import vt3.g;
import vt3.h;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends SystemMetricsCollector<CpuThreadMetrics> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f465227c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f465228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f465229b;

    public static b a() {
        if (f465227c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f465227c != null) goto L9;
        f465227c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f465227c;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public final SystemMetrics createMetrics() {
        return new CpuThreadMetrics();
    }

    public b() {
        this.f465228a = 0.0f;
        this.f465229b = 0;
    }

    public final boolean b(CpuThreadMetrics r110) {
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (r110.switchType != 2) goto L24;
        float r100 = CpuSceneMonitor.getCpuTimesN();     // Catch: Throwable -> L73
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L73
        float r102 = this.f465228a;     // Catch: Throwable -> L73
        if (r102 != 0.0f) goto L14;
        if (this.f465229b != 0) goto L14;
        this.f465228a = r100;     // Catch: Throwable -> L73
        this.f465229b = r101;     // Catch: Throwable -> L73
        monitor-exit(this);
    L71:
        return false;
    L14:
        float r103 = (r101 - this.f465229b) / 1000.0f;
        if (r103 > 0.0f) goto L19;
        monitor-exit(this);
        goto L71
    L19:
        float r104 = (r100 - r102) / (CpuSceneMonitor.getCpuTickN() * r103);     // Catch: Throwable -> L73
        Log.i("LarkMetrics", r103 + " seconds, average cupUsage:" + r104 + " switchType:" + r110.switchType);     // Catch: Throwable -> L73
        if (r104 >= 0.05d) goto L25;
        monitor-exit(this);
    L25:
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L73
        int r106 = com.bytedance.apm.util.b.b();     // Catch: Throwable -> L73
        if (r106 <= 0) goto L70;
        long r107 = com.bytedance.monitor.collector.c.e().d(r106);     // Catch: Throwable -> L73
        long r108 = com.bytedance.apm.util.b.a();     // Catch: Throwable -> L73
        HashMap r111 = new HashMap();     // Catch: Throwable -> L73
        g.a(Process.myPid(), r111);     // Catch: Throwable -> L73
        Thread.sleep(360);     // Catch: InterruptedException -> L68 Throwable -> L73
        float r109 = com.bytedance.apm.util.b.a() - r108;     // Catch: Throwable -> L73
        float r112 = com.bytedance.monitor.collector.c.e().d(r106) - r107;     // Catch: Throwable -> L73
        if (r109 != 0.0f) goto L35;
        Log.i("LarkMetrics", "appCpuTime is 0!");     // Catch: Throwable -> L73
        monitor-exit(this);
        goto L71
    L35:
        double r113 = r109;
        double r114 = ((1000.0d * r113) / (System.currentTimeMillis() - r105)) / com.bytedance.apm.util.b.f();     // Catch: Throwable -> L73
        if (r112 <= 0.0f) goto L39;
        double r115 = r113 / ((double) r112);     // Catch: Throwable -> L73
    L41:
        if (r115 < 1.0d) goto L43;
    L44:
        r115 = r114 / ((double) r106);     // Catch: Throwable -> L73
        Log.w("LarkMetrics", "correct appcpurate");     // Catch: Throwable -> L73
    L45:
        r110.cupSpeed = r114;     // Catch: Throwable -> L73
        r110.cpuUsage = (int) (r115 * 100.0d);     // Catch: Throwable -> L73
        Log.i("LarkMetrics", "cupSpeed:" + r114 + " cpuUsage:" + r115);     // Catch: Throwable -> L73
        HashMap r116 = new HashMap();     // Catch: Throwable -> L73
        g.a(Process.myPid(), r116);     // Catch: Throwable -> L73
        if (r111.isEmpty() == false) goto L48;
    L66:
        monitor-exit(this);
        goto L71
    L48:
        if (r116.isEmpty() == true) goto L66;
        if (r109 <= 0.0f) goto L66;
        LinkedList r117 = new LinkedList();     // Catch: Throwable -> L73
        LinkedList r118 = new LinkedList();     // Catch: Throwable -> L73
        Iterator r119 = r111.entrySet().iterator();     // Catch: Throwable -> L73
    L53:
        if (r119.hasNext() == false) goto L62;
        Map.Entry r120 = (Map.Entry) r119.next();     // Catch: Throwable -> L73
        h r121 = (h) r120.getValue();     // Catch: Throwable -> L73
        if (r121 == null) goto L53;
        h r122 = (h) r116.get(r120.getKey());     // Catch: Throwable -> L73
        if (r122 == null) goto L53;
        if (r122.f557214b.equals(r121.f557214b) == false) goto L53;
        double r123 = Math.round(((r122.f557215c - r121.f557215c) / r113) * 100.0d) / 100.0d;     // Catch: Throwable -> L73
        r117.add(new n(r122.f557214b, Double.valueOf(r123)));     // Catch: Throwable -> L73
        r118.add(new vu3.a.C8043a(r122.f557214b, r123));     // Catch: Throwable -> L73
        goto L53
    L62:
        if (r117.isEmpty() == true) goto L64;
        Collections.sort(r118, new a());     // Catch: Throwable -> L73
        r110.threadMetricsMap.addAll(r118);     // Catch: Throwable -> L73
    L64:
        monitor-exit(this);
        return true;
    L43:
        if (r115 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
    L39:
        r115 = -1.0d;
        goto L41
    L70:
        monitor-exit(this);
        goto L71
    L24:
        this.f465228a = 0.0f;     // Catch: Throwable -> L73
        this.f465229b = 0;     // Catch: Throwable -> L73
        goto L25
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public final /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return b((CpuThreadMetrics) r100);
    }
}
