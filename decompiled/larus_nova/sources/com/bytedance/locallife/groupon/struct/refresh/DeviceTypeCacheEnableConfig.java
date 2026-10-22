package com.bytedance.locallife.groupon.struct.refresh;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/DeviceTypeCacheEnableConfig;", "", "pythiaLevelConfig", "", "thresholdHigh", "", "thresholdMedium", "highConfig", "Lcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;", "mediumConfig", "lowConfig", "(IFFLcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;Lcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;Lcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;)V", "getHighConfig", "()Lcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;", "getLowConfig", "getMediumConfig", "getPythiaLevelConfig", "()I", "getThresholdHigh", "()F", "getThresholdMedium", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DeviceTypeCacheEnableConfig {

    @SerializedName("high_device_config")
    private final PrefetchConfig highConfig;

    @SerializedName("low_device_config")
    private final PrefetchConfig lowConfig;

    @SerializedName("medium_device_config")
    private final PrefetchConfig mediumConfig;

    @SerializedName("pythia_level_config")
    private final int pythiaLevelConfig;

    @SerializedName("threshold_high")
    private final float thresholdHigh;

    @SerializedName("threshold_medium")
    private final float thresholdMedium;

    public DeviceTypeCacheEnableConfig() {
        this(0, 0.0f, 0.0f, null, null, null, 63, null);
    }

    public static /* synthetic */ DeviceTypeCacheEnableConfig copy$default(DeviceTypeCacheEnableConfig r100, int r101, float r102, float r103, PrefetchConfig r104, PrefetchConfig r105, PrefetchConfig r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.pythiaLevelConfig;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.thresholdHigh;
    L8:
        float r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.thresholdMedium;
    L11:
        float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.highConfig;
    L14:
        PrefetchConfig r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.mediumConfig;
    L17:
        PrefetchConfig r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.lowConfig;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.pythiaLevelConfig;
    }

    public final float component2() {
        return this.thresholdHigh;
    }

    public final float component3() {
        return this.thresholdMedium;
    }

    public final PrefetchConfig component4() {
        return this.highConfig;
    }

    public final PrefetchConfig component5() {
        return this.mediumConfig;
    }

    public final PrefetchConfig component6() {
        return this.lowConfig;
    }

    public final DeviceTypeCacheEnableConfig copy(int r100, float r110, float r111, PrefetchConfig r112, PrefetchConfig r113, PrefetchConfig r114) {
        Intrinsics.checkNotNullParameter(r112, "highConfig");
        Intrinsics.checkNotNullParameter(r113, "mediumConfig");
        Intrinsics.checkNotNullParameter(r114, "lowConfig");
        return new DeviceTypeCacheEnableConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeviceTypeCacheEnableConfig) == true) goto L8;
        return false;
    L8:
        DeviceTypeCacheEnableConfig r101 = (DeviceTypeCacheEnableConfig) r100;
        if (this.pythiaLevelConfig == r101.pythiaLevelConfig) goto L12;
        return false;
    L12:
        if (Float.compare(this.thresholdHigh, r101.thresholdHigh) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.thresholdMedium, r101.thresholdMedium) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highConfig, r101.highConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediumConfig, r101.mediumConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lowConfig, r101.lowConfig) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.pythiaLevelConfig * 31) + Float.floatToIntBits(this.thresholdHigh)) * 31) + Float.floatToIntBits(this.thresholdMedium)) * 31) + this.highConfig.hashCode()) * 31) + this.mediumConfig.hashCode()) * 31) + this.lowConfig.hashCode();
    }

    public String toString() {
        return "DeviceTypeCacheEnableConfig(pythiaLevelConfig=" + this.pythiaLevelConfig + ", thresholdHigh=" + this.thresholdHigh + ", thresholdMedium=" + this.thresholdMedium + ", highConfig=" + this.highConfig + ", mediumConfig=" + this.mediumConfig + ", lowConfig=" + this.lowConfig + ')';
    }

    public final PrefetchConfig getHighConfig() {
        return this.highConfig;
    }

    public final PrefetchConfig getLowConfig() {
        return this.lowConfig;
    }

    public final PrefetchConfig getMediumConfig() {
        return this.mediumConfig;
    }

    public final int getPythiaLevelConfig() {
        return this.pythiaLevelConfig;
    }

    public final float getThresholdHigh() {
        return this.thresholdHigh;
    }

    public final float getThresholdMedium() {
        return this.thresholdMedium;
    }

    public DeviceTypeCacheEnableConfig(int r100, float r101, float r102, PrefetchConfig r103, PrefetchConfig r104, PrefetchConfig r105) {
        Intrinsics.checkNotNullParameter(r103, "highConfig");
        Intrinsics.checkNotNullParameter(r104, "mediumConfig");
        Intrinsics.checkNotNullParameter(r105, "lowConfig");
        this.pythiaLevelConfig = r100;
        this.thresholdHigh = r101;
        this.thresholdMedium = r102;
        this.highConfig = r103;
        this.mediumConfig = r104;
        this.lowConfig = r105;
    }

    public /* synthetic */ DeviceTypeCacheEnableConfig(int r100, float r101, float r102, PrefetchConfig r103, PrefetchConfig r110, PrefetchConfig r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r112 & 2) == 0) goto L8;
        float r114 = 35.60426f;
    L10:
        if ((r112 & 4) == 0) goto L12;
        float r104 = 20.146318f;
    L14:
        if ((r112 & 8) == 0) goto L16;
        r103 = new PrefetchConfig(false, false, 3, null);
    L16:
        PrefetchConfig r105 = r103;
        if ((r112 & 16) == 0) goto L19;
        r110 = new PrefetchConfig(false, false, 3, null);
    L19:
        PrefetchConfig r106 = r110;
        if ((r112 & 32) == 0) goto L22;
        r111 = new PrefetchConfig(false, false, 3, null);
    L22:
        int r107 = r100;
        float r108 = r114;
        float r115 = r104;
        this(r107, r108, r115, r105, r106, r111);
        return;
    L12:
        r104 = r102;
        goto L14
    L8:
        r114 = r101;
        goto L10
    }
}
