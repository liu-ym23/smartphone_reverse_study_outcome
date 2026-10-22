package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel extends LKBaseRequestModel {

    @JSONField(name = "elementID")
    @LKRequiredParam
    public String elementID;

    @JSONField(name = "tag")
    public String tag;

    @JSONField(name = "url")
    public String url;

    public UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel() {
        this.tag = null;
    }
}
