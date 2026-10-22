package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class NdefReadNdefMessagePluginModel$NdefReadNdefMessageResponseModel extends LKBaseResponseModel {

    @JSONField(name = "messages")
    public ArrayList<NdefReadNdefMessagePluginModel$MessagesItemModel> messages;

    public NdefReadNdefMessagePluginModel$NdefReadNdefMessageResponseModel() {
    }
}
