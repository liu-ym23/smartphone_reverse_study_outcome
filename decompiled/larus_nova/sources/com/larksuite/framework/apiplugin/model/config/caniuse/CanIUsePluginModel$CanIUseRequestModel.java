package com.larksuite.framework.apiplugin.model.config.caniuse;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class CanIUsePluginModel$CanIUseRequestModel extends LKBaseRequestModel {

    @JSONField(name = "schema")
    @LKRequiredParam
    public String schema;

    public CanIUsePluginModel$CanIUseRequestModel() {
    }
}
