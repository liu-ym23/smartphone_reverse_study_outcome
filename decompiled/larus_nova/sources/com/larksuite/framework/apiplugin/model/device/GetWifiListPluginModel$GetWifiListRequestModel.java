package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class GetWifiListPluginModel$GetWifiListRequestModel extends LKBaseRequestModel {

    @JSONField(name = "needSecurityType")
    public boolean needSecurityType;

    public GetWifiListPluginModel$GetWifiListRequestModel() {
    }
}
