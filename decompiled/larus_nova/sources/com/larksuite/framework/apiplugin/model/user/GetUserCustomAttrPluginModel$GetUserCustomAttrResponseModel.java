package com.larksuite.framework.apiplugin.model.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes24.dex */
public class GetUserCustomAttrPluginModel$GetUserCustomAttrResponseModel extends LKBaseResponseModel {

    @JSONField(name = "userCustomAttr")
    @LKRequiredParam
    public JSONArray userCustomAttr;

    public GetUserCustomAttrPluginModel$GetUserCustomAttrResponseModel() {
    }
}
