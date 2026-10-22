package com.obric.performance.power.monitor.constants;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/performance/power/monitor/constants/ObricPerformancePowerMonitorConfig;", "", "enabled", "", "aiagentEnabled", "reportIntervalMillis", "", "collectCurrentIntervalMillis", "frontSampledRate", "", "backgroundSampledRate", "<init>", "(ZZJJFF)V", "getEnabled", "()Z", "getAiagentEnabled", "getReportIntervalMillis", "()J", "getCollectCurrentIntervalMillis", "getFrontSampledRate", "()F", "getBackgroundSampledRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformancePowerMonitorConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnabled;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("collect_current_interval_millis")
    private final long collectCurrentIntervalMillis;

    @SerializedName("enable")
    private final boolean enabled;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("report_interval_millis")
    private final long reportIntervalMillis;

    public ObricPerformancePowerMonitorConfig() {
        this(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ ObricPerformancePowerMonitorConfig copy$default(ObricPerformancePowerMonitorConfig r100, boolean r110, boolean r111, long r112, long r113, float r114, float r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        boolean r101 = r100.enabled;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r102 = r100.aiagentEnabled;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.reportIntervalMillis;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r104 = r100.collectCurrentIntervalMillis;
    L19:
        if ((r116 & 16) == 0) goto L21;
        float r105 = r100.frontSampledRate;
    L23:
        if ((r116 & 32) == 0) goto L25;
        float r106 = r100.backgroundSampledRate;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
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

    public final boolean component1() {
        return this.enabled;
    }

    public final boolean component2() {
        return this.aiagentEnabled;
    }

    public final long component3() {
        return this.reportIntervalMillis;
    }

    public final long component4() {
        return this.collectCurrentIntervalMillis;
    }

    public final float component5() {
        return this.frontSampledRate;
    }

    public final float component6() {
        return this.backgroundSampledRate;
    }

    public final ObricPerformancePowerMonitorConfig copy(boolean r110, boolean r111, long r112, long r113, float r114, float r115) {
        return new ObricPerformancePowerMonitorConfig(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricPerformancePowerMonitorConfig) == true) goto L8;
        return false;
    L8:
        ObricPerformancePowerMonitorConfig r101 = (ObricPerformancePowerMonitorConfig) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.aiagentEnabled == r101.aiagentEnabled) goto L15;
        return false;
    L15:
        if (this.reportIntervalMillis == r101.reportIntervalMillis) goto L18;
        return false;
    L18:
        if (this.collectCurrentIntervalMillis == r101.collectCurrentIntervalMillis) goto L21;
        return false;
    L21:
        if (Float.compare(this.frontSampledRate, r101.frontSampledRate) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.backgroundSampledRate, r101.backgroundSampledRate) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.aiagentEnabled == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.reportIntervalMillis;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.collectCurrentIntervalMillis;
        return ((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + Float.floatToIntBits(this.frontSampledRate)) * 31) + Float.floatToIntBits(this.backgroundSampledRate);
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricPerformancePowerMonitorConfig(enabled=" + this.enabled + ", aiagentEnabled=" + this.aiagentEnabled + ", reportIntervalMillis=" + this.reportIntervalMillis + ", collectCurrentIntervalMillis=" + this.collectCurrentIntervalMillis + ", frontSampledRate=" + this.frontSampledRate + ", backgroundSampledRate=" + this.backgroundSampledRate + ')';
    }

    public final boolean getAiagentEnabled() {
        return this.aiagentEnabled;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }

    public final long getCollectCurrentIntervalMillis() {
        return this.collectCurrentIntervalMillis;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final long getReportIntervalMillis() {
        return this.reportIntervalMillis;
    }

    public ObricPerformancePowerMonitorConfig(boolean r100, boolean r101, long r102, long r103, float r104, float r105) {
        this.enabled = r100;
        this.aiagentEnabled = r101;
        this.reportIntervalMillis = r102;
        this.collectCurrentIntervalMillis = r103;
        this.frontSampledRate = r104;
        this.backgroundSampledRate = r105;
    }

    public /* synthetic */ ObricPerformancePowerMonitorConfig(boolean r110, boolean r111, long r112, long r113, float r114, float r115, int r116, DefaultConstructorMarker r117) {
        boolean r100 = false;
        if ((r116 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r116 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r102 = 30000;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r103 = 3000;
    L18:
        float r104 = 0.0f;
        if ((r116 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r104 = r115;
    L26:
        this(r101, r100, r102, r103, r105, r104);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
