package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;

/* JADX INFO: loaded from: classes3.dex */
class ReceiveConnectionActionParse extends BaseIntentParse {
    public ReceiveConnectionActionParse(ClientMsgParser.ParserListener r100) {
        super(r100);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        r100.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r102 = (SocketState) r100.getParcelableExtra(WsConstants.KEY_CONNECTION);
        ConnectionState r103 = syncConnectState(r102.getChannelId(), r102.getConnectionState(), r102.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.mListener.onReceiveConnectEvent(new ConnectEvent(r103, r102.getChannelType(), r102.getChannelId()), r102.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
