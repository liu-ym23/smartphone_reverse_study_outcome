package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class MsgCardShowOverflowPluginModel$OptionsItemModel implements Serializable {

    @JSONField(name = SlcCommonAction.KEY_ACTIONS)
    @LKRequiredParam
    public ArrayList<MsgCardShowOverflowPluginModel$ActionsItemModel> actions;

    @JSONField(name = "text")
    @LKRequiredParam
    public String text;

    public MsgCardShowOverflowPluginModel$OptionsItemModel() {
    }
}
