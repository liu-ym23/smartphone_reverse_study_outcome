package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/d;", "", "", "province", "Ljava/lang/String;", "getProvince", "()Ljava/lang/String;", "setProvince", "(Ljava/lang/String;)V", "city", "getCity", "setCity", "simple_addr", "getSimple_addr", "setSimple_addr", DistrictSearchQuery.KEYWORDS_DISTRICT, "getDistrict", "setDistrict", "cityCode", "getCityCode", "setCityCode", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class d {

    @SerializedName("city")
    private String city;

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    private String district;

    @SerializedName("province")
    private String province;

    @SerializedName("simple_addr")
    private String simple_addr;
}
