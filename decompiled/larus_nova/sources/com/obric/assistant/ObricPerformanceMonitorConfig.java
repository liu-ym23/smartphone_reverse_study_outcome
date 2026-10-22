package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/ObricPerformanceMonitorConfig;", "", "performanceMonitorEnabled", "", "memoryMonitorConfig", "Lcom/obric/assistant/ObricMemoryMonitorConfig;", "performanceOptimizationConfig", "Lcom/obric/assistant/ObricPerformanceOptimizationConfig;", "<init>", "(ZLcom/obric/assistant/ObricMemoryMonitorConfig;Lcom/obric/assistant/ObricPerformanceOptimizationConfig;)V", "getPerformanceMonitorEnabled", "()Z", "getMemoryMonitorConfig", "()Lcom/obric/assistant/ObricMemoryMonitorConfig;", "getPerformanceOptimizationConfig", "()Lcom/obric/assistant/ObricPerformanceOptimizationConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformanceMonitorConfig {

    @SerializedName("obric_memory_monitor_config")
    private final ObricMemoryMonitorConfig memoryMonitorConfig;

    @SerializedName("enable_obric_performance_monitor")
    private final boolean performanceMonitorEnabled;

    @SerializedName("obric_performance_optimization_config")
    private final ObricPerformanceOptimizationConfig performanceOptimizationConfig;

    public ObricPerformanceMonitorConfig() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ObricPerformanceMonitorConfig copy$default(ObricPerformanceMonitorConfig r100, boolean r101, ObricMemoryMonitorConfig r102, ObricPerformanceOptimizationConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.performanceMonitorEnabled;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.memoryMonitorConfig;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.performanceOptimizationConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.performanceMonitorEnabled;
    }

    public final ObricMemoryMonitorConfig component2() {
        return this.memoryMonitorConfig;
    }

    public final ObricPerformanceOptimizationConfig component3() {
        return this.performanceOptimizationConfig;
    }

    public final ObricPerformanceMonitorConfig copy(boolean r100, ObricMemoryMonitorConfig r101, ObricPerformanceOptimizationConfig r102) {
        return new ObricPerformanceMonitorConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricPerformanceMonitorConfig) == true) goto L8;
        return false;
    L8:
        ObricPerformanceMonitorConfig r101 = (ObricPerformanceMonitorConfig) r100;
        if (this.performanceMonitorEnabled == r101.performanceMonitorEnabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memoryMonitorConfig, r101.memoryMonitorConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.performanceOptimizationConfig, r101.performanceOptimizationConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.performanceMonitorEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        ObricMemoryMonitorConfig r102 = this.memoryMonitorConfig;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        ObricPerformanceOptimizationConfig r106 = this.performanceOptimizationConfig;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricPerformanceMonitorConfig(performanceMonitorEnabled=" + this.performanceMonitorEnabled + ", memoryMonitorConfig=" + this.memoryMonitorConfig + ", performanceOptimizationConfig=" + this.performanceOptimizationConfig + ')';
    }

    public final ObricMemoryMonitorConfig getMemoryMonitorConfig() {
        return this.memoryMonitorConfig;
    }

    public final boolean getPerformanceMonitorEnabled() {
        return this.performanceMonitorEnabled;
    }

    public final ObricPerformanceOptimizationConfig getPerformanceOptimizationConfig() {
        return this.performanceOptimizationConfig;
    }

    public ObricPerformanceMonitorConfig(boolean r100, ObricMemoryMonitorConfig r101, ObricPerformanceOptimizationConfig r102) {
        this.performanceMonitorEnabled = r100;
        this.memoryMonitorConfig = r101;
        this.performanceOptimizationConfig = r102;
    }

    public /* synthetic */ ObricPerformanceMonitorConfig(boolean r100, ObricMemoryMonitorConfig r110, ObricPerformanceOptimizationConfig r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r110 = new ObricMemoryMonitorConfig(false, 0, 0.0f, 0, 15, null);
    L9:
        if ((r112 & 4) == 0) goto L11;
        r111 = new ObricPerformanceOptimizationConfig(false, 0, 0, false, 15, null);
    L11:
        this(r100, r110, r111);
    }
}
