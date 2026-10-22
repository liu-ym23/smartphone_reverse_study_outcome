package com.larksuite.framework.apiplugin.model.config.caniuse;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes24.dex */
public class CanIUsePluginModel$CanIUseResponseModel extends LKBaseResponseModel {

    @JSONField(name = "data")
    @LKRequiredParam
    public boolean data;

    public CanIUsePluginModel$CanIUseResponseModel() {
    }
}
