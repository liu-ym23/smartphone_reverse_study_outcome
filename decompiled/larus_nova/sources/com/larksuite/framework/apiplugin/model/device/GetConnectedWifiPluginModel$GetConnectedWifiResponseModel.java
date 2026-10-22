package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.validator.format.NumberEnum;

/* JADX INFO: loaded from: classes24.dex */
public class GetConnectedWifiPluginModel$GetConnectedWifiResponseModel extends LKBaseResponseModel {

    @JSONField(name = "BSSID")
    @LKRequiredParam
    public String BSSID;

    @JSONField(name = "SSID")
    @LKRequiredParam
    public String SSID;

    @NumberEnum(values = {1.0d, 2.0d, 555.0d})
    @JSONField(name = "networkSecurityType")
    public int networkSecurityType;

    @JSONField(name = "secure")
    public boolean secure;

    @JSONField(name = "signalStrength")
    public double signalStrength;

    public GetConnectedWifiPluginModel$GetConnectedWifiResponseModel() {
    }
}
