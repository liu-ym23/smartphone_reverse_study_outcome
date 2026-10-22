package com.ss.android.lark.jsruntime.vmsdk.module;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements com.ss.android.lark.jsruntime.vmsdk.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, WebSocket> f428196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tnb.b f428197b;

    public b() {
        this.f428196a = new ConcurrentHashMap();
    }

    public final void a(int r100, String r101) {
        rnb.c.b("JSRuntimeWebSocketDelegate", "notifyWebSocketFailed() called with: id = [" + r100 + "], message = [" + r101 + "]");
        HashMap r102 = new HashMap();
        r102.put("id", Integer.valueOf(r100));
        r102.put("message", r101);
        b("websocketFailed", r102);
    }

    public final void b(String r100, Map<String, Object> r101) {
        rnb.c.c("JSRuntimeWebSocketDelegate", "sendEvent() called with: eventName = [" + r100 + "]");
        tnb.b r102 = this.f428197b;
        if (r102 == null) goto L6;
        r102.sendEvent(r100, r101);
        return;
    }
}
