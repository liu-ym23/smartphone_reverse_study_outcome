package com.larus.dora.impl.core.settingsconfig;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/core/settingsconfig/DoraVolumeAdaptationConfig;", "", "maxGain", "", "maxVolumeLevelRange", "", "maxIncDb", "maxDecDb", "defaultState", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)V", "getMaxGain", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMaxVolumeLevelRange", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxIncDb", "getMaxDecDb", "getDefaultState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/larus/dora/impl/core/settingsconfig/DoraVolumeAdaptationConfig;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraVolumeAdaptationConfig {

    @SerializedName("adaptation_default")
    private final Boolean defaultState;

    @SerializedName("adaptation_max_dec_db")
    private final Float maxDecDb;

    @SerializedName("adaptation_max_gain")
    private final Float maxGain;

    @SerializedName("adaptation_max_inc_db")
    private final Float maxIncDb;

    @SerializedName("adaptation_max_volume_level_range")
    private final Integer maxVolumeLevelRange;

    public DoraVolumeAdaptationConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DoraVolumeAdaptationConfig copy$default(DoraVolumeAdaptationConfig r100, Float r101, Integer r102, Float r103, Float r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.maxGain;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxVolumeLevelRange;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.maxIncDb;
    L11:
        Float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.maxDecDb;
    L14:
        Float r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.defaultState;
    L17:
        Float r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Float component1() {
        return this.maxGain;
    }

    public final Integer component2() {
        return this.maxVolumeLevelRange;
    }

    public final Float component3() {
        return this.maxIncDb;
    }

    public final Float component4() {
        return this.maxDecDb;
    }

    public final Boolean component5() {
        return this.defaultState;
    }

    public final DoraVolumeAdaptationConfig copy(Float r100, Integer r101, Float r110, Float r111, Boolean r112) {
        return new DoraVolumeAdaptationConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraVolumeAdaptationConfig) == true) goto L8;
        return false;
    L8:
        DoraVolumeAdaptationConfig r101 = (DoraVolumeAdaptationConfig) r100;
        if (Intrinsics.areEqual(this.maxGain, r101.maxGain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxVolumeLevelRange, r101.maxVolumeLevelRange) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxIncDb, r101.maxIncDb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDecDb, r101.maxDecDb) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.defaultState, r101.defaultState) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Float r100 = this.maxGain;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.maxVolumeLevelRange;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.maxIncDb;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.maxDecDb;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.defaultState;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "DoraVolumeAdaptationConfig(maxGain=" + this.maxGain + ", maxVolumeLevelRange=" + this.maxVolumeLevelRange + ", maxIncDb=" + this.maxIncDb + ", maxDecDb=" + this.maxDecDb + ", defaultState=" + this.defaultState + ')';
    }

    public final Boolean getDefaultState() {
        return this.defaultState;
    }

    public final Float getMaxDecDb() {
        return this.maxDecDb;
    }

    public final Float getMaxGain() {
        return this.maxGain;
    }

    public final Float getMaxIncDb() {
        return this.maxIncDb;
    }

    public final Integer getMaxVolumeLevelRange() {
        return this.maxVolumeLevelRange;
    }

    public DoraVolumeAdaptationConfig(Float r100, Integer r101, Float r102, Float r103, Boolean r104) {
        this.maxGain = r100;
        this.maxVolumeLevelRange = r101;
        this.maxIncDb = r102;
        this.maxDecDb = r103;
        this.defaultState = r104;
    }

    public /* synthetic */ DoraVolumeAdaptationConfig(Float r100, Integer r101, Float r102, Float r103, Boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Float r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Float r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Float r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Boolean r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
