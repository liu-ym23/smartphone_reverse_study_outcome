package jg7;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.net.NetTrace;
import org.json.JSONObject;
import xf7.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends NetTrace {
    @Override // com.bytedance.sync.v2.net.NetTrace
    public final void a() {
        JSONObject r100 = new JSONObject();
        eg7.a.a(r100, "send_method", this.f270441a);
        eg7.a.a(r100, WsConstants.KEY_SEND_RESULT, this.f270442b);
        eg7.a.a(r100, "send_msg_type", this.f270443c);
        eg7.a.a(r100, "ws_connect", this.f270444d);
        t.a("sync_sdk_socket_percentage", r100, null, null);
    }

    public a() {
    }
}
