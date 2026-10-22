package com.obric.performance.power.monitor.cpu;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u001e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003J\b\u0010(\u001a\u00020)H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R4\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R4\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/performance/power/monitor/cpu/CPUInfo;", "", "refreshTime", "", "devCpu", "devIdle", "devCpuFreqMap", "", "", "procCpu", "threadCpuMap", "threadCpuPolicyMap", "<init>", "(JJJLjava/util/Map;JLjava/util/Map;Ljava/util/Map;)V", "getRefreshTime", "()J", "setRefreshTime", "(J)V", "getDevCpu", "setDevCpu", "getDevIdle", "setDevIdle", "getDevCpuFreqMap", "()Ljava/util/Map;", "setDevCpuFreqMap", "(Ljava/util/Map;)V", "getProcCpu", "setProcCpu", "getThreadCpuMap", "setThreadCpuMap", "getThreadCpuPolicyMap", "setThreadCpuPolicyMap", "putDeviceCpuFreq", "", "policyId", "freqId", "time", "putThreadCpuPolicy", "tid", "putThreadCpu", "toString", "", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CPUInfo {
    private long devCpu;
    private Map<Integer, Map<Long, Long>> devCpuFreqMap;
    private long devIdle;
    private long procCpu;
    private long refreshTime;
    private Map<Integer, Long> threadCpuMap;
    private Map<Integer, Map<Integer, Long>> threadCpuPolicyMap;

    public CPUInfo() {
        this(0, 0, 0, null, 0, null, null, 127, null);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("(refreshTime:");
        r100.append(this.refreshTime);
        r100.append(", devCpu:");
        r100.append(this.devCpu);
        r100.append(", devIdle:");
        r100.append(this.devIdle);
        r100.append(", procCpu:");
        r100.append(this.procCpu);
        r100.append(", devCpuPolicy:");
        Object r101 = this.devCpuFreqMap;
        Object r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(" threadCpuMap:");
        Object r103 = this.threadCpuMap;
        if (r103 != null) goto L8;
        r103 = "null";
    L8:
        r100.append(r103);
        r100.append(" threadCpuPolicyMap:");
        Map<Integer, Map<Integer, Long>> r104 = this.threadCpuPolicyMap;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    }

    public final long getDevCpu() {
        return this.devCpu;
    }

    public final Map<Integer, Map<Long, Long>> getDevCpuFreqMap() {
        return this.devCpuFreqMap;
    }

    public final long getDevIdle() {
        return this.devIdle;
    }

    public final long getProcCpu() {
        return this.procCpu;
    }

    public final long getRefreshTime() {
        return this.refreshTime;
    }

    public final Map<Integer, Long> getThreadCpuMap() {
        return this.threadCpuMap;
    }

    public final Map<Integer, Map<Integer, Long>> getThreadCpuPolicyMap() {
        return this.threadCpuPolicyMap;
    }

    public final void setDevCpu(long r100) {
        this.devCpu = r100;
    }

    public final void setDevCpuFreqMap(Map<Integer, Map<Long, Long>> r100) {
        this.devCpuFreqMap = r100;
    }

    public final void setDevIdle(long r100) {
        this.devIdle = r100;
    }

    public final void setProcCpu(long r100) {
        this.procCpu = r100;
    }

    public final void setRefreshTime(long r100) {
        this.refreshTime = r100;
    }

    public final void setThreadCpuMap(Map<Integer, Long> r100) {
        this.threadCpuMap = r100;
    }

    public final void setThreadCpuPolicyMap(Map<Integer, Map<Integer, Long>> r100) {
        this.threadCpuPolicyMap = r100;
    }

    public final void putThreadCpu(int r100, long r101) {
        if (this.threadCpuMap != null) goto L5;
        this.threadCpuMap = new LinkedHashMap();
    L5:
        Map<Integer, Long> r102 = this.threadCpuMap;
        if (r102 == null) goto L9;
        r102.put(Integer.valueOf(r100), Long.valueOf(r101));
        return;
    }

    public final void putDeviceCpuFreq(int r100, long r101, long r102) {
        if (this.devCpuFreqMap != null) goto L5;
        this.devCpuFreqMap = new LinkedHashMap();
    L5:
        Map<Integer, Map<Long, Long>> r103 = this.devCpuFreqMap;
        if (r103 == null) goto L11;
        Integer r104 = Integer.valueOf(r100);
        Map<Long, Long> r105 = r103.get(r104);
        if (r105 != null) goto L10;
        r105 = new LinkedHashMap();
        r103.put(r104, r105);
    L10:
        r105.put(Long.valueOf(r101), Long.valueOf(r102));
    L11:
        this.devCpu += r102;
    }

    public final void putThreadCpuPolicy(int r100, int r101, long r102) {
        if (this.threadCpuPolicyMap != null) goto L5;
        this.threadCpuPolicyMap = new LinkedHashMap();
    L5:
        Map<Integer, Map<Integer, Long>> r103 = this.threadCpuPolicyMap;
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r100);
        Map<Integer, Long> r105 = r103.get(r104);
        if (r105 != null) goto L10;
        r105 = new LinkedHashMap();
        r103.put(r104, r105);
    L10:
        r105.put(Integer.valueOf(r101), Long.valueOf(r102));
    L12:
        if (this.threadCpuMap != null) goto L14;
        this.threadCpuMap = new LinkedHashMap();
    L14:
        Map<Integer, Long> r106 = this.threadCpuMap;
        if (r106 == null) goto L21;
        Integer r107 = Integer.valueOf(r100);
        Long r108 = r106.get(r107);
        if (r108 != null) goto L19;
        r108 = 0L;
        r106.put(r107, r108);
    L19:
        long r109 = r108.longValue() + r102;
        r106.put(Integer.valueOf(r100), Long.valueOf(r109));
        return;
    }

    public CPUInfo(long r100, long r101, long r102, Map<Integer, Map<Long, Long>> r103, long r104, Map<Integer, Long> r110, Map<Integer, Map<Integer, Long>> r111) {
        this.refreshTime = r100;
        this.devCpu = r101;
        this.devIdle = r102;
        this.devCpuFreqMap = r103;
        this.procCpu = r104;
        this.threadCpuMap = r110;
        this.threadCpuPolicyMap = r111;
    }

    public /* synthetic */ CPUInfo(long r110, long r111, long r112, Map r113, long r210, Map r211, Map r212, int r213, DefaultConstructorMarker r214) {
        long r100 = 0;
        if ((r213 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r213 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r103 = 0;
    L14:
        Map r104 = null;
        if ((r213 & 8) == 0) goto L17;
        Map r105 = null;
    L19:
        if ((r213 & 16) != 0) goto L23;
        r100 = r210;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Map r114 = null;
    L27:
        if ((r213 & 64) != 0) goto L30;
        r104 = r212;
    L30:
        this(r101, r102, r103, r105, r100, r114, r104);
        return;
    L25:
        r114 = r211;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
