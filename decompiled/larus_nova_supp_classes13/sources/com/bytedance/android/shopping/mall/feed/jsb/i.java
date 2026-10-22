package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public i(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.deepFeedPreParseUrl";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("url");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        IECMallHostService r9 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r9 == null) goto L19;
        r9.preloadDeepFeedSchema(r7);
    L19:
        return qf3.e.f(this);
    L14:
        return qf3.e.c("url is null or empty");
    L8:
        if (r7.length() == 0) goto L11;
        r8 = false;
        goto L12
    }
}
