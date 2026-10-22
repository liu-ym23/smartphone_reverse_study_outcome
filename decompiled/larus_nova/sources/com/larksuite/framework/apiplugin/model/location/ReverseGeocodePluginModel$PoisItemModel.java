package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class ReverseGeocodePluginModel$PoisItemModel implements Serializable {

    @JSONField(name = "businessArea")
    @LKRequiredParam
    public String businessArea;

    @JSONField(name = "distance")
    @LKRequiredParam
    public double distance;

    @JSONField(name = "latitude")
    @LKRequiredParam
    public double latitude;

    @JSONField(name = "longitude")
    @LKRequiredParam
    public double longitude;

    @JSONField(name = "parkingType")
    @LKRequiredParam
    public String parkingType;

    @JSONField(name = "poiId")
    @LKRequiredParam
    public String poiId;

    @JSONField(name = "snippet")
    @LKRequiredParam
    public String snippet;

    @JSONField(name = "tel")
    @LKRequiredParam
    public String tel;

    @JSONField(name = "title")
    @LKRequiredParam
    public String title;

    @JSONField(name = "typeCode")
    @LKRequiredParam
    public String typeCode;

    @JSONField(name = "typeDes")
    @LKRequiredParam
    public String typeDes;

    public ReverseGeocodePluginModel$PoisItemModel() {
    }
}
