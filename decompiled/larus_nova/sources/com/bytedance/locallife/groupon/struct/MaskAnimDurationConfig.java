package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;", "Ljava/io/Serializable;", "fadeInDuration", "", "fadeOutDuration", "shortScanDuration", "longScanDuration", "scanInterval", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getFadeInDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFadeOutDuration", "getLongScanDuration", "getScanInterval", "getShortScanDuration", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MaskAnimDurationConfig implements Serializable {

    @SerializedName("fade_in_duration")
    private final Long fadeInDuration;

    @SerializedName("fade_out_duration")
    private final Long fadeOutDuration;

    @SerializedName("long_scan_duration")
    private final Long longScanDuration;

    @SerializedName("scan_interval")
    private final Long scanInterval;

    @SerializedName("short_scan_duration")
    private final Long shortScanDuration;

    public MaskAnimDurationConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MaskAnimDurationConfig copy$default(MaskAnimDurationConfig r100, Long r101, Long r102, Long r103, Long r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.fadeInDuration;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.fadeOutDuration;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.shortScanDuration;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.longScanDuration;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.scanInterval;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.fadeInDuration;
    }

    public final Long component2() {
        return this.fadeOutDuration;
    }

    public final Long component3() {
        return this.shortScanDuration;
    }

    public final Long component4() {
        return this.longScanDuration;
    }

    public final Long component5() {
        return this.scanInterval;
    }

    public final MaskAnimDurationConfig copy(Long r100, Long r101, Long r110, Long r111, Long r112) {
        return new MaskAnimDurationConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MaskAnimDurationConfig) == true) goto L8;
        return false;
    L8:
        MaskAnimDurationConfig r101 = (MaskAnimDurationConfig) r100;
        if (Intrinsics.areEqual(this.fadeInDuration, r101.fadeInDuration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fadeOutDuration, r101.fadeOutDuration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortScanDuration, r101.shortScanDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.longScanDuration, r101.longScanDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scanInterval, r101.scanInterval) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.fadeInDuration;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.fadeOutDuration;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.shortScanDuration;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.longScanDuration;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.scanInterval;
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
        return "MaskAnimDurationConfig(fadeInDuration=" + this.fadeInDuration + ", fadeOutDuration=" + this.fadeOutDuration + ", shortScanDuration=" + this.shortScanDuration + ", longScanDuration=" + this.longScanDuration + ", scanInterval=" + this.scanInterval + ')';
    }

    public final Long getFadeInDuration() {
        return this.fadeInDuration;
    }

    public final Long getFadeOutDuration() {
        return this.fadeOutDuration;
    }

    public final Long getLongScanDuration() {
        return this.longScanDuration;
    }

    public final Long getScanInterval() {
        return this.scanInterval;
    }

    public final Long getShortScanDuration() {
        return this.shortScanDuration;
    }

    public MaskAnimDurationConfig(Long r100, Long r101, Long r102, Long r103, Long r104) {
        this.fadeInDuration = r100;
        this.fadeOutDuration = r101;
        this.shortScanDuration = r102;
        this.longScanDuration = r103;
        this.scanInterval = r104;
    }

    public /* synthetic */ MaskAnimDurationConfig(Long r100, Long r101, Long r102, Long r103, Long r104, int r105, DefaultConstructorMarker r110) {
        Long r106 = 200L;
        if ((r105 & 1) == 0) goto L5;
        Long r111 = r106;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        r102 = 600L;
    L13:
        Long r107 = r102;
        if ((r105 & 8) == 0) goto L16;
        r103 = 1000L;
    L16:
        Long r108 = r103;
        if ((r105 & 16) == 0) goto L19;
        r104 = 300L;
    L19:
        Long r109 = r111;
        Long r112 = r106;
        this(r109, r112, r107, r108, r104);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
