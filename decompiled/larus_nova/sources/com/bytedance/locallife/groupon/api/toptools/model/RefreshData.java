package com.bytedance.locallife.groupon.api.toptools.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/RefreshData;", "", "landingKey", "", "landingStatus", "", "orderId", "poiId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getLandingKey", "()Ljava/lang/String;", "setLandingKey", "(Ljava/lang/String;)V", "getLandingStatus", "()Ljava/lang/Integer;", "setLandingStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOrderId", "setOrderId", "getPoiId", "setPoiId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/api/toptools/model/RefreshData;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RefreshData {

    @SerializedName("landing_key")
    private String landingKey;

    @SerializedName("landing_status")
    private Integer landingStatus;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("poi_id")
    private String poiId;

    public RefreshData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RefreshData copy$default(RefreshData r100, String r101, Integer r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.landingKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.landingStatus;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.orderId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.poiId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.landingKey;
    }

    public final Integer component2() {
        return this.landingStatus;
    }

    public final String component3() {
        return this.orderId;
    }

    public final String component4() {
        return this.poiId;
    }

    public final RefreshData copy(String r100, Integer r101, String r102, String r103) {
        return new RefreshData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RefreshData) == true) goto L8;
        return false;
    L8:
        RefreshData r101 = (RefreshData) r100;
        if (Intrinsics.areEqual(this.landingKey, r101.landingKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.landingStatus, r101.landingStatus) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.orderId, r101.orderId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.landingKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.landingStatus;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.orderId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.poiId;
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
        return "RefreshData(landingKey=" + this.landingKey + ", landingStatus=" + this.landingStatus + ", orderId=" + this.orderId + ", poiId=" + this.poiId + ')';
    }

    public final String getLandingKey() {
        return this.landingKey;
    }

    public final Integer getLandingStatus() {
        return this.landingStatus;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final void setLandingKey(String r100) {
        this.landingKey = r100;
    }

    public final void setLandingStatus(Integer r100) {
        this.landingStatus = r100;
    }

    public final void setOrderId(String r100) {
        this.orderId = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public RefreshData(String r100, Integer r101, String r102, String r103) {
        this.landingKey = r100;
        this.landingStatus = r101;
        this.orderId = r102;
        this.poiId = r103;
    }

    public /* synthetic */ RefreshData(String r100, Integer r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
