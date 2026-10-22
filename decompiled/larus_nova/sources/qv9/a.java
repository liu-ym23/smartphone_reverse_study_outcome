package qv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00064"}, d2 = {"Lcom/larus/settings/provider/perf/BDTrackerPerfConfig;", "", "flushAppLogWhenBackGround", "", "eventFilterEnable", "eventSamplingEnable", "newMonitorEnabled", "defaultSentryEnabled", "defaultSentryColdStartSamplingRate", "", "defaultColdStartReportDelay", "", "defaultReportInterval", "packByLengthEnabled", "realtimeEventOptEnabled", "packMultiQueryEnabled", "packMaxQueryTimes", "<init>", "(ZZZZZIJJZZZI)V", "getFlushAppLogWhenBackGround", "()Z", "getEventFilterEnable", "getEventSamplingEnable", "getNewMonitorEnabled", "getDefaultSentryEnabled", "getDefaultSentryColdStartSamplingRate", "()I", "getDefaultColdStartReportDelay", "()J", "getDefaultReportInterval", "getPackByLengthEnabled", "getRealtimeEventOptEnabled", "getPackMultiQueryEnabled", "getPackMaxQueryTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("bdtracker_default_cold_start_report_delay")
    private final long defaultColdStartReportDelay;

    @SerializedName("bdtracker_default_report_interval")
    private final long defaultReportInterval;

    @SerializedName("bdtracker_default_sentry_cold_start_samplingRate")
    private final int defaultSentryColdStartSamplingRate;

    @SerializedName("bdtracker_default_sentry_enabled")
    private final boolean defaultSentryEnabled;

    @SerializedName("event_filter_enable")
    private final boolean eventFilterEnable;

    @SerializedName("event_sampling_enable")
    private final boolean eventSamplingEnable;

    @SerializedName("flush_app_log_when_background")
    private final boolean flushAppLogWhenBackGround;

    @SerializedName("bdtracker_new_monitor_enabled")
    private final boolean newMonitorEnabled;

    @SerializedName("bdtracker_pack_by_length_enabled")
    private final boolean packByLengthEnabled;

    @SerializedName("bdtracker_pack_max_query_times")
    private final int packMaxQueryTimes;

    @SerializedName("bdtracker_pack_multi_query_enabled")
    private final boolean packMultiQueryEnabled;

    @SerializedName("bdtracker_realtime_event_opt_enabled")
    private final boolean realtimeEventOptEnabled;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.flushAppLogWhenBackGround == r101.flushAppLogWhenBackGround) goto L12;
        return false;
    L12:
        if (this.eventFilterEnable == r101.eventFilterEnable) goto L15;
        return false;
    L15:
        if (this.eventSamplingEnable == r101.eventSamplingEnable) goto L18;
        return false;
    L18:
        if (this.newMonitorEnabled == r101.newMonitorEnabled) goto L21;
        return false;
    L21:
        if (this.defaultSentryEnabled == r101.defaultSentryEnabled) goto L24;
        return false;
    L24:
        if (this.defaultSentryColdStartSamplingRate == r101.defaultSentryColdStartSamplingRate) goto L27;
        return false;
    L27:
        if (this.defaultColdStartReportDelay == r101.defaultColdStartReportDelay) goto L30;
        return false;
    L30:
        if (this.defaultReportInterval == r101.defaultReportInterval) goto L33;
        return false;
    L33:
        if (this.packByLengthEnabled == r101.packByLengthEnabled) goto L36;
        return false;
    L36:
        if (this.realtimeEventOptEnabled == r101.realtimeEventOptEnabled) goto L39;
        return false;
    L39:
        if (this.packMultiQueryEnabled == r101.packMultiQueryEnabled) goto L42;
        return false;
    L42:
        if (this.packMaxQueryTimes == r101.packMaxQueryTimes) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.flushAppLogWhenBackGround == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.eventFilterEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.eventSamplingEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.newMonitorEnabled == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.defaultSentryEnabled == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (((r108 + r109) * 31) + this.defaultSentryColdStartSamplingRate) * 31;
        long r111 = this.defaultColdStartReportDelay;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.defaultReportInterval;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        if (this.packByLengthEnabled == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.realtimeEventOptEnabled == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.packMultiQueryEnabled == true) goto L35;
        r100 = 1237;
    L35:
        return ((r118 + r100) * 31) + this.packMaxQueryTimes;
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BDTrackerPerfConfig(flushAppLogWhenBackGround=" + this.flushAppLogWhenBackGround + ", eventFilterEnable=" + this.eventFilterEnable + ", eventSamplingEnable=" + this.eventSamplingEnable + ", newMonitorEnabled=" + this.newMonitorEnabled + ", defaultSentryEnabled=" + this.defaultSentryEnabled + ", defaultSentryColdStartSamplingRate=" + this.defaultSentryColdStartSamplingRate + ", defaultColdStartReportDelay=" + this.defaultColdStartReportDelay + ", defaultReportInterval=" + this.defaultReportInterval + ", packByLengthEnabled=" + this.packByLengthEnabled + ", realtimeEventOptEnabled=" + this.realtimeEventOptEnabled + ", packMultiQueryEnabled=" + this.packMultiQueryEnabled + ", packMaxQueryTimes=" + this.packMaxQueryTimes + ')';
    }

    public final long a() {
        return this.defaultColdStartReportDelay;
    }

    public final long b() {
        return this.defaultReportInterval;
    }

    public final int c() {
        return this.defaultSentryColdStartSamplingRate;
    }

    public final boolean d() {
        return this.defaultSentryEnabled;
    }

    public final boolean e() {
        return this.eventFilterEnable;
    }

    public final boolean f() {
        return this.eventSamplingEnable;
    }

    public final boolean g() {
        return this.flushAppLogWhenBackGround;
    }

    public final boolean h() {
        return this.newMonitorEnabled;
    }

    public final boolean i() {
        return this.packByLengthEnabled;
    }

    public final int j() {
        return this.packMaxQueryTimes;
    }

    public final boolean k() {
        return this.packMultiQueryEnabled;
    }

    public final boolean l() {
        return this.realtimeEventOptEnabled;
    }

    public a(int r100) {
        this.flushAppLogWhenBackGround = false;
        this.eventFilterEnable = false;
        this.eventSamplingEnable = false;
        this.newMonitorEnabled = false;
        this.defaultSentryEnabled = false;
        this.defaultSentryColdStartSamplingRate = 100;
        this.defaultColdStartReportDelay = 5000;
        this.defaultReportInterval = 60000;
        this.packByLengthEnabled = false;
        this.realtimeEventOptEnabled = false;
        this.packMultiQueryEnabled = false;
        this.packMaxQueryTimes = 10;
    }
}
