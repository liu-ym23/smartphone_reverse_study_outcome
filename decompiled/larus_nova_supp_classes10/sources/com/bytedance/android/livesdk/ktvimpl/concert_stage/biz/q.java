package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ m a;

    public q(m r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.a.b);
    }
}
