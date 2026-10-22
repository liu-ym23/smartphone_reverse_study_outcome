package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class GetConnectedWifiPluginModel$GetConnectedWifiRequestModel extends LKBaseRequestModel {

    @JSONField(name = "cacheTimeout")
    public int cacheTimeout;

    @JSONField(name = "needSecurityType")
    public boolean needSecurityType;

    public GetConnectedWifiPluginModel$GetConnectedWifiRequestModel() {
        this.cacheTimeout = 0;
    }
}
