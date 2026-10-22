package csb;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;
import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import com.ss.android.lark.monitor.z;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements SystemMetricsReporter<CpuThreadMetrics> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f465231a;

    public d(int r100) {
        this.f465231a = r100;
    }

    public final void a(CpuThreadMetrics r100, SystemMetricsReporter.Event r101) {
        r101.add("cpu_rate", r100.cupSpeed);
        r101.add("cpu_usage", r100.cpuUsage);
        if ((r101 instanceof z) == false) goto L7;
        LinkedList<vu3.a.C8043a> r102 = r100.threadMetricsMap;
        int r103 = Math.min(r102.size(), this.f465231a);
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        ((z) r101).a(r102.get(r104).f557352a, r102.get(r104).f557353b);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public final /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        a((CpuThreadMetrics) r100, r101);
    }
}
