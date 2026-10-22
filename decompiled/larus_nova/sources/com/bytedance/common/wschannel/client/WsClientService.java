package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class WsClientService extends AbsWsClientService {
    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg r100, boolean r101) {
    }

    public WsClientService() {
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r100) {
        if (r100 == null) goto L17;
        OnMessageReceiveListener r101 = WsConstants.getListener(r100.getChannelId());     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
    L8:
        WsConstants.getMessageAckListener();     // Catch: Throwable -> L10
    L13:
        return;
    L6:
        if (r100.isAckMsg() == true) goto L8;
        r101.onReceiveMsg(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(th.toString());
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WsConstants.setServiceState(r100);
        WsConstants.getServiceConnectListener();
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        OnMessageReceiveListener r102 = WsConstants.getListener(r100.mChannelId);
        if (r102 == null) goto L8;
        r102.onReceiveConnectEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r100, boolean r101) {
        super.onSendResult(r100, r101);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int r100, ConnectionState r101, boolean r102) {
        WsConstants.setConnectionState(r100, r101, r102);
    }
}
