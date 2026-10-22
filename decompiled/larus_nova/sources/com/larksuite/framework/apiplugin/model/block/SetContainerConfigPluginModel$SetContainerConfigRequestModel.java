package com.larksuite.framework.apiplugin.model.block;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class SetContainerConfigPluginModel$SetContainerConfigRequestModel extends LKBaseRequestModel {

    @JSONField(name = "height")
    public double height;

    public SetContainerConfigPluginModel$SetContainerConfigRequestModel() {
        this.height = 450.0d;
    }
}
