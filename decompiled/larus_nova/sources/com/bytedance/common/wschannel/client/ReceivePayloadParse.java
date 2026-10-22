package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public class ReceivePayloadParse extends BaseIntentParse {
    public ReceivePayloadParse(ClientMsgParser.ParserListener r100) {
        super(r100);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        r100.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r102 = (WsChannelMsg) r100.getParcelableExtra(WsConstants.KEY_PAYLOAD);
        if (WsConstants.getOptLogic().get().booleanValue() == true) goto L9;
        Message r103 = new Message();
        r103.getData().putParcelable(WsConstants.KEY_PAYLOAD, r102);
        r103.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r104 = r103.getData().getParcelable(WsConstants.KEY_PAYLOAD);
        if ((r104 instanceof WsChannelMsg) == false) goto L8;
        r102 = (WsChannelMsg) r104;
        goto L9
    L8:
        r102 = null;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r102.toString());
    L13:
        if (r101 == null) goto L15;
        r102.receiveDataFromIpcTs = r101.onReceiveDataFromIpcTs;
    L15:
        this.mListener.onReceive(r102);
    }
}
