package com.bytedance.locallife.live.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/live/model/GroupPurchaseCardNearStoreInfo;", "Ljava/io/Serializable;", "()V", "applicableStore", "", "getApplicableStore", "()Ljava/lang/String;", "setApplicableStore", "(Ljava/lang/String;)V", "deliveryTime", "getDeliveryTime", "setDeliveryTime", "distanceInfoType", "getDistanceInfoType", "setDistanceInfoType", "distanceText", "getDistanceText", "setDistanceText", "distantKm", "getDistantKm", "setDistantKm", "isShowDistantModule", "setShowDistantModule", "isStoreNameShow", "setStoreNameShow", "poiName", "getPoiName", "setPoiName", "poiTotalText", "getPoiTotalText", "setPoiTotalText", "poiTotalType", "getPoiTotalType", "setPoiTotalType", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GroupPurchaseCardNearStoreInfo implements Serializable {

    @SerializedName("applicable_store")
    private String applicableStore;

    @SerializedName("delivery_time")
    private String deliveryTime;

    @SerializedName("distance_info_type")
    private String distanceInfoType;

    @SerializedName("distance_text")
    private String distanceText;

    @SerializedName("distant_km")
    private String distantKm;

    @SerializedName("is_show_distant_module")
    private String isShowDistantModule;

    @SerializedName("is_store_name_show")
    private String isStoreNameShow;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_total_text")
    private String poiTotalText;

    @SerializedName("poi_total_type")
    private String poiTotalType;

    public GroupPurchaseCardNearStoreInfo() {
        this.isShowDistantModule = "0";
        this.distantKm = "-1";
        this.applicableStore = "-1";
        this.isStoreNameShow = "0";
        this.distanceInfoType = "";
        this.poiTotalType = "";
        this.deliveryTime = "";
    }

    public final String getApplicableStore() {
        return this.applicableStore;
    }

    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public final String getDistanceInfoType() {
        return this.distanceInfoType;
    }

    public final String getDistanceText() {
        return this.distanceText;
    }

    public final String getDistantKm() {
        return this.distantKm;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getPoiTotalText() {
        return this.poiTotalText;
    }

    public final String getPoiTotalType() {
        return this.poiTotalType;
    }

    public final String isShowDistantModule() {
        return this.isShowDistantModule;
    }

    public final String isStoreNameShow() {
        return this.isStoreNameShow;
    }

    public final void setApplicableStore(String r100) {
        this.applicableStore = r100;
    }

    public final void setDeliveryTime(String r100) {
        this.deliveryTime = r100;
    }

    public final void setDistanceInfoType(String r100) {
        this.distanceInfoType = r100;
    }

    public final void setDistanceText(String r100) {
        this.distanceText = r100;
    }

    public final void setDistantKm(String r100) {
        this.distantKm = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setPoiTotalText(String r100) {
        this.poiTotalText = r100;
    }

    public final void setPoiTotalType(String r100) {
        this.poiTotalType = r100;
    }

    public final void setShowDistantModule(String r100) {
        this.isShowDistantModule = r100;
    }

    public final void setStoreNameShow(String r100) {
        this.isStoreNameShow = r100;
    }
}
