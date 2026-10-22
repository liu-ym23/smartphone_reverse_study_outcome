package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\nHÆ\u0003Jr\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006)"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorConfig;", "", "bootProtectorEnable", "", "crashLivingTimeThrehold", "", "anrMonitorEnable", "anrMonitorLevel", "crashCountThrehold", "clearCacheWhiteList", "", "", "preciseFixStrategies", "Lcom/larus/settings/provider/bootprotector/PreciseFixStategy;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getBootProtectorEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCrashLivingTimeThrehold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnrMonitorEnable", "getAnrMonitorLevel", "getCrashCountThrehold", "getClearCacheWhiteList", "()Ljava/util/List;", "getPreciseFixStrategies", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/larus/settings/provider/bootprotector/BootProtectorConfig;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorConfig {

    @SerializedName("anr_monitor_enable")
    private final Boolean anrMonitorEnable;

    @SerializedName("anr_monitor_level")
    private final Integer anrMonitorLevel;

    @SerializedName("bootprotector_enable")
    private final Boolean bootProtectorEnable;

    @SerializedName("clear_cache_white_list")
    private final List<String> clearCacheWhiteList;

    @SerializedName("crash_count_threhold")
    private final Integer crashCountThrehold;

    @SerializedName("crash_livingtime_threhold")
    private final Integer crashLivingTimeThrehold;

    @SerializedName("precise_fix_strategies")
    private final List<PreciseFixStategy> preciseFixStrategies;

    public BootProtectorConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectorConfig copy$default(BootProtectorConfig r100, Boolean r101, Integer r102, Boolean r103, Integer r104, Integer r110, List r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.bootProtectorEnable;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.crashLivingTimeThrehold;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.anrMonitorEnable;
    L11:
        Boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.anrMonitorLevel;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.crashCountThrehold;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.clearCacheWhiteList;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.preciseFixStrategies;
    L23:
        Boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Boolean component1() {
        return this.bootProtectorEnable;
    }

    public final Integer component2() {
        return this.crashLivingTimeThrehold;
    }

    public final Boolean component3() {
        return this.anrMonitorEnable;
    }

    public final Integer component4() {
        return this.anrMonitorLevel;
    }

    public final Integer component5() {
        return this.crashCountThrehold;
    }

    public final List<String> component6() {
        return this.clearCacheWhiteList;
    }

    public final List<PreciseFixStategy> component7() {
        return this.preciseFixStrategies;
    }

    public final BootProtectorConfig copy(Boolean r110, Integer r111, Boolean r112, Integer r113, Integer r114, List<String> r115, List<PreciseFixStategy> r116) {
        return new BootProtectorConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BootProtectorConfig) == true) goto L8;
        return false;
    L8:
        BootProtectorConfig r101 = (BootProtectorConfig) r100;
        if (Intrinsics.areEqual(this.bootProtectorEnable, r101.bootProtectorEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.crashLivingTimeThrehold, r101.crashLivingTimeThrehold) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.anrMonitorEnable, r101.anrMonitorEnable) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.anrMonitorLevel, r101.anrMonitorLevel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.crashCountThrehold, r101.crashCountThrehold) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clearCacheWhiteList, r101.clearCacheWhiteList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.preciseFixStrategies, r101.preciseFixStrategies) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.bootProtectorEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.crashLivingTimeThrehold;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.anrMonitorEnable;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.anrMonitorLevel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.crashCountThrehold;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.clearCacheWhiteList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<PreciseFixStategy> r119 = this.preciseFixStrategies;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "BootProtectorConfig(bootProtectorEnable=" + this.bootProtectorEnable + ", crashLivingTimeThrehold=" + this.crashLivingTimeThrehold + ", anrMonitorEnable=" + this.anrMonitorEnable + ", anrMonitorLevel=" + this.anrMonitorLevel + ", crashCountThrehold=" + this.crashCountThrehold + ", clearCacheWhiteList=" + this.clearCacheWhiteList + ", preciseFixStrategies=" + this.preciseFixStrategies + ')';
    }

    public final Boolean getAnrMonitorEnable() {
        return this.anrMonitorEnable;
    }

    public final Integer getAnrMonitorLevel() {
        return this.anrMonitorLevel;
    }

    public final Boolean getBootProtectorEnable() {
        return this.bootProtectorEnable;
    }

    public final List<String> getClearCacheWhiteList() {
        return this.clearCacheWhiteList;
    }

    public final Integer getCrashCountThrehold() {
        return this.crashCountThrehold;
    }

    public final Integer getCrashLivingTimeThrehold() {
        return this.crashLivingTimeThrehold;
    }

    public final List<PreciseFixStategy> getPreciseFixStrategies() {
        return this.preciseFixStrategies;
    }

    public BootProtectorConfig(Boolean r100, Integer r101, Boolean r102, Integer r103, Integer r104, List<String> r105, List<PreciseFixStategy> r106) {
        this.bootProtectorEnable = r100;
        this.crashLivingTimeThrehold = r101;
        this.anrMonitorEnable = r102;
        this.anrMonitorLevel = r103;
        this.crashCountThrehold = r104;
        this.clearCacheWhiteList = r105;
        this.preciseFixStrategies = r106;
    }

    public /* synthetic */ BootProtectorConfig(Boolean r100, Integer r101, Boolean r102, Integer r103, Integer r110, List r111, List r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        Integer r115 = r101;
        if ((r113 & 4) == 0) goto L11;
        r102 = Boolean.FALSE;
    L11:
        Boolean r104 = r102;
        if ((r113 & 8) == 0) goto L14;
        r103 = 5;
    L14:
        Integer r105 = r103;
        if ((r113 & 16) == 0) goto L17;
        r110 = 0;
    L17:
        Integer r106 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = CollectionsKt.emptyList();
    L20:
        List r107 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = CollectionsKt.emptyList();
    L23:
        Boolean r108 = r100;
        this(r108, r115, r104, r105, r106, r107, r112);
    }
}
