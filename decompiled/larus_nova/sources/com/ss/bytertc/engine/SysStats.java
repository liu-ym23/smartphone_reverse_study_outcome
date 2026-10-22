package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class SysStats {
    public double cpuAppUsage;
    public int cpuCores;
    public double cpuTotalUsage;
    public long freeMemory;
    public long fullMemory;
    public double memoryRatio;
    public double memoryUsage;
    public double totalMemoryRatio;
    public long totalMemoryUsage;

    public String toString() {
        return "SysStats{cpu_cores=" + this.cpuCores + "' cpu_app_usage=" + this.cpuAppUsage + "', cpu_total_usage=" + this.cpuTotalUsage + ", memory_usage=" + this.memoryUsage + "full_memory=" + this.fullMemory + "'total_memory_usage=" + this.totalMemoryUsage + "'free_memory=" + this.freeMemory + "'memory_ratio=" + this.memoryRatio + "'total_memory_ratio=" + this.totalMemoryRatio + '}';
    }

    public SysStats() {
    }

    public SysStats(int r100, double r101, double r102, double r103, long r110, long r111, long r112, double r113, double r114) {
        this.cpuCores = r100;
        this.cpuAppUsage = r101;
        this.cpuTotalUsage = r102;
        this.memoryUsage = r103;
        this.fullMemory = r110;
        this.totalMemoryUsage = r111;
        this.freeMemory = r112;
        this.memoryRatio = r113;
        this.totalMemoryRatio = r114;
    }

    private static SysStats create(int r110, double r210, double r211, double r212, long r213, long r214, long r310, double r311, double r312) {
        return new SysStats(r110, r210, r211, r212, r213, r214, r310, r311, r312);
    }
}
