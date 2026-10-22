package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseIntentParse implements IntentParse {
    protected final ClientMsgParser.ParserListener mListener;

    public BaseIntentParse(ClientMsgParser.ParserListener r100) {
        this.mListener = r100;
    }

    public ConnectionState syncConnectState(int r100, int r101, boolean r102) {
        ConnectionState r103 = ConnectionState.CONNECTION_UNKNOWN;
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L9;
        r103 = ConnectionState.CONNECTING;
        goto L18
    L9:
        if (r101 != 2) goto L12;
        r103 = ConnectionState.CONNECT_FAILED;
        goto L18
    L12:
        if (r101 != 3) goto L15;
        r103 = ConnectionState.CONNECT_CLOSED;
        goto L18
    L15:
        if (r101 != 4) goto L18;
        r103 = ConnectionState.CONNECTED;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r101 + " connectionState = " + r103);
    L20:
        this.mListener.syncState(r100, r103, r102);
        return r103;
    }
}
