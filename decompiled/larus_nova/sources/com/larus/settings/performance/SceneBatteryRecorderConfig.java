package com.larus.settings.performance;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "", "enableReport", "", "smoothDurationMillis", "", "reportIntervalMillis", "<init>", "(ZJJ)V", "getEnableReport", "()Z", "getSmoothDurationMillis", "()J", "getReportIntervalMillis", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneBatteryRecorderConfig {

    @SerializedName("enable_report")
    private final boolean enableReport;

    @SerializedName("report_interval_millis")
    private final long reportIntervalMillis;

    @SerializedName("smooth_duration_millis")
    private final long smoothDurationMillis;

    public SceneBatteryRecorderConfig() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ SceneBatteryRecorderConfig copy$default(SceneBatteryRecorderConfig r100, boolean r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enableReport;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.smoothDurationMillis;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.reportIntervalMillis;
    L11:
        boolean r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    public final boolean component1() {
        return this.enableReport;
    }

    public final long component2() {
        return this.smoothDurationMillis;
    }

    public final long component3() {
        return this.reportIntervalMillis;
    }

    public final SceneBatteryRecorderConfig copy(boolean r100, long r101, long r110) {
        return new SceneBatteryRecorderConfig(r100, r101, r110);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SceneBatteryRecorderConfig) == true) goto L8;
        return false;
    L8:
        SceneBatteryRecorderConfig r101 = (SceneBatteryRecorderConfig) r100;
        if (this.enableReport == r101.enableReport) goto L12;
        return false;
    L12:
        if (this.smoothDurationMillis == r101.smoothDurationMillis) goto L15;
        return false;
    L15:
        if (this.reportIntervalMillis == r101.reportIntervalMillis) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enableReport == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.smoothDurationMillis;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.reportIntervalMillis;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "SceneBatteryRecorderConfig(enableReport=" + this.enableReport + ", smoothDurationMillis=" + this.smoothDurationMillis + ", reportIntervalMillis=" + this.reportIntervalMillis + ')';
    }

    public final boolean getEnableReport() {
        return this.enableReport;
    }

    public final long getReportIntervalMillis() {
        return this.reportIntervalMillis;
    }

    public final long getSmoothDurationMillis() {
        return this.smoothDurationMillis;
    }

    public SceneBatteryRecorderConfig(boolean r100, long r101, long r102) {
        this.enableReport = r100;
        this.smoothDurationMillis = r101;
        this.reportIntervalMillis = r102;
    }

    public /* synthetic */ SceneBatteryRecorderConfig(boolean r100, long r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 5000;
    L8:
        long r105 = r101;
        if ((r103 & 4) == 0) goto L11;
        r102 = 3600000;
    L11:
        boolean r106 = r100;
        this(r106, r105, r102);
    }
}
