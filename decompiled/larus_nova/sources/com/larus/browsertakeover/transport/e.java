package com.larus.browsertakeover.transport;

import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends WebSocketListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f319686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f319687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BrowserTransport.a f319688c;

    @Override // okhttp3.WebSocketListener
    public final void onMessage(WebSocket r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webSocket");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (this.f319686a.f319678c.get() == this.f319687b) goto L5;
        return;
    L5:
        if (this.f319686a.f319681f == true) goto L9;
        this.f319688c.onMessage(r101);
        return;
    }

    @Override // okhttp3.WebSocketListener
    public final void onOpen(WebSocket r100, Response r101) {
        Intrinsics.checkNotNullParameter(r100, "webSocket");
        Intrinsics.checkNotNullParameter(r101, "response");
        if (this.f319686a.f319678c.get() == this.f319687b) goto L5;
    L9:
        r100.close(1000, "stale connection");
        return;
    L5:
        if (this.f319686a.f319681f == true) goto L9;
        this.f319686a.f319680e = r100;
        this.f319688c.onConnected();
    }

    public e(d r100, int r101, com.larus.browsertakeover.cdp.a r102) {
        this.f319686a = r100;
        this.f319687b = r101;
        this.f319688c = r102;
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosed(WebSocket r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webSocket");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (this.f319686a.f319678c.get() == this.f319687b) goto L5;
        return;
    L5:
        if (this.f319686a.f319681f == true) goto L10;
        this.f319686a.f319680e = null;
        this.f319688c.onDisconnected();
        return;
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosing(WebSocket r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webSocket");
        Intrinsics.checkNotNullParameter(r102, "reason");
        r100.close(1000, "peer closing");
    }

    @Override // okhttp3.WebSocketListener
    public final void onFailure(WebSocket r100, Throwable r101, Response r102) {
        Intrinsics.checkNotNullParameter(r100, "webSocket");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if (this.f319686a.f319678c.get() == this.f319687b) goto L5;
        return;
    L5:
        if (this.f319686a.f319681f == true) goto L13;
        Integer r103 = null;
        this.f319686a.f319680e = null;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("Websocket failed, type=");
        r105.append(r101.getClass().getSimpleName());
        r105.append(", status=");
        if (r102 == null) goto L10;
        r103 = Integer.valueOf(r102.code());
    L10:
        r105.append(r103);
        r104.e("CloudWebSocketTransport", r105.toString());
        this.f319688c.onError();
        return;
    }
}
