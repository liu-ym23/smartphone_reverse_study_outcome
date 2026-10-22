package com.bytedance.locallife.biz.collect.guide;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/biz/collect/guide/CollectGuideInfo;", "", "guideType", "", "frequencyInfo", "Lcom/bytedance/locallife/biz/collect/guide/CollectGuideFrequencyInfo;", "showTime", "poiTriggerTimes", "guideText", "", "(ILcom/bytedance/locallife/biz/collect/guide/CollectGuideFrequencyInfo;IILjava/lang/String;)V", "getFrequencyInfo", "()Lcom/bytedance/locallife/biz/collect/guide/CollectGuideFrequencyInfo;", "getGuideText", "()Ljava/lang/String;", "getGuideType", "()I", "getPoiTriggerTimes", "getShowTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CollectGuideInfo {

    @SerializedName("guide_frequency_map")
    private final CollectGuideFrequencyInfo frequencyInfo;

    @SerializedName("guide_text")
    private final String guideText;

    @SerializedName("guide_type")
    private final int guideType;

    @SerializedName("poi_trigger_times")
    private final int poiTriggerTimes;

    @SerializedName("show_time")
    private final int showTime;

    public CollectGuideInfo() {
        this(0, null, 0, 0, null, 31, null);
    }

    public static /* synthetic */ CollectGuideInfo copy$default(CollectGuideInfo r100, int r101, CollectGuideFrequencyInfo r102, int r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.guideType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.frequencyInfo;
    L8:
        CollectGuideFrequencyInfo r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.showTime;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.poiTriggerTimes;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.guideText;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.guideType;
    }

    public final CollectGuideFrequencyInfo component2() {
        return this.frequencyInfo;
    }

    public final int component3() {
        return this.showTime;
    }

    public final int component4() {
        return this.poiTriggerTimes;
    }

    public final String component5() {
        return this.guideText;
    }

    public final CollectGuideInfo copy(int r100, CollectGuideFrequencyInfo r101, int r110, int r111, String r112) {
        return new CollectGuideInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectGuideInfo) == true) goto L8;
        return false;
    L8:
        CollectGuideInfo r101 = (CollectGuideInfo) r100;
        if (this.guideType == r101.guideType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.frequencyInfo, r101.frequencyInfo) == true) goto L15;
        return false;
    L15:
        if (this.showTime == r101.showTime) goto L18;
        return false;
    L18:
        if (this.poiTriggerTimes == r101.poiTriggerTimes) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.guideText, r101.guideText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.guideType * 31;
        CollectGuideFrequencyInfo r101 = this.frequencyInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.showTime) * 31) + this.poiTriggerTimes) * 31;
        String r105 = this.guideText;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CollectGuideInfo(guideType=" + this.guideType + ", frequencyInfo=" + this.frequencyInfo + ", showTime=" + this.showTime + ", poiTriggerTimes=" + this.poiTriggerTimes + ", guideText=" + this.guideText + ')';
    }

    public final CollectGuideFrequencyInfo getFrequencyInfo() {
        return this.frequencyInfo;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public final int getPoiTriggerTimes() {
        return this.poiTriggerTimes;
    }

    public final int getShowTime() {
        return this.showTime;
    }

    public CollectGuideInfo(int r100, CollectGuideFrequencyInfo r101, int r102, int r103, String r104) {
        this.guideType = r100;
        this.frequencyInfo = r101;
        this.showTime = r102;
        this.poiTriggerTimes = r103;
        this.guideText = r104;
    }

    public /* synthetic */ CollectGuideInfo(int r100, CollectGuideFrequencyInfo r101, int r102, int r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = null;
    L8:
        CollectGuideFrequencyInfo r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        int r106 = 15;
    L13:
        if ((r105 & 8) == 0) goto L15;
        int r107 = 3;
    L17:
        if ((r105 & 16) == 0) goto L19;
        r104 = "看了又看？先添加收藏吧";
    L19:
        String r108 = r104;
        this(r100, r111, r106, r107, r108);
        return;
    L15:
        r107 = r103;
        goto L17
    L11:
        r106 = r102;
        goto L13
    }
}
