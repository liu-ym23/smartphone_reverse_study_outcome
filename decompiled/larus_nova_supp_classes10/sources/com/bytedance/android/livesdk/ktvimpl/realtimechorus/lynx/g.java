package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ DataCenter a;

    public g(DataCenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        IBaseBrowserService r0 = jc1.k.f(IBaseBrowserService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideRegisterWRDSMethod(this.a);
    }
}
