package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ DataCenter a;

    public f(DataCenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.a);
    }
}
