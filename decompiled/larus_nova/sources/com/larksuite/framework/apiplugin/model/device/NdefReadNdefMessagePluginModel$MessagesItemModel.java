package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.common.wschannel.WsConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class NdefReadNdefMessagePluginModel$MessagesItemModel implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @JSONField(name = "id")
    public String f285535id;

    @JSONField(name = WsConstants.KEY_PAYLOAD)
    public String payload;

    @JSONField(name = "type")
    public String type;

    public NdefReadNdefMessagePluginModel$MessagesItemModel() {
    }
}
