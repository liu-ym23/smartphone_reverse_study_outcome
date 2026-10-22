package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J!\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\bHÆ\u0003JT\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorSilentCleanConfig;", "", "silentCleanEnable", "", "minUpdateVersionCode", "", "maxUpdateVersionCode", "crashCountToStrategiesMapConfig", "", "", "", "Lcom/larus/settings/provider/bootprotector/PreciseFixStategy;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getSilentCleanEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinUpdateVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxUpdateVersionCode", "getCrashCountToStrategiesMapConfig", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lcom/larus/settings/provider/bootprotector/BootProtectorSilentCleanConfig;", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorSilentCleanConfig {

    @SerializedName("crash_count_to_strategy_map_config")
    private final Map<String, List<PreciseFixStategy>> crashCountToStrategiesMapConfig;

    @SerializedName("max_update_version_code")
    private final Long maxUpdateVersionCode;

    @SerializedName("min_update_version_code")
    private final Long minUpdateVersionCode;

    @SerializedName("silent_clean_enable")
    private final Boolean silentCleanEnable;

    public BootProtectorSilentCleanConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectorSilentCleanConfig copy$default(BootProtectorSilentCleanConfig r100, Boolean r101, Long r102, Long r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.silentCleanEnable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.minUpdateVersionCode;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.maxUpdateVersionCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.crashCountToStrategiesMapConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Boolean component1() {
        return this.silentCleanEnable;
    }

    public final Long component2() {
        return this.minUpdateVersionCode;
    }

    public final Long component3() {
        return this.maxUpdateVersionCode;
    }

    public final Map<String, List<PreciseFixStategy>> component4() {
        return this.crashCountToStrategiesMapConfig;
    }

    public final BootProtectorSilentCleanConfig copy(Boolean r100, Long r101, Long r102, Map<String, ? extends List<PreciseFixStategy>> r103) {
        return new BootProtectorSilentCleanConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BootProtectorSilentCleanConfig) == true) goto L8;
        return false;
    L8:
        BootProtectorSilentCleanConfig r101 = (BootProtectorSilentCleanConfig) r100;
        if (Intrinsics.areEqual(this.silentCleanEnable, r101.silentCleanEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minUpdateVersionCode, r101.minUpdateVersionCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxUpdateVersionCode, r101.maxUpdateVersionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.crashCountToStrategiesMapConfig, r101.crashCountToStrategiesMapConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.silentCleanEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.minUpdateVersionCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.maxUpdateVersionCode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, List<PreciseFixStategy>> r110 = this.crashCountToStrategiesMapConfig;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "BootProtectorSilentCleanConfig(silentCleanEnable=" + this.silentCleanEnable + ", minUpdateVersionCode=" + this.minUpdateVersionCode + ", maxUpdateVersionCode=" + this.maxUpdateVersionCode + ", crashCountToStrategiesMapConfig=" + this.crashCountToStrategiesMapConfig + ')';
    }

    public final Map<String, List<PreciseFixStategy>> getCrashCountToStrategiesMapConfig() {
        return this.crashCountToStrategiesMapConfig;
    }

    public final Long getMaxUpdateVersionCode() {
        return this.maxUpdateVersionCode;
    }

    public final Long getMinUpdateVersionCode() {
        return this.minUpdateVersionCode;
    }

    public final Boolean getSilentCleanEnable() {
        return this.silentCleanEnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BootProtectorSilentCleanConfig(Boolean r100, Long r101, Long r102, Map<String, ? extends List<PreciseFixStategy>> r103) {
        this.silentCleanEnable = r100;
        this.minUpdateVersionCode = r101;
        this.maxUpdateVersionCode = r102;
        this.crashCountToStrategiesMapConfig = r103;
    }

    public /* synthetic */ BootProtectorSilentCleanConfig(Boolean r100, Long r101, Long r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = MapsKt.emptyMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
