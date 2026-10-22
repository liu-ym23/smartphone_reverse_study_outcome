package com.obric.performance.power.monitor.cpu.exception;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import lna.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J±\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001J\u0013\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u000eHÖ\u0001J\t\u0010B\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*¨\u0006C"}, d2 = {"Lcom/obric/performance/power/monitor/cpu/exception/CPUExceptionDiagnosisConfig;", "", "enable", "", "aiagentEnable", "frontSampledRate", "", "backgroundSampledRate", "periodInterval", "", "measureCpuTime", "frontExceptionRatio", "backgroundExceptionRatio", "topDumpCount", "", "threadStackSleepMaxRetry", "dumpIntervalMillis", "stackFramePromotionEnabled", "stackFrameSkipClassPrefixes", "", "", "threadFilterExactNames", "threadFilterNamePrefixes", "<init>", "(ZZFFJJFFIIJZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnable", "()Z", "getAiagentEnable", "getFrontSampledRate", "()F", "getBackgroundSampledRate", "getPeriodInterval", "()J", "getMeasureCpuTime", "getFrontExceptionRatio", "getBackgroundExceptionRatio", "getTopDumpCount", "()I", "getThreadStackSleepMaxRetry", "getDumpIntervalMillis", "getStackFramePromotionEnabled", "getStackFrameSkipClassPrefixes", "()Ljava/util/List;", "getThreadFilterExactNames", "getThreadFilterNamePrefixes", "cpuExceptionTime", "isBackground", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CPUExceptionDiagnosisConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnable;

    @SerializedName("background_exception_ratio")
    private final float backgroundExceptionRatio;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("dump_interval_millis")
    private final long dumpIntervalMillis;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("front_exception_ratio")
    private final float frontExceptionRatio;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("measure_cpu_time_millis")
    private final long measureCpuTime;

    @SerializedName("period_interval_millis")
    private final long periodInterval;

    @SerializedName("stack_frame_promotion_enabled")
    private final boolean stackFramePromotionEnabled;

    @SerializedName("stack_frame_skip_class_prefixes")
    private final List<String> stackFrameSkipClassPrefixes;

    @SerializedName("thread_filter_exact_names")
    private final List<String> threadFilterExactNames;

    @SerializedName("thread_filter_name_prefixes")
    private final List<String> threadFilterNamePrefixes;

    @SerializedName("thread_stack_sleep_max_retry")
    private final int threadStackSleepMaxRetry;

    @SerializedName("top_dump_count")
    private final int topDumpCount;

    public CPUExceptionDiagnosisConfig() {
        this(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CPUExceptionDiagnosisConfig copy$default(CPUExceptionDiagnosisConfig r110, boolean r111, boolean r112, float r113, float r210, long r211, long r212, float r213, float r214, int r215, int r216, long r217, boolean r310, List r311, List r312, List r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        boolean r100 = r110.enable;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = r110.aiagentEnable;
    L11:
        if ((r314 & 4) == 0) goto L13;
        float r102 = r110.frontSampledRate;
    L15:
        if ((r314 & 8) == 0) goto L17;
        float r103 = r110.backgroundSampledRate;
    L19:
        if ((r314 & 16) == 0) goto L21;
        long r104 = r110.periodInterval;
    L23:
        if ((r314 & 32) == 0) goto L25;
        long r105 = r110.measureCpuTime;
    L27:
        if ((r314 & 64) == 0) goto L29;
        float r114 = r110.frontExceptionRatio;
    L31:
        if ((r314 & 128) == 0) goto L33;
        float r115 = r110.backgroundExceptionRatio;
    L35:
        if ((r314 & 256) == 0) goto L37;
        int r116 = r110.topDumpCount;
    L39:
        if ((r314 & 512) == 0) goto L41;
        int r117 = r110.threadStackSleepMaxRetry;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        long r118 = r110.dumpIntervalMillis;
    L46:
        long r218 = r118;
        if ((r314 & 2048) == 0) goto L49;
        boolean r119 = r110.stackFramePromotionEnabled;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        List r120 = r110.stackFrameSkipClassPrefixes;
    L54:
        List r316 = r120;
        if ((r314 & 8192) == 0) goto L57;
        List r121 = r110.threadFilterExactNames;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        List r106 = r110.threadFilterNamePrefixes;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r218, r119, r316, r121, r106);
    L61:
        r106 = r313;
        goto L63
    L57:
        r121 = r312;
        goto L59
    L53:
        r120 = r311;
        goto L54
    L49:
        r119 = r310;
        goto L51
    L45:
        r118 = r217;
        goto L46
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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
        return this.enable;
    }

    public final int component10() {
        return this.threadStackSleepMaxRetry;
    }

    public final long component11() {
        return this.dumpIntervalMillis;
    }

    public final boolean component12() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> component13() {
        return this.stackFrameSkipClassPrefixes;
    }

    public final List<String> component14() {
        return this.threadFilterExactNames;
    }

    public final List<String> component15() {
        return this.threadFilterNamePrefixes;
    }

    public final boolean component2() {
        return this.aiagentEnable;
    }

    public final float component3() {
        return this.frontSampledRate;
    }

    public final float component4() {
        return this.backgroundSampledRate;
    }

    public final long component5() {
        return this.periodInterval;
    }

    public final long component6() {
        return this.measureCpuTime;
    }

    public final float component7() {
        return this.frontExceptionRatio;
    }

    public final float component8() {
        return this.backgroundExceptionRatio;
    }

    public final int component9() {
        return this.topDumpCount;
    }

    public final CPUExceptionDiagnosisConfig copy(boolean r210, boolean r211, float r212, float r213, long r214, long r215, float r216, float r310, int r311, int r312, long r313, boolean r314, List<String> r315, List<String> r316, List<String> r317) {
        Intrinsics.checkNotNullParameter(r315, "stackFrameSkipClassPrefixes");
        Intrinsics.checkNotNullParameter(r316, "threadFilterExactNames");
        Intrinsics.checkNotNullParameter(r317, "threadFilterNamePrefixes");
        return new CPUExceptionDiagnosisConfig(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CPUExceptionDiagnosisConfig) == true) goto L8;
        return false;
    L8:
        CPUExceptionDiagnosisConfig r101 = (CPUExceptionDiagnosisConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.aiagentEnable == r101.aiagentEnable) goto L15;
        return false;
    L15:
        if (Float.compare(this.frontSampledRate, r101.frontSampledRate) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.backgroundSampledRate, r101.backgroundSampledRate) == 0) goto L21;
        return false;
    L21:
        if (this.periodInterval == r101.periodInterval) goto L24;
        return false;
    L24:
        if (this.measureCpuTime == r101.measureCpuTime) goto L27;
        return false;
    L27:
        if (Float.compare(this.frontExceptionRatio, r101.frontExceptionRatio) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.backgroundExceptionRatio, r101.backgroundExceptionRatio) == 0) goto L33;
        return false;
    L33:
        if (this.topDumpCount == r101.topDumpCount) goto L36;
        return false;
    L36:
        if (this.threadStackSleepMaxRetry == r101.threadStackSleepMaxRetry) goto L39;
        return false;
    L39:
        if (this.dumpIntervalMillis == r101.dumpIntervalMillis) goto L42;
        return false;
    L42:
        if (this.stackFramePromotionEnabled == r101.stackFramePromotionEnabled) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.stackFrameSkipClassPrefixes, r101.stackFrameSkipClassPrefixes) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.threadFilterExactNames, r101.threadFilterExactNames) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.threadFilterNamePrefixes, r101.threadFilterNamePrefixes) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.aiagentEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((r102 + r103) * 31) + Float.floatToIntBits(this.frontSampledRate)) * 31) + Float.floatToIntBits(this.backgroundSampledRate)) * 31;
        long r105 = this.periodInterval;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.measureCpuTime;
        int r108 = (((((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Float.floatToIntBits(this.frontExceptionRatio)) * 31) + Float.floatToIntBits(this.backgroundExceptionRatio)) * 31) + this.topDumpCount) * 31) + this.threadStackSleepMaxRetry) * 31;
        long r109 = this.dumpIntervalMillis;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.stackFramePromotionEnabled == true) goto L15;
        r100 = 1237;
    L15:
        return ((((((r110 + r100) * 31) + this.stackFrameSkipClassPrefixes.hashCode()) * 31) + this.threadFilterExactNames.hashCode()) * 31) + this.threadFilterNamePrefixes.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CPUExceptionDiagnosisConfig(enable=" + this.enable + ", aiagentEnable=" + this.aiagentEnable + ", frontSampledRate=" + this.frontSampledRate + ", backgroundSampledRate=" + this.backgroundSampledRate + ", periodInterval=" + this.periodInterval + ", measureCpuTime=" + this.measureCpuTime + ", frontExceptionRatio=" + this.frontExceptionRatio + ", backgroundExceptionRatio=" + this.backgroundExceptionRatio + ", topDumpCount=" + this.topDumpCount + ", threadStackSleepMaxRetry=" + this.threadStackSleepMaxRetry + ", dumpIntervalMillis=" + this.dumpIntervalMillis + ", stackFramePromotionEnabled=" + this.stackFramePromotionEnabled + ", stackFrameSkipClassPrefixes=" + this.stackFrameSkipClassPrefixes + ", threadFilterExactNames=" + this.threadFilterExactNames + ", threadFilterNamePrefixes=" + this.threadFilterNamePrefixes + ')';
    }

    public final boolean getAiagentEnable() {
        return this.aiagentEnable;
    }

    public final float getBackgroundExceptionRatio() {
        return this.backgroundExceptionRatio;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }

    public final long getDumpIntervalMillis() {
        return this.dumpIntervalMillis;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getFrontExceptionRatio() {
        return this.frontExceptionRatio;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final long getMeasureCpuTime() {
        return this.measureCpuTime;
    }

    public final long getPeriodInterval() {
        return this.periodInterval;
    }

    public final boolean getStackFramePromotionEnabled() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> getStackFrameSkipClassPrefixes() {
        return this.stackFrameSkipClassPrefixes;
    }

    public final List<String> getThreadFilterExactNames() {
        return this.threadFilterExactNames;
    }

    public final List<String> getThreadFilterNamePrefixes() {
        return this.threadFilterNamePrefixes;
    }

    public final int getThreadStackSleepMaxRetry() {
        return this.threadStackSleepMaxRetry;
    }

    public final int getTopDumpCount() {
        return this.topDumpCount;
    }

    public final long cpuExceptionTime(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = this.backgroundExceptionRatio;
    L6:
        return (long) (this.measureCpuTime * RangesKt.coerceIn(r101, 0.0f, 1.0f));
    L4:
        r101 = this.frontExceptionRatio;
        goto L6
    }

    public CPUExceptionDiagnosisConfig(boolean r100, boolean r101, float r102, float r110, long r111, long r112, float r113, float r114, int r115, int r116, long r117, boolean r210, List<String> r211, List<String> r212, List<String> r213) {
        Intrinsics.checkNotNullParameter(r211, "stackFrameSkipClassPrefixes");
        Intrinsics.checkNotNullParameter(r212, "threadFilterExactNames");
        Intrinsics.checkNotNullParameter(r213, "threadFilterNamePrefixes");
        this.enable = r100;
        this.aiagentEnable = r101;
        this.frontSampledRate = r102;
        this.backgroundSampledRate = r110;
        this.periodInterval = r111;
        this.measureCpuTime = r112;
        this.frontExceptionRatio = r113;
        this.backgroundExceptionRatio = r114;
        this.topDumpCount = r115;
        this.threadStackSleepMaxRetry = r116;
        this.dumpIntervalMillis = r117;
        this.stackFramePromotionEnabled = r210;
        this.stackFrameSkipClassPrefixes = r211;
        this.threadFilterExactNames = r212;
        this.threadFilterNamePrefixes = r213;
    }

    public CPUExceptionDiagnosisConfig(boolean r110, boolean r111, float r210, float r211, long r212, long r213, float r214, float r215, int r216, int r217, long r310, boolean r311, List r312, List r313, List r314, int r315, DefaultConstructorMarker r316) {
        boolean r100 = false;
        if ((r315 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r315 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        float r102 = 0.0f;
        if ((r315 & 4) == 0) goto L13;
        float r103 = 0.0f;
    L15:
        if ((r315 & 8) != 0) goto L19;
        r102 = r211;
    L19:
        if ((r315 & 16) == 0) goto L21;
        long r104 = 30000;
    L23:
        if ((r315 & 32) == 0) goto L25;
        long r105 = 2000;
    L27:
        if ((r315 & 64) == 0) goto L29;
        float r106 = 0.03f;
    L31:
        if ((r315 & 128) == 0) goto L33;
        float r112 = 0.01f;
    L34:
        int r113 = 5;
        if ((r315 & 256) == 0) goto L37;
        int r114 = 5;
    L39:
        if ((r315 & 512) != 0) goto L43;
        r113 = r217;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        long r115 = 20;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        boolean r116 = true;
    L50:
        boolean r317 = r116;
        if ((r315 & 4096) == 0) goto L53;
        List r117 = i.f510057a;
    L54:
        List r118 = r117;
        if ((r315 & 8192) == 0) goto L57;
        List r119 = i.f510058b;
    L59:
        if ((r315 & 16384) == 0) goto L61;
        List r107 = i.f510059c;
    L62:
        this(r101, r100, r103, r102, r104, r105, r106, r112, r114, r113, r115, r317, r118, r119, r107);
        return;
    L61:
        r107 = r314;
        goto L62
    L57:
        r119 = r313;
        goto L59
    L53:
        r117 = r312;
        goto L54
    L49:
        r116 = r311;
        goto L50
    L45:
        r115 = r310;
        goto L47
    L37:
        r114 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L34
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L13:
        r103 = r210;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
