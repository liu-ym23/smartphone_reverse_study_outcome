package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SyncConnectStateParse extends BaseIntentParse {
    public SyncConnectStateParse(ClientMsgParser.ParserListener r100) {
        super(r100);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        Logger.d("AbsWsClientService", "sync socket state");
        r100.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r102 = r100.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r102 == null) goto L10;
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        SocketState r104 = (SocketState) r103.next();
        if (r104 == null) goto L6;
        syncConnectState(r104.getChannelId(), r104.getConnectionState(), r104.isPrivateProtocolEnabled());
        goto L6
    L16:
        return;
    }
}
