package com.bytedance.locallife.model.poi.resp;

import android.text.TextUtils;
import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiStruct implements Serializable {

    @SerializedName("address_info")
    public Address address;

    @SerializedName("anchor_post_ext")
    public AnchorPostExtra anchorPostExtra;

    @SerializedName("coin_label")
    public PoiCoinLabel coinLabel;

    @SerializedName("collect_stat")
    int collectStatus;

    @SerializedName("poi_backend_type")
    public PoiBackendType poiBackendType;

    @SerializedName("poi_id")
    public String poiId;

    @SerializedName("ext_json")
    @JsonAdapter(StringJsonAdapterFactory.class)
    public PoiExtJsonStruct poiJsonStruct;

    @SerializedName("poi_latitude")
    public Double poiLatitude;

    @SerializedName("poi_longitude")
    public Double poiLongitude;

    @SerializedName("poi_name")
    public String poiName;

    @SerializedName("share_info")
    public ShareInfo shareInfo;

    @SerializedName("type_code")
    public String typeCode;

    public PoiStruct() {
    }

    public String getAddressStr() {
        Address r100 = this.address;
        if (r100 != null) goto L7;
        return this.poiName;
    L7:
        if (TextUtils.isEmpty(r100.simpleAddr) == false) goto L10;
        return this.poiName;
    L10:
        return this.address.simpleAddr;
    }

    public String getBackendTypeCode() {
        PoiBackendType r100 = this.poiBackendType;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getCode();
    }

    public String getCityCode() {
        Address r100 = this.address;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100.getCityCode()) == false) goto L9;
        return null;
    L9:
        return this.address.getCityCode();
    }

    public String getPoiLatitude() {
        return String.valueOf(this.poiLatitude);
    }

    public String getPoiLongitude() {
        return String.valueOf(this.poiLongitude);
    }

    public Address getAddress() {
        return this.address;
    }

    public int getCollectStatus() {
        return this.collectStatus;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setBackendType(PoiBackendType r100) {
        this.poiBackendType = r100;
    }

    public void setPoiId(String r100) {
        this.poiId = r100;
    }
}
