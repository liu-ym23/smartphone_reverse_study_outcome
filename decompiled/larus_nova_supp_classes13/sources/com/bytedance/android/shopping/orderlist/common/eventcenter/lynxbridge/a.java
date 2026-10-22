package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.ies.web.jsbridge2.f;
import pd.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements f.b {
    public final /* synthetic */ BridgetLynxComponent a;

    public a(BridgetLynxComponent r1) {
        this.a = r1;
    }

    public final f<Object, Object> a() {
        final BridgetLynxComponent r0 = this.a;
        r0.getClass();
        boolean r1 = ECServiceManager.a;
        e r2 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r2 == null) goto L7;
        pd.f r3 = r2.getExternalJsBridgeMethodInjectorAdapter();
        if (r3 == null) goto L7;
        return r3.d(new BridgetLynxComponent$getSendNativeBridgeCommandResultMethod$1(r0));
    L7:
        return null;
    }
}
