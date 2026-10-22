package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallGetTabFrameJSB extends qf3.e {
    public final String getName() {
        return "ec.mallGetTabFrame";
    }

    public ECMallGetTabFrameJSB(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(final qf3.d r3, IBDXBridgeContext r4, Map<String, ? extends Object> r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "result");
        Object r7 = r5.get("tabID");
        Object r1 = null;
        if ((r7 instanceof String) == true) goto L5;
        r7 = null;
    L5:
        final String r8 = (String) r7;
        Object r9 = r5.get("tabPosition");
        if ((r9 instanceof String) == false) goto L9;
        r1 = r9;
    L9:
        final String r2 = (String) r1;
        p.b(r6, new ECMallGetTabFrameJSB$handleCall$1(r3, r8, r2));
        return qf3.e.f(this);
    }
}
