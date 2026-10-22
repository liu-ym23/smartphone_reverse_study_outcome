package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.b1;
import com.bytedance.android.livesdkapi.service.MessageHub;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ MessageHub a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;

    public h(MessageHub r1, Function2 r2, String r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new b1(this.a, this.b, this.c, this.d);
    }
}
