package com.bytedance.locallife.model.poi.resp;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiAddress implements Serializable {

    @SerializedName("address")
    public String address;

    @SerializedName("city")
    public String city;

    @SerializedName("city_code")
    public String cityCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    public String district;

    @SerializedName("province")
    public String province;

    @SerializedName("simple_addr")
    public String simple_addr;

    public Address toAddress() {
        Address r100 = new Address();
        r100.cityCode = this.cityCode;
        r100.city = this.city;
        r100.district = this.district;
        r100.simpleAddr = this.simple_addr;
        r100.province = this.province;
        return r100;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSimpleAddress() {
        return this.simple_addr;
    }

    public PoiAddress(String r100) {
        this.city = r100;
    }

    public void setAddress(String r100) {
        this.address = r100;
    }

    public void setSimpleAddress(String r100) {
        this.simple_addr = r100;
    }

    public PoiAddress(String r100, String r101) {
        this.city = r100;
        this.cityCode = r101;
    }
}
