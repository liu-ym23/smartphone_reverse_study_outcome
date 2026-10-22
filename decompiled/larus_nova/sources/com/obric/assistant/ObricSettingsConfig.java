package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lcom/obric/assistant/ObricSettingsConfig;", "", "obricSettingsVersion", "", "settingsChangeMonitorEnabled", "", "settingsChangeMonitorMode", "updateSettingsWaitTime", "", "settingsCheckIntervalMinutes", "settingsPullIntervalMinutes", "settingsChangeMonitorTiming", "killAllProcess", "<init>", "(IZIJJJIZ)V", "getObricSettingsVersion", "()I", "getSettingsChangeMonitorEnabled", "()Z", "getSettingsChangeMonitorMode", "getUpdateSettingsWaitTime", "()J", "getSettingsCheckIntervalMinutes", "getSettingsPullIntervalMinutes", "getSettingsChangeMonitorTiming", "getKillAllProcess", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingsConfig {

    @SerializedName("kill_all_process")
    private final boolean killAllProcess;

    @SerializedName("obric_settings_version")
    private final int obricSettingsVersion;

    @SerializedName("enable_settings_change_monitor")
    private final boolean settingsChangeMonitorEnabled;

    @SerializedName("settings_change_monitor_mode")
    private final int settingsChangeMonitorMode;

    @SerializedName("settings_change_monitor_timing")
    private final int settingsChangeMonitorTiming;

    @SerializedName("settings_check_interval_in_minutes")
    private final long settingsCheckIntervalMinutes;

    @SerializedName("settings_pull_interval_in_minutes")
    private final long settingsPullIntervalMinutes;

    @SerializedName("update_settings_wait_time_in_millis")
    private final long updateSettingsWaitTime;

    public ObricSettingsConfig() {
        this(0, false, 0, 0, 0, 0, 0, false, 255, null);
    }

    public static /* synthetic */ ObricSettingsConfig copy$default(ObricSettingsConfig r110, int r111, boolean r112, int r113, long r114, long r115, long r210, int r211, boolean r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = r110.obricSettingsVersion;
    L7:
        if ((r213 & 2) == 0) goto L9;
        boolean r101 = r110.settingsChangeMonitorEnabled;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r102 = r110.settingsChangeMonitorMode;
    L15:
        if ((r213 & 8) == 0) goto L17;
        long r103 = r110.updateSettingsWaitTime;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r104 = r110.settingsCheckIntervalMinutes;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r105 = r110.settingsPullIntervalMinutes;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r116 = r110.settingsChangeMonitorTiming;
    L31:
        if ((r213 & 128) == 0) goto L33;
        boolean r106 = r110.killAllProcess;
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

    public final int component1() {
        return this.obricSettingsVersion;
    }

    public final boolean component2() {
        return this.settingsChangeMonitorEnabled;
    }

    public final int component3() {
        return this.settingsChangeMonitorMode;
    }

    public final long component4() {
        return this.updateSettingsWaitTime;
    }

    public final long component5() {
        return this.settingsCheckIntervalMinutes;
    }

    public final long component6() {
        return this.settingsPullIntervalMinutes;
    }

    public final int component7() {
        return this.settingsChangeMonitorTiming;
    }

    public final boolean component8() {
        return this.killAllProcess;
    }

    public final ObricSettingsConfig copy(int r110, boolean r111, int r112, long r113, long r114, long r210, int r211, boolean r212) {
        return new ObricSettingsConfig(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricSettingsConfig) == true) goto L8;
        return false;
    L8:
        ObricSettingsConfig r101 = (ObricSettingsConfig) r100;
        if (this.obricSettingsVersion == r101.obricSettingsVersion) goto L12;
        return false;
    L12:
        if (this.settingsChangeMonitorEnabled == r101.settingsChangeMonitorEnabled) goto L15;
        return false;
    L15:
        if (this.settingsChangeMonitorMode == r101.settingsChangeMonitorMode) goto L18;
        return false;
    L18:
        if (this.updateSettingsWaitTime == r101.updateSettingsWaitTime) goto L21;
        return false;
    L21:
        if (this.settingsCheckIntervalMinutes == r101.settingsCheckIntervalMinutes) goto L24;
        return false;
    L24:
        if (this.settingsPullIntervalMinutes == r101.settingsPullIntervalMinutes) goto L27;
        return false;
    L27:
        if (this.settingsChangeMonitorTiming == r101.settingsChangeMonitorTiming) goto L30;
        return false;
    L30:
        if (this.killAllProcess == r101.killAllProcess) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.obricSettingsVersion * 31;
        int r101 = 1231;
        if (this.settingsChangeMonitorEnabled == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.settingsChangeMonitorMode) * 31;
        long r104 = this.updateSettingsWaitTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.settingsCheckIntervalMinutes;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.settingsPullIntervalMinutes;
        int r109 = (((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.settingsChangeMonitorTiming) * 31;
        if (this.killAllProcess == true) goto L11;
        r101 = 1237;
    L11:
        return r109 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricSettingsConfig(obricSettingsVersion=" + this.obricSettingsVersion + ", settingsChangeMonitorEnabled=" + this.settingsChangeMonitorEnabled + ", settingsChangeMonitorMode=" + this.settingsChangeMonitorMode + ", updateSettingsWaitTime=" + this.updateSettingsWaitTime + ", settingsCheckIntervalMinutes=" + this.settingsCheckIntervalMinutes + ", settingsPullIntervalMinutes=" + this.settingsPullIntervalMinutes + ", settingsChangeMonitorTiming=" + this.settingsChangeMonitorTiming + ", killAllProcess=" + this.killAllProcess + ')';
    }

    public final boolean getKillAllProcess() {
        return this.killAllProcess;
    }

    public final int getObricSettingsVersion() {
        return this.obricSettingsVersion;
    }

    public final boolean getSettingsChangeMonitorEnabled() {
        return this.settingsChangeMonitorEnabled;
    }

    public final int getSettingsChangeMonitorMode() {
        return this.settingsChangeMonitorMode;
    }

    public final int getSettingsChangeMonitorTiming() {
        return this.settingsChangeMonitorTiming;
    }

    public final long getSettingsCheckIntervalMinutes() {
        return this.settingsCheckIntervalMinutes;
    }

    public final long getSettingsPullIntervalMinutes() {
        return this.settingsPullIntervalMinutes;
    }

    public final long getUpdateSettingsWaitTime() {
        return this.updateSettingsWaitTime;
    }

    public ObricSettingsConfig(int r100, boolean r101, int r102, long r103, long r104, long r105, int r110, boolean r111) {
        this.obricSettingsVersion = r100;
        this.settingsChangeMonitorEnabled = r101;
        this.settingsChangeMonitorMode = r102;
        this.updateSettingsWaitTime = r103;
        this.settingsCheckIntervalMinutes = r104;
        this.settingsPullIntervalMinutes = r105;
        this.settingsChangeMonitorTiming = r110;
        this.killAllProcess = r111;
    }

    public /* synthetic */ ObricSettingsConfig(int r110, boolean r111, int r112, long r113, long r114, long r210, int r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = 0;
    L6:
        boolean r101 = true;
        if ((r213 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r103 = 2;
    L15:
        if ((r213 & 8) == 0) goto L17;
        long r104 = 3000;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r105 = 10;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r106 = 60;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r115 = 1;
    L31:
        if ((r213 & 128) != 0) goto L34;
        r101 = r212;
    L34:
        this(r100, r102, r103, r104, r105, r106, r115, r101);
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
        r100 = r110;
        goto L6
    }
}
