package com.bytedance.locallife.groupon.fence;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\\\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;", "", "dayRange", "", "guideTimes", "maxTimes", "intervalDay", "impressionType", "", "objectType", "objectIndex", "(IIILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDayRange", "()I", "getGuideTimes", "getImpressionType", "()Ljava/lang/String;", "getIntervalDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxTimes", "getObjectIndex", "getObjectType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MovingGuideFrequency {

    @SerializedName("day_range")
    private final int dayRange;

    @SerializedName("guide_times")
    private final int guideTimes;

    @SerializedName("impression_type")
    private final String impressionType;

    @SerializedName("interval_day")
    private final Integer intervalDay;

    @SerializedName("max_guide_times")
    private final int maxTimes;

    @SerializedName("object_index")
    private final String objectIndex;

    @SerializedName("object_type")
    private final String objectType;

    public MovingGuideFrequency() {
        this(0, 0, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MovingGuideFrequency copy$default(MovingGuideFrequency r100, int r101, int r102, int r103, Integer r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.dayRange;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.guideTimes;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.maxTimes;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.intervalDay;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.impressionType;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.objectType;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.objectIndex;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.dayRange;
    }

    public final int component2() {
        return this.guideTimes;
    }

    public final int component3() {
        return this.maxTimes;
    }

    public final Integer component4() {
        return this.intervalDay;
    }

    public final String component5() {
        return this.impressionType;
    }

    public final String component6() {
        return this.objectType;
    }

    public final String component7() {
        return this.objectIndex;
    }

    public final MovingGuideFrequency copy(int r110, int r111, int r112, Integer r113, String r114, String r115, String r116) {
        return new MovingGuideFrequency(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MovingGuideFrequency) == true) goto L8;
        return false;
    L8:
        MovingGuideFrequency r101 = (MovingGuideFrequency) r100;
        if (this.dayRange == r101.dayRange) goto L12;
        return false;
    L12:
        if (this.guideTimes == r101.guideTimes) goto L15;
        return false;
    L15:
        if (this.maxTimes == r101.maxTimes) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intervalDay, r101.intervalDay) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.impressionType, r101.impressionType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.objectType, r101.objectType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.objectIndex, r101.objectIndex) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.dayRange * 31) + this.guideTimes) * 31) + this.maxTimes) * 31;
        Integer r101 = this.intervalDay;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.impressionType;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.objectType;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.objectIndex;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MovingGuideFrequency(dayRange=" + this.dayRange + ", guideTimes=" + this.guideTimes + ", maxTimes=" + this.maxTimes + ", intervalDay=" + this.intervalDay + ", impressionType=" + this.impressionType + ", objectType=" + this.objectType + ", objectIndex=" + this.objectIndex + ')';
    }

    public final int getDayRange() {
        return this.dayRange;
    }

    public final int getGuideTimes() {
        return this.guideTimes;
    }

    public final String getImpressionType() {
        return this.impressionType;
    }

    public final Integer getIntervalDay() {
        return this.intervalDay;
    }

    public final int getMaxTimes() {
        return this.maxTimes;
    }

    public final String getObjectIndex() {
        return this.objectIndex;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public MovingGuideFrequency(int r100, int r101, int r102, Integer r103, String r104, String r105, String r106) {
        this.dayRange = r100;
        this.guideTimes = r101;
        this.maxTimes = r102;
        this.intervalDay = r103;
        this.impressionType = r104;
        this.objectType = r105;
        this.objectIndex = r106;
    }

    public /* synthetic */ MovingGuideFrequency(int r100, int r101, int r102, Integer r103, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r113 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        Integer r106 = r103;
        if ((r113 & 16) == 0) goto L20;
        String r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        String r108 = null;
    L26:
        if ((r113 & 64) == 0) goto L28;
        String r116 = null;
    L29:
        this(r115, r104, r105, r106, r107, r108, r116);
        return;
    L28:
        r116 = r112;
        goto L29
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
