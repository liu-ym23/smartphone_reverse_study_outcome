package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ClientMsgParser extends BaseIntentParse {
    private final Map<String, IntentParse> parseMap;

    public interface ParserListener {
        void onReceive(WsChannelMsg r100);

        void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101);

        void onReceiveServiceEvent(ServiceConnectEvent r100);

        void onSendResult(String r100, boolean r101);

        void replySendMsgResult(WsChannelMsg r100, boolean r101);

        void syncState(int r100, ConnectionState r101, boolean r102);
    }

    public ClientMsgParser(ParserListener r100) {
        super(r100);
        HashMap r101 = new HashMap();
        r101.put(WsConstants.RECEIVE_CONNECTION_ACTION, new ReceiveConnectionActionParse(r100));
        r101.put(WsConstants.SYNC_CONNECT_STATE, new SyncConnectStateParse(r100));
        r101.put(WsConstants.RECEIVE_PROGRESS_ACTION, new ReceiveProgressParse(r100));
        r101.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new ReceivePayloadParse(r100));
        r101.put(WsConstants.SEND_PAYLOAD_ACTION, new SendPayloadParse(r100));
        r101.put(WsConstants.RECEIVE_SERVICE_ACTION, new ReceiveServiceActionParse(r100));
        this.parseMap = Collections.unmodifiableMap(r101);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r100, ClientServiceTrace r101) {
        IntentParse r102 = this.parseMap.get(r100.getAction());     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.parse(r100, r101);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d("AbsWsClientService", "count = " + r100.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L17:
        return;
    L6:
        Logger.e("error action!");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Logger.e("AbsWsClientService", th.toString());
        goto L11
    }
}
