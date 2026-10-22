package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricPerformanceOptimizationConfig;", "", "performanceOptimizationEnabled", "", "memoryLeakOptimizationAction", "", "memoryLeakOptimizationDelayInSeconds", "", "killAllProcess", "<init>", "(ZIJZ)V", "getPerformanceOptimizationEnabled", "()Z", "getMemoryLeakOptimizationAction", "()I", "getMemoryLeakOptimizationDelayInSeconds", "()J", "getKillAllProcess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformanceOptimizationConfig {

    @SerializedName("kill_all_process")
    private final boolean killAllProcess;

    @SerializedName("memory_leak_optimization_action")
    private final int memoryLeakOptimizationAction;

    @SerializedName("memory_leak_optimization_delay_in_seconds")
    private final long memoryLeakOptimizationDelayInSeconds;

    @SerializedName("enable_obric_performance_optimization")
    private final boolean performanceOptimizationEnabled;

    public ObricPerformanceOptimizationConfig() {
        this(false, 0, 0, false, 15, null);
    }

    public static /* synthetic */ ObricPerformanceOptimizationConfig copy$default(ObricPerformanceOptimizationConfig r100, boolean r101, int r102, long r103, boolean r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.performanceOptimizationEnabled;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.memoryLeakOptimizationAction;
    L8:
        int r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.memoryLeakOptimizationDelayInSeconds;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.killAllProcess;
    L14:
        boolean r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final boolean component1() {
        return this.performanceOptimizationEnabled;
    }

    public final int component2() {
        return this.memoryLeakOptimizationAction;
    }

    public final long component3() {
        return this.memoryLeakOptimizationDelayInSeconds;
    }

    public final boolean component4() {
        return this.killAllProcess;
    }

    public final ObricPerformanceOptimizationConfig copy(boolean r100, int r101, long r110, boolean r111) {
        return new ObricPerformanceOptimizationConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricPerformanceOptimizationConfig) == true) goto L8;
        return false;
    L8:
        ObricPerformanceOptimizationConfig r101 = (ObricPerformanceOptimizationConfig) r100;
        if (this.performanceOptimizationEnabled == r101.performanceOptimizationEnabled) goto L12;
        return false;
    L12:
        if (this.memoryLeakOptimizationAction == r101.memoryLeakOptimizationAction) goto L15;
        return false;
    L15:
        if (this.memoryLeakOptimizationDelayInSeconds == r101.memoryLeakOptimizationDelayInSeconds) goto L18;
        return false;
    L18:
        if (this.killAllProcess == r101.killAllProcess) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.performanceOptimizationEnabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.memoryLeakOptimizationAction) * 31;
        long r103 = this.memoryLeakOptimizationDelayInSeconds;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.killAllProcess == true) goto L11;
        r100 = 1237;
    L11:
        return r104 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricPerformanceOptimizationConfig(performanceOptimizationEnabled=" + this.performanceOptimizationEnabled + ", memoryLeakOptimizationAction=" + this.memoryLeakOptimizationAction + ", memoryLeakOptimizationDelayInSeconds=" + this.memoryLeakOptimizationDelayInSeconds + ", killAllProcess=" + this.killAllProcess + ')';
    }

    public final boolean getKillAllProcess() {
        return this.killAllProcess;
    }

    public final int getMemoryLeakOptimizationAction() {
        return this.memoryLeakOptimizationAction;
    }

    public final long getMemoryLeakOptimizationDelayInSeconds() {
        return this.memoryLeakOptimizationDelayInSeconds;
    }

    public final boolean getPerformanceOptimizationEnabled() {
        return this.performanceOptimizationEnabled;
    }

    public ObricPerformanceOptimizationConfig(boolean r100, int r101, long r102, boolean r103) {
        this.performanceOptimizationEnabled = r100;
        this.memoryLeakOptimizationAction = r101;
        this.memoryLeakOptimizationDelayInSeconds = r102;
        this.killAllProcess = r103;
    }

    public /* synthetic */ ObricPerformanceOptimizationConfig(boolean r100, int r101, long r102, boolean r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = true;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r104 = 1;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r110 & 8) == 0) goto L16;
        boolean r113 = true;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L9:
        r104 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
