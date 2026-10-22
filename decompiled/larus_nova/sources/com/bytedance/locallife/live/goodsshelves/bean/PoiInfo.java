package com.bytedance.locallife.live.goodsshelves.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u0004\u0018\u00010\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR \u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00064"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/PoiInfo;", "Ljava/io/Serializable;", "()V", "cityNumbers", "", "getCityNumbers", "()I", "setCityNumbers", "(I)V", "deliveryText", "", "getDeliveryText", "()Ljava/lang/String;", "setDeliveryText", "(Ljava/lang/String;)V", "deliveryTime", "getDeliveryTime", "setDeliveryTime", "distanceInfoType", "getDistanceInfoType", "setDistanceInfoType", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "poiCity", "getPoiCity", "setPoiCity", "poiId", "getPoiId", "setPoiId", "poiName", "getPoiName", "setPoiName", "shopInfo", "getShopInfo", "setShopInfo", "storeNumbers", "getStoreNumbers", "setStoreNumbers", "userDistance", "getUserDistance", "setUserDistance", "userLocateScene", "getUserLocateScene", "setUserLocateScene", "getPoiDistanceText", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiInfo implements Serializable {

    @SerializedName("city_numbers")
    private int cityNumbers;

    @SerializedName("delivery_text")
    private String deliveryText;

    @SerializedName("delivery_time")
    private String deliveryTime;

    @SerializedName("distance_info_type")
    private String distanceInfoType;

    @SerializedName("latitude")
    private float latitude;

    @SerializedName("longitude")
    private float longitude;

    @SerializedName("poi_city")
    private String poiCity;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("shop_info")
    private String shopInfo;

    @SerializedName("store_numbers")
    private int storeNumbers;

    @SerializedName("user_distance")
    private String userDistance;

    @SerializedName("user_locate_scene")
    private int userLocateScene;

    public final String getPoiDistanceText() {
        if (TextUtils.isEmpty(this.deliveryText) == true) goto L6;
        return this.deliveryText;
    L6:
        if (TextUtils.isEmpty(this.userDistance) == true) goto L9;
        return this.userDistance;
    L9:
        if (TextUtils.isEmpty(this.poiCity) == false) goto L15;
        return "";
    L15:
        return this.poiCity;
    }

    public PoiInfo() {
        this.deliveryText = "";
        this.deliveryTime = "";
        this.distanceInfoType = "";
    }

    public final int getCityNumbers() {
        return this.cityNumbers;
    }

    public final String getDeliveryText() {
        return this.deliveryText;
    }

    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public final String getDistanceInfoType() {
        return this.distanceInfoType;
    }

    public final float getLatitude() {
        return this.latitude;
    }

    public final float getLongitude() {
        return this.longitude;
    }

    public final String getPoiCity() {
        return this.poiCity;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getShopInfo() {
        return this.shopInfo;
    }

    public final int getStoreNumbers() {
        return this.storeNumbers;
    }

    public final String getUserDistance() {
        return this.userDistance;
    }

    public final int getUserLocateScene() {
        return this.userLocateScene;
    }

    public final void setCityNumbers(int r100) {
        this.cityNumbers = r100;
    }

    public final void setDeliveryText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deliveryText = r100;
    }

    public final void setDeliveryTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deliveryTime = r100;
    }

    public final void setDistanceInfoType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.distanceInfoType = r100;
    }

    public final void setLatitude(float r100) {
        this.latitude = r100;
    }

    public final void setLongitude(float r100) {
        this.longitude = r100;
    }

    public final void setPoiCity(String r100) {
        this.poiCity = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setShopInfo(String r100) {
        this.shopInfo = r100;
    }

    public final void setStoreNumbers(int r100) {
        this.storeNumbers = r100;
    }

    public final void setUserDistance(String r100) {
        this.userDistance = r100;
    }

    public final void setUserLocateScene(int r100) {
        this.userLocateScene = r100;
    }
}
