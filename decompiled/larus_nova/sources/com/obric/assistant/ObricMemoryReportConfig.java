package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/obric/assistant/ObricMemoryReportConfig;", "", "isMemoryReportEnabled", "", "enableHeapSample", "heapIntervalMs", "", "enableTotalPssSample", "totalPssIntervalMs", "enableMemoryStatsSample", "memoryStatsIntervalMs", "enableBackgroundUptime5min", "<init>", "(ZZJZJZJZ)V", "()Z", "getEnableHeapSample", "getHeapIntervalMs", "()J", "getEnableTotalPssSample", "getTotalPssIntervalMs", "getEnableMemoryStatsSample", "getMemoryStatsIntervalMs", "getEnableBackgroundUptime5min", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryReportConfig {

    @SerializedName("enable_background_uptime_5min")
    private final boolean enableBackgroundUptime5min;

    @SerializedName("enable_heap_sample")
    private final boolean enableHeapSample;

    @SerializedName("enable_memory_stats_sample")
    private final boolean enableMemoryStatsSample;

    @SerializedName("enable_total_pss_sample")
    private final boolean enableTotalPssSample;

    @SerializedName("heap_interval_ms")
    private final long heapIntervalMs;

    @SerializedName("enable_obric_memory_report")
    private final boolean isMemoryReportEnabled;

    @SerializedName("memory_stats_interval_ms")
    private final long memoryStatsIntervalMs;

    @SerializedName("total_pss_interval_ms")
    private final long totalPssIntervalMs;

    public ObricMemoryReportConfig() {
        this(false, false, 0, false, 0, false, 0, false, 255, null);
    }

    public static /* synthetic */ ObricMemoryReportConfig copy$default(ObricMemoryReportConfig r110, boolean r111, boolean r112, long r113, boolean r114, long r115, boolean r210, long r211, boolean r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        boolean r100 = r110.isMemoryReportEnabled;
    L7:
        if ((r213 & 2) == 0) goto L9;
        boolean r101 = r110.enableHeapSample;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = r110.heapIntervalMs;
    L15:
        if ((r213 & 8) == 0) goto L17;
        boolean r103 = r110.enableTotalPssSample;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r104 = r110.totalPssIntervalMs;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r105 = r110.enableMemoryStatsSample;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r116 = r110.memoryStatsIntervalMs;
    L31:
        if ((r213 & 128) == 0) goto L33;
        boolean r106 = r110.enableBackgroundUptime5min;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116, r106);
    L33:
        r106 = r212;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.isMemoryReportEnabled;
    }

    public final boolean component2() {
        return this.enableHeapSample;
    }

    public final long component3() {
        return this.heapIntervalMs;
    }

    public final boolean component4() {
        return this.enableTotalPssSample;
    }

    public final long component5() {
        return this.totalPssIntervalMs;
    }

    public final boolean component6() {
        return this.enableMemoryStatsSample;
    }

    public final long component7() {
        return this.memoryStatsIntervalMs;
    }

    public final boolean component8() {
        return this.enableBackgroundUptime5min;
    }

    public final ObricMemoryReportConfig copy(boolean r110, boolean r111, long r112, boolean r113, long r114, boolean r210, long r211, boolean r212) {
        return new ObricMemoryReportConfig(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricMemoryReportConfig) == true) goto L8;
        return false;
    L8:
        ObricMemoryReportConfig r101 = (ObricMemoryReportConfig) r100;
        if (this.isMemoryReportEnabled == r101.isMemoryReportEnabled) goto L12;
        return false;
    L12:
        if (this.enableHeapSample == r101.enableHeapSample) goto L15;
        return false;
    L15:
        if (this.heapIntervalMs == r101.heapIntervalMs) goto L18;
        return false;
    L18:
        if (this.enableTotalPssSample == r101.enableTotalPssSample) goto L21;
        return false;
    L21:
        if (this.totalPssIntervalMs == r101.totalPssIntervalMs) goto L24;
        return false;
    L24:
        if (this.enableMemoryStatsSample == r101.enableMemoryStatsSample) goto L27;
        return false;
    L27:
        if (this.memoryStatsIntervalMs == r101.memoryStatsIntervalMs) goto L30;
        return false;
    L30:
        if (this.enableBackgroundUptime5min == r101.enableBackgroundUptime5min) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isMemoryReportEnabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableHeapSample == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.heapIntervalMs;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.enableTotalPssSample == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        long r109 = this.totalPssIntervalMs;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.enableMemoryStatsSample == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        long r113 = this.memoryStatsIntervalMs;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        if (this.enableBackgroundUptime5min == true) goto L23;
        r100 = 1237;
    L23:
        return r114 + r100;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricMemoryReportConfig(isMemoryReportEnabled=" + this.isMemoryReportEnabled + ", enableHeapSample=" + this.enableHeapSample + ", heapIntervalMs=" + this.heapIntervalMs + ", enableTotalPssSample=" + this.enableTotalPssSample + ", totalPssIntervalMs=" + this.totalPssIntervalMs + ", enableMemoryStatsSample=" + this.enableMemoryStatsSample + ", memoryStatsIntervalMs=" + this.memoryStatsIntervalMs + ", enableBackgroundUptime5min=" + this.enableBackgroundUptime5min + ')';
    }

    public final boolean getEnableBackgroundUptime5min() {
        return this.enableBackgroundUptime5min;
    }

    public final boolean getEnableHeapSample() {
        return this.enableHeapSample;
    }

    public final boolean getEnableMemoryStatsSample() {
        return this.enableMemoryStatsSample;
    }

    public final boolean getEnableTotalPssSample() {
        return this.enableTotalPssSample;
    }

    public final long getHeapIntervalMs() {
        return this.heapIntervalMs;
    }

    public final long getMemoryStatsIntervalMs() {
        return this.memoryStatsIntervalMs;
    }

    public final long getTotalPssIntervalMs() {
        return this.totalPssIntervalMs;
    }

    public final boolean isMemoryReportEnabled() {
        return this.isMemoryReportEnabled;
    }

    public ObricMemoryReportConfig(boolean r100, boolean r101, long r102, boolean r103, long r104, boolean r105, long r106, boolean r110) {
        this.isMemoryReportEnabled = r100;
        this.enableHeapSample = r101;
        this.heapIntervalMs = r102;
        this.enableTotalPssSample = r103;
        this.totalPssIntervalMs = r104;
        this.enableMemoryStatsSample = r105;
        this.memoryStatsIntervalMs = r106;
        this.enableBackgroundUptime5min = r110;
    }

    public /* synthetic */ ObricMemoryReportConfig(boolean r110, boolean r111, long r112, boolean r113, long r114, boolean r210, long r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        boolean r100 = true;
        if ((r213 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r213 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r103 = 60000;
    L15:
        if ((r213 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r105 = 180000;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r115 = 300000;
    L31:
        if ((r213 & 128) != 0) goto L34;
        r100 = r212;
    L34:
        this(r101, r102, r103, r104, r105, r106, r115, r100);
        return;
    L29:
        r115 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
