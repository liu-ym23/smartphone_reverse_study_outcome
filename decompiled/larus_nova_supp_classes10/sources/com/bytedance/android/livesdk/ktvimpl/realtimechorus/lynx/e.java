package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ DataCenter a;

    public e(DataCenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return jc1.k.n(IBaseBrowserService.class).provideRegisterMessageLatchMethod(this.a);
    }
}
