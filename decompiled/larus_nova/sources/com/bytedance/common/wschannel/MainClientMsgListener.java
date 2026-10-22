package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MainClientMsgListener implements ClientMsgParser.ParserListener {
    public MainClientMsgListener() {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r100, boolean r101) {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WsChannelImpl r101 = WsChannelSdk2.getChannel(r100.getChannelId());
        if (r101 == null) goto L8;
        r101.onReceive(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent r100) {
        WsChannelImpl r101 = WsChannelSdk2.getChannel(r100.getChannelId());
        if (r101 == null) goto L6;
        r101.syncServiceState(r100);
        r101.onReceiveServiceConnectEvent(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        WsChannelImpl r102 = WsChannelSdk2.getChannel(r100.mChannelId);
        if (r102 == null) goto L8;
        r102.onReceiveConnectEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg r100, boolean r101) {
        WsChannelImpl r102 = WsChannelSdk2.getChannel(r100.getChannelId());
        if (r102 == null) goto L6;
        r102.replySendMsgResult(r100, r101);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int r100, ConnectionState r101, boolean r102) {
        WsChannelImpl r103 = WsChannelSdk2.getChannel(r100);
        if (r103 == null) goto L6;
        r103.syncState(r101, r102);
        return;
    }
}
