package com.bytedance.common.wschannel.channel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMessageHandler {
    void onConnection(IWsChannelClient r100, int r101, JSONObject r102);

    void onConnection(IWsChannelClient r100, SocketState r101);

    void onMessage(int r100, WsChannelMsg r101);

    void onMessage(int r100, byte[] r101);

    void onServiceConnectEvent(ServiceConnectEvent r100);

    void replySendMsgResult(WsChannelMsg r100, boolean r101);

    void syncSocketState();

    void tryResendMsg();
}
