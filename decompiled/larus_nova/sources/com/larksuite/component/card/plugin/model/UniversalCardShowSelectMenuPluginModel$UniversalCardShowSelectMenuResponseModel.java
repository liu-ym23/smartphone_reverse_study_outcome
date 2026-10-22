package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel extends LKBaseResponseModel {

    @JSONField(name = "selectedValues")
    public ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> selectedValues;

    public UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel() {
    }
}
