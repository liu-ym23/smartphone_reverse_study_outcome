package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends WebSocketListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f428194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f428195b;

    public a(b r100, int r101) {
        this.f428195b = r100;
        this.f428194a = r101;
    }

    @Override // okhttp3.WebSocketListener
    public final void onMessage(WebSocket r100, ByteString r101) {
        HashMap r102 = new HashMap();
        r102.put("id", Integer.valueOf(this.f428194a));
        r102.put("type", MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING);
        r102.put("data", r101.base64());
        rnb.c.c("JSRuntimeWebSocketDelegate", "onMessage: binary id = " + this.f428194a);
        this.f428195b.b("websocketMessage", r102);
    }

    @Override // okhttp3.WebSocketListener
    public final void onOpen(WebSocket r100, Response r101) {
        Map<Integer, WebSocket> r102 = this.f428195b.f428196a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(Integer.valueOf(this.f428194a), r100);
        HashMap r104 = new HashMap();
        r104.put("id", Integer.valueOf(this.f428194a));
        r104.put("protocol", r101.header("Sec-WebSocket-Protocol", ""));
        this.f428195b.b("websocketOpen", r104);
    }

    @Override // okhttp3.WebSocketListener
    public final void onMessage(WebSocket r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("id", Integer.valueOf(this.f428194a));
        r102.put("type", "text");
        r102.put("data", r101);
        rnb.c.c("JSRuntimeWebSocketDelegate", "onMessage: binary id = " + this.f428194a);
        this.f428195b.b("websocketMessage", r102);
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosed(WebSocket r100, int r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("id", Integer.valueOf(this.f428194a));
        r103.put("code", Integer.valueOf(r101));
        r103.put("reason", r102);
        this.f428195b.b("websocketClosed", r103);
        ((ConcurrentHashMap) this.f428195b.f428196a).remove(Integer.valueOf(this.f428194a));
        rnb.c.d("JSRuntimeWebSocketDelegate", "onClosed: id:" + this.f428194a);
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosing(WebSocket r100, int r101, String r102) {
        rnb.c.d("JSRuntimeWebSocketDelegate", "onClosing() called with: websocket = [" + r100 + "], code = [" + r101 + "], reason = [" + r102 + "]");
        r100.close(r101, r102);
    }

    @Override // okhttp3.WebSocketListener
    public final void onFailure(WebSocket r100, Throwable r101, Response r102) {
        this.f428195b.a(this.f428194a, r101.getMessage());
        ((ConcurrentHashMap) this.f428195b.f428196a).remove(Integer.valueOf(this.f428194a));
        rnb.c.d("JSRuntimeWebSocketDelegate", "onFailure: id:" + this.f428194a);
    }
}
