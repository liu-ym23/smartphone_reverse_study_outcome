package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface OnMessageReceiveListener {
    void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101);

    void onReceiveMsg(WsChannelMsg r100);
}
