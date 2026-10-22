package com.larksuite.framework.apiplugin.model.authorize;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes24.dex */
public class RequestAccessPluginModel$RequestAccessResponseModel extends LKBaseResponseModel {

    @JSONField(name = "code")
    @LKRequiredParam
    public String code;

    @JSONField(name = "firstPartyLoginOptEnabled")
    public Boolean firstPartyLoginOptEnabled;

    @JSONField(name = "state")
    public String state;

    public RequestAccessPluginModel$RequestAccessResponseModel() {
    }
}
