package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.browser.IBaseBrowserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ m a;

    public o(m r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return jc1.k.n(IBaseBrowserService.class).provideGetLiveNtpTimeMethod(this.a.b);
    }
}
