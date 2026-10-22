package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends qf3.e {
    public final String getName() {
        return "ecGetAddress";
    }

    public e(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        boolean r6 = new JSONObject(r4).optBoolean("need_detail", false);
        IECMallAddressService r7 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        JSONObject r0 = null;
        if (r7 == null) goto L5;
        r0 = r7.getAddress(r3.getEngineView(), null, !r6);
    L5:
        if (r0 == null) goto L9;
        r5.put("data", r0);
        return qf3.e.f(this);
    L9:
        return qf3.e.c("address result is null");
    }
}
