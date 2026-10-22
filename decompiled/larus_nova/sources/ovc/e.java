package ovc;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends TTWebsocketConnection.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsChannelClient f527021a;

    public e(IWsChannelClient r100) {
        this.f527021a = r100;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onConnectionStateChanged(TTWebsocketConnection r100, int r101, String r102) {
        if (r101 == (-1)) goto L9;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L11;
        r101 = 6;
    L11:
        if (Logger.debug() == false) goto L16;
        Logger.d("CronetFrontierConnection", "WS onConnectionStateChanged state:" + r101 + " url:" + r102);
    L16:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L15
        r103.put("type", 1);     // Catch: Throwable -> L15
        r103.put("state", r101);     // Catch: Throwable -> L15
        r103.put("url", r102);     // Catch: Throwable -> L15
        this.f527021a.onConnection(r103);     // Catch: Throwable -> L15
        return;
    L18:
        return;
    L8:
        r101 = 1;
        goto L11
    L9:
        r101 = 0;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onMessageReceived(TTWebsocketConnection r100, ByteBuffer r101, int r102) throws Exception {
        byte[] r103 = new byte[r101.capacity()];
        r101.get(r103);     // Catch: Throwable -> L5
        this.f527021a.onMessage(r103);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onConnectionError(TTWebsocketConnection r100, int r101, String r102, String r103) {
        if (r101 == (-1)) goto L9;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L11;
        r101 = 6;
    L11:
        if (Logger.debug() == false) goto L21;
        Logger.d("CronetFrontierConnection", "WS onConnectionError state:" + r101 + " url:" + r102 + " error:" + r103);
    L21:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L20
        r104.put("type", 0);     // Catch: Throwable -> L20
        r104.put("state", r101);     // Catch: Throwable -> L20
        r104.put("url", r102);     // Catch: Throwable -> L20
        r104.put("error", r103);     // Catch: Throwable -> L20
        if (b.b(r103, true) == false) goto L18;
        r104.put("error_code", NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L20
        if (Logger.debug() == false) goto L18;
        Logger.d("CronetFrontierConnection", "WS connection timeout.");     // Catch: Throwable -> L20
    L18:
        this.f527021a.onConnection(r104);     // Catch: Throwable -> L20
        return;
    L23:
        return;
    L8:
        r101 = 1;
        goto L11
    L9:
        r101 = 0;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onTrafficChanged(TTWebsocketConnection r100, String r101, long r110, long r111, boolean r112) {
        d.a().b(r101, r110, r111, r112);     // Catch: Throwable -> L4
        return;
    }
}
