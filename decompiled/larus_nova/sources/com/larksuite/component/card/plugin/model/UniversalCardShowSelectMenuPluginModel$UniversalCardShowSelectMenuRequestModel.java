package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.plugin.ShowSelectMenuPlugin;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel extends LKBaseRequestModel {

    @JSONField(name = "elementID")
    public String elementID;

    @JSONField(name = "initialOptions")
    public ArrayList<String> initialOptions;

    @JSONField(name = "isTranslateElement")
    public boolean isTranslateElement;

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "options")
    @LKRequiredParam
    public ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> options;

    @JSONField(name = "tag")
    public String tag;

    @JSONField(name = "title")
    public String title;

    @JSONField(name = "type")
    @LKRequiredParam
    @StringEnum(values = {ShowSelectMenuPlugin.MULTI_SELECT_STATIC, ShowSelectMenuPlugin.MULTI_SELECT_PERSON, ShowSelectMenuPlugin.SELECT_STATIC, ShowSelectMenuPlugin.SELECT_PERSON})
    public String type;

    public UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel() {
    }
}
