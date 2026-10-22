package com.larus.settings.provider.perf;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u009e\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00062"}, d2 = {"Lcom/larus/settings/provider/perf/CoroutinesMonitorConfig;", "", "enableReportApm", "", "enableStackTrace", "enableClipStack", "waitThresholdMS", "", "mainExecThresholdMS", "ioExecThresholdMS", "calculatePeriodMS", "monitorThreadList", "", "", "monitorThreadThreshold", "Lcom/larus/settings/provider/perf/MonitorThreadThreshold;", "calcBlackList", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnableReportApm", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableStackTrace", "getEnableClipStack", "getWaitThresholdMS", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMainExecThresholdMS", "getIoExecThresholdMS", "getCalculatePeriodMS", "getMonitorThreadList", "()Ljava/util/List;", "getMonitorThreadThreshold", "getCalcBlackList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/larus/settings/provider/perf/CoroutinesMonitorConfig;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoroutinesMonitorConfig {

    @SerializedName("calculate_black_list")
    private final List<String> calcBlackList;

    @SerializedName("calculate_period_ms")
    private final Integer calculatePeriodMS;

    @SerializedName("enable_clip_stack")
    private final Boolean enableClipStack;

    @SerializedName("enable_report_apm")
    private final Boolean enableReportApm;

    @SerializedName("enable_stack_trace")
    private final Boolean enableStackTrace;

    @SerializedName("io_exec_threshold_ms")
    private final Integer ioExecThresholdMS;

    @SerializedName("main_exec_threshold_ms")
    private final Integer mainExecThresholdMS;

    @SerializedName("monitor_thread_list")
    private final List<String> monitorThreadList;

    @SerializedName("monitor_thread_threshold_config")
    private final List<MonitorThreadThreshold> monitorThreadThreshold;

    @SerializedName("wait_threshold_ms")
    private final Integer waitThresholdMS;

    public CoroutinesMonitorConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoroutinesMonitorConfig copy$default(CoroutinesMonitorConfig r110, Boolean r111, Boolean r112, Boolean r113, Integer r114, Integer r115, Integer r116, Integer r117, List r118, List r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Boolean r100 = r110.enableReportApm;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Boolean r101 = r110.enableStackTrace;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Boolean r102 = r110.enableClipStack;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = r110.waitThresholdMS;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = r110.mainExecThresholdMS;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = r110.ioExecThresholdMS;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r106 = r110.calculatePeriodMS;
    L31:
        if ((r212 & 128) == 0) goto L33;
        List r107 = r110.monitorThreadList;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.monitorThreadThreshold;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.calcBlackList;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    public final Boolean component1() {
        return this.enableReportApm;
    }

    public final List<String> component10() {
        return this.calcBlackList;
    }

    public final Boolean component2() {
        return this.enableStackTrace;
    }

    public final Boolean component3() {
        return this.enableClipStack;
    }

    public final Integer component4() {
        return this.waitThresholdMS;
    }

    public final Integer component5() {
        return this.mainExecThresholdMS;
    }

    public final Integer component6() {
        return this.ioExecThresholdMS;
    }

    public final Integer component7() {
        return this.calculatePeriodMS;
    }

    public final List<String> component8() {
        return this.monitorThreadList;
    }

    public final List<MonitorThreadThreshold> component9() {
        return this.monitorThreadThreshold;
    }

    public final CoroutinesMonitorConfig copy(Boolean r110, Boolean r111, Boolean r112, Integer r113, Integer r114, Integer r115, Integer r116, List<String> r210, List<MonitorThreadThreshold> r211, List<String> r212) {
        return new CoroutinesMonitorConfig(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoroutinesMonitorConfig) == true) goto L8;
        return false;
    L8:
        CoroutinesMonitorConfig r101 = (CoroutinesMonitorConfig) r100;
        if (Intrinsics.areEqual(this.enableReportApm, r101.enableReportApm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableStackTrace, r101.enableStackTrace) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableClipStack, r101.enableClipStack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.waitThresholdMS, r101.waitThresholdMS) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mainExecThresholdMS, r101.mainExecThresholdMS) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ioExecThresholdMS, r101.ioExecThresholdMS) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.calculatePeriodMS, r101.calculatePeriodMS) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.monitorThreadList, r101.monitorThreadList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.monitorThreadThreshold, r101.monitorThreadThreshold) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.calcBlackList, r101.calcBlackList) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enableReportApm;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableStackTrace;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enableClipStack;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.waitThresholdMS;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.mainExecThresholdMS;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.ioExecThresholdMS;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.calculatePeriodMS;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.monitorThreadList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<MonitorThreadThreshold> r125 = this.monitorThreadThreshold;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.calcBlackList;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CoroutinesMonitorConfig(enableReportApm=" + this.enableReportApm + ", enableStackTrace=" + this.enableStackTrace + ", enableClipStack=" + this.enableClipStack + ", waitThresholdMS=" + this.waitThresholdMS + ", mainExecThresholdMS=" + this.mainExecThresholdMS + ", ioExecThresholdMS=" + this.ioExecThresholdMS + ", calculatePeriodMS=" + this.calculatePeriodMS + ", monitorThreadList=" + this.monitorThreadList + ", monitorThreadThreshold=" + this.monitorThreadThreshold + ", calcBlackList=" + this.calcBlackList + ')';
    }

    public final List<String> getCalcBlackList() {
        return this.calcBlackList;
    }

    public final Integer getCalculatePeriodMS() {
        return this.calculatePeriodMS;
    }

    public final Boolean getEnableClipStack() {
        return this.enableClipStack;
    }

    public final Boolean getEnableReportApm() {
        return this.enableReportApm;
    }

    public final Boolean getEnableStackTrace() {
        return this.enableStackTrace;
    }

    public final Integer getIoExecThresholdMS() {
        return this.ioExecThresholdMS;
    }

    public final Integer getMainExecThresholdMS() {
        return this.mainExecThresholdMS;
    }

    public final List<String> getMonitorThreadList() {
        return this.monitorThreadList;
    }

    public final List<MonitorThreadThreshold> getMonitorThreadThreshold() {
        return this.monitorThreadThreshold;
    }

    public final Integer getWaitThresholdMS() {
        return this.waitThresholdMS;
    }

    public CoroutinesMonitorConfig(Boolean r100, Boolean r101, Boolean r102, Integer r103, Integer r104, Integer r105, Integer r106, List<String> r107, List<MonitorThreadThreshold> r108, List<String> r110) {
        this.enableReportApm = r100;
        this.enableStackTrace = r101;
        this.enableClipStack = r102;
        this.waitThresholdMS = r103;
        this.mainExecThresholdMS = r104;
        this.ioExecThresholdMS = r105;
        this.calculatePeriodMS = r106;
        this.monitorThreadList = r107;
        this.monitorThreadThreshold = r108;
        this.calcBlackList = r110;
    }

    public /* synthetic */ CoroutinesMonitorConfig(Boolean r110, Boolean r111, Boolean r112, Integer r113, Integer r114, Integer r115, Integer r116, List r117, List r210, List r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = 0;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = 0;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r106 = 0;
    L30:
        List r107 = null;
        if ((r212 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r107 = r211;
    L42:
        this(r100, r101, r102, r103, r104, r105, r106, r108, r118, r107);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L30
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
