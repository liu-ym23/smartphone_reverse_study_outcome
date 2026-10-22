package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardShowSelectMenuPluginModel$OptionsItemModel implements Serializable {

    @JSONField(name = "icon")
    public UniversalCardShowSelectMenuPluginModel$IconModel icon;
    public transient boolean isSelected;

    @JSONField(name = "text")
    public String text;

    @JSONField(name = "value")
    @LKRequiredParam
    public String value;

    public UniversalCardShowSelectMenuPluginModel$OptionsItemModel() {
    }
}
