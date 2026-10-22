package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class MsgCardShowOverflowPluginModel$ActionsItemModel implements Serializable {

    @JSONField(name = "actionID")
    public String actionID;

    @JSONField(name = "type")
    @LKRequiredParam
    @StringEnum(values = {"open_url", "action_request"})
    public String type;

    @JSONField(name = "url")
    public String url;

    @JSONField(name = "value")
    public String value;

    public MsgCardShowOverflowPluginModel$ActionsItemModel() {
    }
}
