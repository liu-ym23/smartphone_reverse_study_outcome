package com.facebook.battery.reporter.cpu;

import androidx.camera.video.AudioStats;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.cpu.CpuMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;

/* JADX INFO: loaded from: classes22.dex */
public class CpuMetricsReporter implements SystemMetricsReporter<CpuMetrics> {
    public static final String CHILD_CPU_SYSTEM_TIME_S = "child_cpu_system_time_s";
    public static final String CHILD_CPU_USER_TIME_S = "child_cpu_user_time_s";
    public static final String CPU_SYSTEM_TIME_S = "cpu_system_time_s";
    public static final String CPU_USER_TIME_S = "cpu_user_time_s";

    public CpuMetricsReporter() {
    }

    public void reportTo(CpuMetrics r100, SystemMetricsReporter.Event r101) {
        double r102 = r100.userTimeS;
        if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        r101.add(CPU_USER_TIME_S, r102);
    L5:
        double r103 = r100.systemTimeS;
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r101.add(CPU_SYSTEM_TIME_S, r103);
    L8:
        double r104 = r100.childUserTimeS;
        if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r101.add(CHILD_CPU_USER_TIME_S, r104);
    L11:
        double r105 = r100.childSystemTimeS;
        if (r105 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r101.add(CHILD_CPU_SYSTEM_TIME_S, r105);
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((CpuMetrics) r100, r101);
    }
}
