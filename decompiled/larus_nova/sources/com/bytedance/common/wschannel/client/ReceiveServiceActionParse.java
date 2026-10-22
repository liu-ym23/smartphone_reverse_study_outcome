package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiveServiceActionParse extends BaseIntentParse {
    public ReceiveServiceActionParse(ClientMsgParser.ParserListener r100) {
        super(r100);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        r100.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r102 = (ServiceConnectEvent) r100.getParcelableExtra("service");
        this.mListener.onReceiveServiceEvent(r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
