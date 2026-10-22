package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements IMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f270287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f270288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BdpWsClient.a f270289c;

    public i(h r100) {
        this.f270289c = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onFeedBackLog(String r100) {
        if (this.f270289c != null) goto L36;
        return;
    L36:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L7
    L8:
        int r102 = r101.optInt("ws_state", -1);
        if (r102 != (-1)) goto L11;
        return;
    L11:
        if (r102 != 0) goto L29;
        if (r101.optBoolean("using_quic") == false) goto L15;
        String r103 = "quic";
    L42:
        JSONObject r104 = new JSONObject(this.f270288b);     // Catch: Exception -> L19
    L40:
        r104.put("__MP_RESP_HEADER", r101.optString(MonitorConstants.RESPONSE_HEADER));     // Catch: Exception -> L33
    L38:
        r104.put("__MP_TRANSPORT_PROTOCOL", r103);     // Catch: Exception -> L34
    L44:
        r104.put("__MP_LOG", r101);     // Catch: JSONException -> L35
    L26:
        this.f270289c.c(4, this.f270287a, String.valueOf(r104));
        return;
    L19:
        r104 = new JSONObject();
        goto L40
    L15:
        r103 = "tcp";
        goto L42
    L29:
        if (r102 == 1) goto L31;
        if (r102 == 3) goto L31;
        return;
    L31:
        String r105 = r101.optString("ws_error");
        this.f270289c.c(3, this.f270287a, r105);
        return;
    L7:
        r101 = new JSONObject();
        goto L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onMessage(byte[] r100, int r101) {
        BdpWsClient.a r102 = this.f270289c;
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = 1;
        if (r101 == 1) goto L12;
        r103 = 2;
        if (r101 == 2) goto L12;
        r103 = 0;
    L12:
        r102.onMessage(r100, r103);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onConnection(int r100, String r101, JSONObject r102) {
        if (this.f270289c != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L7;
        String r103 = String.valueOf(r102);
    L9:
        if (r100 != 4) goto L11;
    L17:
        this.f270287a = r101;
        this.f270288b = r103;
        return;
    L11:
        if (r100 == 3) goto L17;
        if (r100 == 2) goto L17;
        this.f270289c.c(r100, r101, r103);
        return;
    L7:
        r103 = SliceInitService.DEFAULT_SWITCH;
        goto L9
    }
}
