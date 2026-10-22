package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/RichSugInfo;", "Ljava/io/Serializable;", "infoDistance", "", "infoType", "infoLocation", "infoCost", "poiId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInfoCost", "()Ljava/lang/String;", "getInfoDistance", "getInfoLocation", "getInfoType", "getPoiId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RichSugInfo implements Serializable {

    @SerializedName("avg_cost_display")
    private final String infoCost;

    @SerializedName("user_poi_distance_display")
    private final String infoDistance;

    @SerializedName("poi_location_detail")
    private final String infoLocation;

    @SerializedName("poi_type")
    private final String infoType;

    @SerializedName("poi_id")
    private final String poiId;

    public RichSugInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RichSugInfo copy$default(RichSugInfo r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.infoDistance;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.infoType;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.infoLocation;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.infoCost;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.poiId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.infoDistance;
    }

    public final String component2() {
        return this.infoType;
    }

    public final String component3() {
        return this.infoLocation;
    }

    public final String component4() {
        return this.infoCost;
    }

    public final String component5() {
        return this.poiId;
    }

    public final RichSugInfo copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "infoDistance");
        Intrinsics.checkNotNullParameter(r101, "infoType");
        Intrinsics.checkNotNullParameter(r110, "infoLocation");
        Intrinsics.checkNotNullParameter(r111, "infoCost");
        Intrinsics.checkNotNullParameter(r112, "poiId");
        return new RichSugInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RichSugInfo) == false) goto L16;
        RichSugInfo r101 = (RichSugInfo) r100;
        if (Intrinsics.areEqual(this.infoDistance, r101.infoDistance) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.infoType, r101.infoType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.infoLocation, r101.infoLocation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.infoCost, r101.infoCost) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.infoDistance;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.infoType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.infoLocation;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.infoCost;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.poiId;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RichSugInfo(infoDistance=" + this.infoDistance + ", infoType=" + this.infoType + ", infoLocation=" + this.infoLocation + ", infoCost=" + this.infoCost + ", poiId=" + this.poiId + ")";
    }

    public final String getInfoCost() {
        return this.infoCost;
    }

    public final String getInfoDistance() {
        return this.infoDistance;
    }

    public final String getInfoLocation() {
        return this.infoLocation;
    }

    public final String getInfoType() {
        return this.infoType;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public RichSugInfo(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "infoDistance");
        Intrinsics.checkNotNullParameter(r101, "infoType");
        Intrinsics.checkNotNullParameter(r102, "infoLocation");
        Intrinsics.checkNotNullParameter(r103, "infoCost");
        Intrinsics.checkNotNullParameter(r104, "poiId");
        this.infoDistance = r100;
        this.infoType = r101;
        this.infoLocation = r102;
        this.infoCost = r103;
        this.poiId = r104;
    }

    public /* synthetic */ RichSugInfo(String r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = "";
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = "xxx";
    L21:
        String r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
