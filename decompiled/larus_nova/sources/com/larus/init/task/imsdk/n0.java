package com.larus.init.task.imsdk;

import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.larus.im.ws.FlowWsConnectionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 implements OnMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xf9.g f351389a;

    public n0(com.larus.im.network.d r100) {
        this.f351389a = r100;
    }

    @Override // com.bytedance.common.wschannel.app.OnMessageReceiveListener
    public final void onReceiveMsg(WsChannelMsg r110) {
        xf9.g r100 = this.f351389a;
        if (r110 == null) goto L15;
        List<WsChannelMsg.MsgHeader> r101 = r110.getMsgHeaders();
        if (r101 != null) goto L7;
        r101 = CollectionsKt.emptyList();
    L7:
        List<WsChannelMsg.MsgHeader> r102 = r101;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        WsChannelMsg.MsgHeader r104 = (WsChannelMsg.MsgHeader) r103.next();
        r111.add(new xf9.b(r104.getKey(), r104.getValue()));
        goto L9
    L11:
        int r105 = r110.getChannelId();
        int r106 = r110.getService();
        int r107 = r110.getMethod();
        byte[] r108 = r110.getPayload();
        if (r108 != null) goto L14;
        r108 = new byte[0];
    L14:
        xf9.a r109 = new xf9.a(r105, r106, r107, r108, r110.getSeqId(), r110.getUUID(), r111);
    L16:
        r100.a(r109);
        return;
    L15:
        r109 = null;
        goto L16
    }

    @Override // com.bytedance.common.wschannel.app.OnMessageReceiveListener
    public final void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101) {
        xf9.g r102 = this.f351389a;
        if (r100 == null) goto L22;
        ConnectionState r103 = r100.connectionState;
        if (r103 != null) goto L7;
        int r104 = -1;
    L9:
        if (r104 != 1) goto L11;
        FlowWsConnectionState r105 = FlowWsConnectionState.CONNECTING;
    L21:
        xf9.e r106 = new xf9.e(r100.mChannelId, r105, r100.mType.getVal());
    L23:
        r102.b(r106);
        return;
    L11:
        if (r104 != 2) goto L13;
        r105 = FlowWsConnectionState.CONNECTED;
        goto L21
    L13:
        if (r104 != 3) goto L15;
        r105 = FlowWsConnectionState.CONNECT_CLOSED;
        goto L21
    L15:
        if (r104 == 4) goto L17;
        r105 = FlowWsConnectionState.UNKNOWN;
        goto L21
    L17:
        r105 = FlowWsConnectionState.CONNECT_FAILED;
        goto L21
    L7:
        r104 = p0.f351393a[r103.ordinal()];
        goto L9
    L22:
        r106 = null;
        goto L23
    }
}
