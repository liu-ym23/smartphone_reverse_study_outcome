package com.bytedance.bdlocation.entity;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class GeoPoiEntity {

    @SerializedName("address")
    public String address;

    @SerializedName("area")
    public String area;

    @SerializedName(SimilarProductParam.AWEME_ID)
    public String awemeId;

    @SerializedName("businessarea")
    public String businessArea;

    @SerializedName("distance")
    public Double distance;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public String f199861id;

    @SerializedName("location")
    public String location;

    @SerializedName("name")
    public String name;

    @SerializedName("poiweight")
    public String poiWeight;

    @SerializedName(WsConstants.KEY_SESSION_ID)
    public String sId;

    @SerializedName("source")
    public String source;

    @SerializedName("tel")
    public String tel;

    @SerializedName("typecode")
    public String typeCode;

    public GeoPoiEntity() {
    }
}
