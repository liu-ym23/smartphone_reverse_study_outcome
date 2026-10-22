package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/a;", "", "", "province", "Ljava/lang/String;", "getProvince", "()Ljava/lang/String;", "setProvince", "(Ljava/lang/String;)V", "city", "getCity", "setCity", "cityCode", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCityCode", DistrictSearchQuery.KEYWORDS_DISTRICT, "getDistrict", "setDistrict", "address", "getAddress", "setAddress", "simpleAddr", "getSimpleAddr", "setSimpleAddr", DistrictSearchQuery.KEYWORDS_COUNTRY, "getCountry", "setCountry", CommonConstant.KEY_COUNTRY_CODE, "getCountryCode", "setCountryCode", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
    private String country;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    private String district;

    @SerializedName("province")
    private String province;

    @SerializedName("simple_addr")
    private String simpleAddr;

    public a() {
    }

    public final String a() {
        return this.cityCode;
    }
}
