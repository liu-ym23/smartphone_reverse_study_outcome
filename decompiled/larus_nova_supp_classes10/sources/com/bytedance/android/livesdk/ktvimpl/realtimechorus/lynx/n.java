package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.y;
import com.bytedance.android.livesdkapi.service.MessageHub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ c a;
    public final /* synthetic */ MessageHub b;

    public n(c r1, MessageHub r2) {
        this.a = r1;
        this.b = r2;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new y(this.a.l, this.b);
    }
}
