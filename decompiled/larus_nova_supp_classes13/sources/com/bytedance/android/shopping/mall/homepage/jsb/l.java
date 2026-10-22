package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.shopping.api.mall.IECMallShareService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends qf3.a {

    public static final class a implements com.bytedance.android.shopping.api.mall.e {
        public final /* synthetic */ IDLXBridgeMethod.a a;

        public a(IDLXBridgeMethod.a r1) {
            this.a = r1;
        }
    }

    public final String getName() {
        return "share";
    }

    public l(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r2, qf3.d r3, Map<String, ? extends Object> r4, IDLXBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ServiceManager r6 = ServiceManager.get();
        if (r6 == null) goto L8;
        IECMallShareService r7 = (IECMallShareService) r6.getService(IECMallShareService.class);
        if (r7 == null) goto L9;
        r7.directJsbShare(r3.a, com.bytedance.android.ec.hybrid.list.util.k.b(r4), new a(r5));
        return;
    L9:
        return;
    }
}
