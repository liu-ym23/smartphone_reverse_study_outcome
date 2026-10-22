package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class SearchPOIPluginModel$SearchPOIRequestModel extends LKBaseRequestModel {

    @JSONField(name = "keyword")
    public String keyword;

    @JSONField(name = "latitude")
    @LKRequiredParam
    public double latitude;

    @JSONField(name = "longitude")
    @LKRequiredParam
    public double longitude;

    @JSONField(name = "maxCount")
    public int maxCount;

    @JSONField(name = "radius")
    public int radius;

    public SearchPOIPluginModel$SearchPOIRequestModel() {
        this.maxCount = 24;
    }
}
