package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.amap.api.services.district.DistrictSearchQuery;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class ReverseGeocodePluginModel$ReverseGeocodeResponseModel extends LKBaseResponseModel {

    @JSONField(name = "address")
    @LKRequiredParam
    public String address;

    @JSONField(name = "aois")
    public ArrayList<ReverseGeocodePluginModel$AoisItemModel> aois;

    @JSONField(name = LocationConstants$NameType.BUILDING)
    @LKRequiredParam
    public String building;

    @JSONField(name = "city")
    @LKRequiredParam
    public String city;

    @JSONField(name = DistrictSearchQuery.KEYWORDS_COUNTRY)
    @LKRequiredParam
    public String country;

    @JSONField(name = DistrictSearchQuery.KEYWORDS_DISTRICT)
    @LKRequiredParam
    public String district;

    @JSONField(name = "neighborhood")
    @LKRequiredParam
    public String neighborhood;

    @JSONField(name = "pois")
    public ArrayList<ReverseGeocodePluginModel$PoisItemModel> pois;

    @JSONField(name = "province")
    @LKRequiredParam
    public String province;

    @JSONField(name = "streetNumberInfo")
    public ReverseGeocodePluginModel$StreetNumberInfoModel streetNumberInfo;

    @JSONField(name = "township")
    @LKRequiredParam
    public String township;

    public ReverseGeocodePluginModel$ReverseGeocodeResponseModel() {
    }
}
