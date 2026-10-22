package com.ss.android.lark.monitor.memory;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes36.dex */
public class MemoryMetrics extends SystemMetrics<MemoryMetrics> {
    public long createTime;
    public int gcCount;
    public int javaHeapMB;
    public int maxMemMB;
    public int nativeHeapMB;
    public int reachTopCount;
    public int totalMemMB;

    public int hashCode() {
        int r100 = this.totalMemMB;
        int r101 = (r100 ^ (r100 >>> 32)) * 31;
        int r102 = this.maxMemMB;
        int r103 = (r101 + (r102 ^ (r102 >>> 32))) * 31;
        int r104 = this.javaHeapMB;
        int r105 = (r103 + (r104 ^ (r104 >>> 32))) * 31;
        int r106 = this.nativeHeapMB;
        return r105 + (r106 ^ (r106 >>> 32));
    }

    public String toString() {
        return "MemoryMetrics{maxMemMB=" + this.maxMemMB + "totalMemMB=" + this.totalMemMB + "javaHeapMB=" + this.javaHeapMB + "nativeHeapMB=" + this.nativeHeapMB + '}';
    }

    public MemoryMetrics() {
        this.createTime = System.currentTimeMillis();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        MemoryMetrics r101 = (MemoryMetrics) r100;
        if (this.maxMemMB == r101.maxMemMB) goto L13;
    L19:
        return false;
    L13:
        if (this.totalMemMB != r101.totalMemMB) goto L19;
        if (this.javaHeapMB != r101.javaHeapMB) goto L19;
        if (this.nativeHeapMB != r101.nativeHeapMB) goto L19;
        return true;
    }

    public MemoryMetrics set(MemoryMetrics r100) {
        this.totalMemMB = r100.totalMemMB;
        this.javaHeapMB = r100.javaHeapMB;
        this.nativeHeapMB = r100.nativeHeapMB;
        this.maxMemMB = r100.maxMemMB;
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((MemoryMetrics) r100);
    }

    public MemoryMetrics diff(MemoryMetrics r100, MemoryMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new MemoryMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.maxMemMB = this.maxMemMB;
        r101.totalMemMB = this.totalMemMB - r100.totalMemMB;
        r101.javaHeapMB = this.javaHeapMB - r100.javaHeapMB;
        r101.nativeHeapMB = this.nativeHeapMB - r100.nativeHeapMB;
        r101.gcCount = this.gcCount - r100.gcCount;
        goto L7
    }

    public MemoryMetrics sum(MemoryMetrics r100, MemoryMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new MemoryMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.maxMemMB = this.maxMemMB;
        r101.totalMemMB = this.totalMemMB + r100.totalMemMB;
        r101.javaHeapMB = this.javaHeapMB + r100.javaHeapMB;
        r101.nativeHeapMB = this.nativeHeapMB + r100.nativeHeapMB;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((MemoryMetrics) r100, (MemoryMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((MemoryMetrics) r100, (MemoryMetrics) r101);
    }
}
