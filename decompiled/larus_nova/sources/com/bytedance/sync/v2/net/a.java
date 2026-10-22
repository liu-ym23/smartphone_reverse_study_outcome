package com.bytedance.sync.v2.net;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
import fg7.f;
import org.json.JSONException;
import org.json.JSONObject;
import xf7.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends NetTrace {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f270445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f270446f;

    @Override // com.bytedance.sync.v2.net.NetTrace
    public final void a() {
        JSONObject r100 = new JSONObject();
        eg7.a.a(r100, "send_method", this.f270441a);
        eg7.a.a(r100, WsConstants.KEY_SEND_RESULT, this.f270442b);
        r100.put("is_foreground", this.f270445e);     // Catch: JSONException -> L5
    L7:
        eg7.a.a(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME, this.f270446f);
        eg7.a.a(r100, "send_msg_type", this.f270443c);
        eg7.a.a(r100, "ws_connect", this.f270444d);
        t.a("sync_sdk_compensator_net_monitor", r100, null, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public a(boolean r100, f r101) {
        this.f270445e = r100;
        if (r101 == null) goto L5;
        int r102 = r101.e();
    L6:
        this.f270446f = r102;
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
