package com.larus.settings.performance;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003JW\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/settings/performance/SystemBatteryRecorderConfig;", "", "slardarReportEnabled", "", "teaReportEnabled", "galvanicAvgMinReportDurationMillis", "", "batteryPollIntervalMillis", "sceneDefaultConfig", "Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "sceneConfigMap", "", "", "<init>", "(ZZJJLcom/larus/settings/performance/SceneBatteryRecorderConfig;Ljava/util/Map;)V", "getSlardarReportEnabled", "()Z", "getTeaReportEnabled", "getGalvanicAvgMinReportDurationMillis", "()J", "getBatteryPollIntervalMillis", "getSceneDefaultConfig", "()Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "getSceneConfigMap", "()Ljava/util/Map;", "getSceneConfig", "scene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemBatteryRecorderConfig {

    @SerializedName("battery_poll_interval_millis")
    private final long batteryPollIntervalMillis;

    @SerializedName("galvanic_avg_min_report_duration_millis")
    private final long galvanicAvgMinReportDurationMillis;

    @SerializedName("scene_config_map")
    private final Map<String, SceneBatteryRecorderConfig> sceneConfigMap;

    @SerializedName("scene_default_config")
    private final SceneBatteryRecorderConfig sceneDefaultConfig;

    @SerializedName("slardar_report_enabled")
    private final boolean slardarReportEnabled;

    @SerializedName("tea_report_enabled")
    private final boolean teaReportEnabled;

    public SystemBatteryRecorderConfig() {
        this(false, false, 0, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SystemBatteryRecorderConfig copy$default(SystemBatteryRecorderConfig r100, boolean r110, boolean r111, long r112, long r113, SceneBatteryRecorderConfig r114, Map r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        boolean r101 = r100.slardarReportEnabled;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r102 = r100.teaReportEnabled;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.galvanicAvgMinReportDurationMillis;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r104 = r100.batteryPollIntervalMillis;
    L19:
        if ((r116 & 16) == 0) goto L21;
        SceneBatteryRecorderConfig r105 = r100.sceneDefaultConfig;
    L23:
        if ((r116 & 32) == 0) goto L25;
        Map r106 = r100.sceneConfigMap;
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
        return this.slardarReportEnabled;
    }

    public final boolean component2() {
        return this.teaReportEnabled;
    }

    public final long component3() {
        return this.galvanicAvgMinReportDurationMillis;
    }

    public final long component4() {
        return this.batteryPollIntervalMillis;
    }

    public final SceneBatteryRecorderConfig component5() {
        return this.sceneDefaultConfig;
    }

    public final Map<String, SceneBatteryRecorderConfig> component6() {
        return this.sceneConfigMap;
    }

    public final SystemBatteryRecorderConfig copy(boolean r110, boolean r111, long r112, long r113, SceneBatteryRecorderConfig r114, Map<String, SceneBatteryRecorderConfig> r115) {
        return new SystemBatteryRecorderConfig(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemBatteryRecorderConfig) == true) goto L8;
        return false;
    L8:
        SystemBatteryRecorderConfig r101 = (SystemBatteryRecorderConfig) r100;
        if (this.slardarReportEnabled == r101.slardarReportEnabled) goto L12;
        return false;
    L12:
        if (this.teaReportEnabled == r101.teaReportEnabled) goto L15;
        return false;
    L15:
        if (this.galvanicAvgMinReportDurationMillis == r101.galvanicAvgMinReportDurationMillis) goto L18;
        return false;
    L18:
        if (this.batteryPollIntervalMillis == r101.batteryPollIntervalMillis) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sceneDefaultConfig, r101.sceneDefaultConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sceneConfigMap, r101.sceneConfigMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.slardarReportEnabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.teaReportEnabled == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.galvanicAvgMinReportDurationMillis;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.batteryPollIntervalMillis;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        SceneBatteryRecorderConfig r108 = this.sceneDefaultConfig;
        int r109 = 0;
        if (r108 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r107 + r110) * 31;
        Map<String, SceneBatteryRecorderConfig> r112 = this.sceneConfigMap;
        if (r112 == null) goto L19;
        r109 = r112.hashCode();
    L19:
        return r111 + r109;
    L13:
        r110 = r108.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SystemBatteryRecorderConfig(slardarReportEnabled=" + this.slardarReportEnabled + ", teaReportEnabled=" + this.teaReportEnabled + ", galvanicAvgMinReportDurationMillis=" + this.galvanicAvgMinReportDurationMillis + ", batteryPollIntervalMillis=" + this.batteryPollIntervalMillis + ", sceneDefaultConfig=" + this.sceneDefaultConfig + ", sceneConfigMap=" + this.sceneConfigMap + ')';
    }

    public final long getBatteryPollIntervalMillis() {
        return this.batteryPollIntervalMillis;
    }

    public final long getGalvanicAvgMinReportDurationMillis() {
        return this.galvanicAvgMinReportDurationMillis;
    }

    public final Map<String, SceneBatteryRecorderConfig> getSceneConfigMap() {
        return this.sceneConfigMap;
    }

    public final SceneBatteryRecorderConfig getSceneDefaultConfig() {
        return this.sceneDefaultConfig;
    }

    public final boolean getSlardarReportEnabled() {
        return this.slardarReportEnabled;
    }

    public final boolean getTeaReportEnabled() {
        return this.teaReportEnabled;
    }

    public final SceneBatteryRecorderConfig getSceneConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, SceneBatteryRecorderConfig> r101 = this.sceneConfigMap;
        if (r101 == null) goto L6;
        SceneBatteryRecorderConfig r102 = r101.get(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        SceneBatteryRecorderConfig r103 = this.sceneDefaultConfig;
        if (r103 == null) goto L9;
        return r103;
    L9:
        return new SceneBatteryRecorderConfig(false, 0, 0, 7, null);
    }

    public SystemBatteryRecorderConfig(boolean r100, boolean r101, long r102, long r103, SceneBatteryRecorderConfig r104, Map<String, SceneBatteryRecorderConfig> r105) {
        this.slardarReportEnabled = r100;
        this.teaReportEnabled = r101;
        this.galvanicAvgMinReportDurationMillis = r102;
        this.batteryPollIntervalMillis = r103;
        this.sceneDefaultConfig = r104;
        this.sceneConfigMap = r105;
    }

    public /* synthetic */ SystemBatteryRecorderConfig(boolean r100, boolean r110, long r111, long r112, SceneBatteryRecorderConfig r113, Map r114, int r115, DefaultConstructorMarker r116) {
        boolean r101 = false;
        if ((r115 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r115 & 2) != 0) goto L11;
        r101 = r110;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r103 = 30000;
    L15:
        if ((r115 & 8) == 0) goto L17;
        long r104 = 5000;
    L19:
        if ((r115 & 16) == 0) goto L21;
        SceneBatteryRecorderConfig r105 = null;
    L23:
        if ((r115 & 32) == 0) goto L25;
        Map r106 = MapsKt.emptyMap();
    L26:
        this(r102, r101, r103, r104, r105, r106);
        return;
    L25:
        r106 = r114;
        goto L26
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L5:
        r102 = r100;
        goto L7
    }
}
