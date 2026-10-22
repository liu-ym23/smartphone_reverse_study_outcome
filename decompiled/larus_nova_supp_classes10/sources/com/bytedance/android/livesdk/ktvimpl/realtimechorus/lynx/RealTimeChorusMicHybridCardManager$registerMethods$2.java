package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.y;
import com.bytedance.android.livesdkapi.service.MessageHub;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RealTimeChorusMicHybridCardManager$registerMethods$2 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final Lazy a;
    public final /* synthetic */ c b;
    public final /* synthetic */ MessageHub c;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return (y) this.a.getValue();
    }

    public RealTimeChorusMicHybridCardManager$registerMethods$2(c r1, MessageHub r2) {
        this.b = r1;
        this.c = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RealTimeChorusMicHybridCardManager$registerMethods$2$registerMethod$2(this));
    }
}
