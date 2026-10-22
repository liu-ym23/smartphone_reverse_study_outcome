package com.bytedance.locallife.model.poi.resp;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class Address implements Serializable {

    @SerializedName("city")
    String city;

    @SerializedName("city_code")
    String cityCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    String district;

    @SerializedName("province")
    String province;

    @SerializedName("simple_addr")
    String simpleAddr;

    public Address() {
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String r100) {
        this.cityCode = r100;
    }
}
