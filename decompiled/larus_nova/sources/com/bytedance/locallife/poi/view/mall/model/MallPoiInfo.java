package com.bytedance.locallife.poi.view.mall.model;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.bytedance.locallife.model.poi.resp.Address;
import com.bytedance.locallife.model.poi.resp.PoiBackendType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0086\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0007HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u001fR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u001fR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u001fR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u001f¨\u0006>"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;", "Ljava/io/Serializable;", "addressInfo", "Lcom/bytedance/locallife/model/poi/resp/Address;", "businessAreaName", "", ChameleonOpenTracker.ParamKey.COST, "", "cover", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "floor", "poiId", "poiName", "rankDesc", "distance", "poiBackendType", "Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;", "(Lcom/bytedance/locallife/model/poi/resp/Address;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;)V", "getAddressInfo", "()Lcom/bytedance/locallife/model/poi/resp/Address;", "getBusinessAreaName", "()Ljava/lang/String;", "getCost", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCover", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setCover", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "getDistance", "setDistance", "(Ljava/lang/String;)V", "getFloor", "setFloor", "getPoiBackendType", "()Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;", "setPoiBackendType", "(Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;)V", "getPoiId", "setPoiId", "getPoiName", "setPoiName", "getRankDesc", "setRankDesc", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/locallife/model/poi/resp/Address;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;)Lcom/bytedance/locallife/poi/view/mall/model/MallPoiInfo;", "equals", "", "other", "", "hashCode", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MallPoiInfo implements Serializable {

    @SerializedName("address_info")
    private final Address addressInfo;

    @SerializedName("business_area_name")
    private final String businessAreaName;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    private final Integer cost;

    @SerializedName("cover")
    private UrlModel cover;

    @SerializedName("distance")
    private String distance;

    @SerializedName("floor")
    private String floor;

    @SerializedName("poi_backend_type")
    private PoiBackendType poiBackendType;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_rank_desc")
    private String rankDesc;

    public MallPoiInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ MallPoiInfo copy$default(MallPoiInfo r110, Address r111, String r112, Integer r113, UrlModel r114, String r115, String r116, String r117, String r118, String r210, PoiBackendType r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Address r100 = r110.addressInfo;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.businessAreaName;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r102 = r110.cost;
    L15:
        if ((r212 & 8) == 0) goto L17;
        UrlModel r103 = r110.cover;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.floor;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.poiId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.poiName;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.rankDesc;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.distance;
    L39:
        if ((r212 & 512) == 0) goto L41;
        PoiBackendType r108 = r110.poiBackendType;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    public final Address component1() {
        return this.addressInfo;
    }

    public final PoiBackendType component10() {
        return this.poiBackendType;
    }

    public final String component2() {
        return this.businessAreaName;
    }

    public final Integer component3() {
        return this.cost;
    }

    public final UrlModel component4() {
        return this.cover;
    }

    public final String component5() {
        return this.floor;
    }

    public final String component6() {
        return this.poiId;
    }

    public final String component7() {
        return this.poiName;
    }

    public final String component8() {
        return this.rankDesc;
    }

    public final String component9() {
        return this.distance;
    }

    public final MallPoiInfo copy(Address r110, String r111, Integer r112, UrlModel r113, String r114, String r115, String r116, String r210, String r211, PoiBackendType r212) {
        return new MallPoiInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MallPoiInfo) == true) goto L8;
        return false;
    L8:
        MallPoiInfo r101 = (MallPoiInfo) r100;
        if (Intrinsics.areEqual(this.addressInfo, r101.addressInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.businessAreaName, r101.businessAreaName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cost, r101.cost) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.floor, r101.floor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.poiName, r101.poiName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.rankDesc, r101.rankDesc) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.distance, r101.distance) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.poiBackendType, r101.poiBackendType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Address r100 = this.addressInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.businessAreaName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.cost;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UrlModel r110 = this.cover;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.floor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.poiId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.poiName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.rankDesc;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.distance;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        PoiBackendType r128 = this.poiBackendType;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "MallPoiInfo(addressInfo=" + this.addressInfo + ", businessAreaName=" + this.businessAreaName + ", cost=" + this.cost + ", cover=" + this.cover + ", floor=" + this.floor + ", poiId=" + this.poiId + ", poiName=" + this.poiName + ", rankDesc=" + this.rankDesc + ", distance=" + this.distance + ", poiBackendType=" + this.poiBackendType + ')';
    }

    public final Address getAddressInfo() {
        return this.addressInfo;
    }

    public final String getBusinessAreaName() {
        return this.businessAreaName;
    }

    public final Integer getCost() {
        return this.cost;
    }

    public final UrlModel getCover() {
        return this.cover;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getFloor() {
        return this.floor;
    }

    public final PoiBackendType getPoiBackendType() {
        return this.poiBackendType;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getRankDesc() {
        return this.rankDesc;
    }

    public final void setCover(UrlModel r100) {
        this.cover = r100;
    }

    public final void setDistance(String r100) {
        this.distance = r100;
    }

    public final void setFloor(String r100) {
        this.floor = r100;
    }

    public final void setPoiBackendType(PoiBackendType r100) {
        this.poiBackendType = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setRankDesc(String r100) {
        this.rankDesc = r100;
    }

    public MallPoiInfo(Address r100, String r101, Integer r102, UrlModel r103, String r104, String r105, String r106, String r107, String r108, PoiBackendType r110) {
        this.addressInfo = r100;
        this.businessAreaName = r101;
        this.cost = r102;
        this.cover = r103;
        this.floor = r104;
        this.poiId = r105;
        this.poiName = r106;
        this.rankDesc = r107;
        this.distance = r108;
        this.poiBackendType = r110;
    }

    public /* synthetic */ MallPoiInfo(Address r110, String r111, Integer r112, UrlModel r113, String r114, String r115, String r116, String r117, String r210, PoiBackendType r211, int r212, DefaultConstructorMarker r213) {
        PoiBackendType r100 = null;
        if ((r212 & 1) == 0) goto L5;
        Address r101 = null;
    L6:
        String r102 = "";
        if ((r212 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r104 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        UrlModel r105 = null;
    L19:
        if ((r212 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r103, r104, r105, r102, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
