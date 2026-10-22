package com.larksuite.framework.apiplugin.model.block;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class SetBlockInfoPluginModel$SetBlockInfoRequestModel extends LKBaseRequestModel {

    @JSONField(name = "blockID")
    public String blockID;

    @JSONField(name = "blockTypeID")
    public String blockTypeID;

    @JSONField(name = "sourceData")
    public String sourceData;

    @JSONField(name = "sourceMeta")
    public String sourceMeta;

    public SetBlockInfoPluginModel$SetBlockInfoRequestModel() {
    }
}
