package com.ss.android.lark.monitor.cpu;

import com.facebook.battery.metrics.core.SystemMetrics;
import java.util.LinkedList;
import vu3.a;

/* JADX INFO: loaded from: classes36.dex */
public class CpuThreadMetrics extends SystemMetrics<CpuThreadMetrics> {
    public float cpuTimes;
    public int cpuUsage;
    public long createTime;
    public double cupSpeed;
    public float mSceneAccumulateCpuTime;
    public float mSceneAccumulateTime;
    public int switchType;
    public transient LinkedList<a.C8043a> threadMetricsMap;

    public CpuThreadMetrics diff(CpuThreadMetrics r100, CpuThreadMetrics r101) {
        return null;
    }

    public CpuThreadMetrics set(CpuThreadMetrics r100) {
        return null;
    }

    public CpuThreadMetrics sum(CpuThreadMetrics r100, CpuThreadMetrics r101) {
        return null;
    }

    public CpuThreadMetrics() {
        this.threadMetricsMap = new LinkedList();
        this.mSceneAccumulateCpuTime = 0.0f;
        this.mSceneAccumulateTime = 0.0f;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((CpuThreadMetrics) r100);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((CpuThreadMetrics) r100, (CpuThreadMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((CpuThreadMetrics) r100, (CpuThreadMetrics) r101);
    }

    public CpuThreadMetrics(LinkedList<a.C8043a> r100, double r101, int r102) {
        LinkedList<a.C8043a> r103 = new LinkedList();
        this.threadMetricsMap = r103;
        this.mSceneAccumulateCpuTime = 0.0f;
        this.mSceneAccumulateTime = 0.0f;
        r103.addAll(r100);
        this.cpuUsage = r102;
        this.cupSpeed = r101;
    }
}
