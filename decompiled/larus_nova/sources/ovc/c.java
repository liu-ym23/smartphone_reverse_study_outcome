package ovc;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes42.dex */
public final class c implements CronetFrontierClient.IConnectionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsChannelClient f527018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f527019b;

    public final boolean a(int r100) {
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L9;
        if (r100 == 4) goto L9;
        return false;
    L9:
        if (this.f527019b.f527003i.get() == true) goto L11;
        return false;
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d("CronetFrontierConnection", "Wait fallback task running and ignore state:" + r100);
        return true;
    L17:
        return true;
    }

    public c(IWsChannelClient r100, a r101) {
        this.f527018a = r100;
        this.f527019b = r101;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public final void onConnectionStateChanged(int r100, String r101) {
        if (r100 != 2) goto L5;
        r100 = 4;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d("CronetFrontierConnection", "PP onConnectionStateChanged state:" + r100 + " url:" + r101);
    L14:
        if (r100 != 4) goto L17;
        this.f527019b.f527005k = false;
    L17:
        if (a(r100) == false) goto L22;
        return;
    L22:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L21
        r102.put("type", 1);     // Catch: Throwable -> L21
        r102.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L21
        r102.put("state", r100);     // Catch: Throwable -> L21
        r102.put("url", r101);     // Catch: Throwable -> L21
        this.f527018a.onConnection(r102);     // Catch: Throwable -> L21
        return;
    L24:
        return;
    L5:
        if (r100 == 3) goto L9;
        if (r100 != 4) goto L12;
        r100 = 3;
        goto L12
    L9:
        r100 = 2;
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public final void onConnectionError(int r100, String r101, String r102) {
        if (r100 != 2) goto L5;
        r100 = 4;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d("CronetFrontierConnection", "PP onConnectionError state:" + r100 + " url:" + r101 + " error:" + r102);
    L15:
        if (a(r100) == false) goto L25;
        return;
    L25:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L24
        r103.put("type", 0);     // Catch: Throwable -> L24
        r103.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L24
        r103.put("state", r100);     // Catch: Throwable -> L24
        r103.put("url", r101);     // Catch: Throwable -> L24
        r103.put("error", r102);     // Catch: Throwable -> L24
        if (b.b(r102, false) == false) goto L22;
        r103.put("error_code", NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L22;
        Logger.d("CronetFrontierConnection", "PP connection timeout.");     // Catch: Throwable -> L24
    L22:
        this.f527018a.onConnection(r103);     // Catch: Throwable -> L24
        return;
    L27:
        return;
    L5:
        if (r100 == 3) goto L9;
        if (r100 != 4) goto L12;
        r100 = 3;
        goto L12
    L9:
        r100 = 2;
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public final void onTrafficChanged(String r100, long r101, long r110, boolean r111) {
        d.a().b(r100, r101, r110, r111);     // Catch: Throwable -> L4
        return;
    }
}
