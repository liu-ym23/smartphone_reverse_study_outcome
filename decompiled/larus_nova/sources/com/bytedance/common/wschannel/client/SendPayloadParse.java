package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
class SendPayloadParse extends BaseIntentParse {
    public SendPayloadParse(ClientMsgParser.ParserListener r100) {
        super(r100);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        r100.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String r102 = r100.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean r103 = r100.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug() == false) goto L5;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r102 + " sendResult = " + r103);
    L5:
        this.mListener.onSendResult(r102, r103);
    }
}
