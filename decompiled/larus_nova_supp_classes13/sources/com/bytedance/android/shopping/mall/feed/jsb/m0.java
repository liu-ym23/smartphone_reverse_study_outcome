package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public m0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallShowUGPush";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L5;
        Boolean r7 = Boolean.valueOf(r6.isInnerPushShowing());
    L7:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L9;
        r5.put("show", 1);
    L11:
        return qf3.e.f(this);
    L9:
        r5.put("show", 0);
        goto L11
    L5:
        r7 = null;
        goto L7
    }
}
