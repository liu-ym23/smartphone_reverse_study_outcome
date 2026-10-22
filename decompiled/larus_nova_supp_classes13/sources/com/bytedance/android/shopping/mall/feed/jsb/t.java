package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public t(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.getHomePageMallSource";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L7;
        yj.f r7 = r6.getHybridECSdkService();
        if (r7 == null) goto L7;
        r7.getHomePageMallSource();
        Integer r8 = 0;
    L8:
        r5.put("mallSourceType", r8);
        return qf3.e.f(this);
    L7:
        r8 = null;
        goto L8
    }
}
