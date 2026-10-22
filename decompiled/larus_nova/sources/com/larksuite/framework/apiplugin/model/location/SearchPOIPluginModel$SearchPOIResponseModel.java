package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class SearchPOIPluginModel$SearchPOIResponseModel extends LKBaseResponseModel {

    @JSONField(name = "poiList")
    @LKRequiredParam
    public ArrayList<SearchPOIPluginModel$PoiListItemModel> poiList;

    public SearchPOIPluginModel$SearchPOIResponseModel() {
    }
}
