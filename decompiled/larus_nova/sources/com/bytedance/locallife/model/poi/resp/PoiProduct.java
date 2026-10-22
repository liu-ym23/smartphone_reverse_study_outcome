package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiProduct implements Serializable {

    @SerializedName("detail_entry")
    public PoiSpu detailInfo;

    @SerializedName("ext_id")
    public String extId;

    @SerializedName("house_fineness_type")
    public int houseType;

    @SerializedName("image_url")
    public PoiImageUrlModel imageUrl;

    @SerializedName("name")
    public String name;

    @SerializedName("onsale")
    public String onSale;

    @SerializedName("price")
    public String price;

    public PoiProduct() {
    }
}
