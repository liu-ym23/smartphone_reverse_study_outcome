package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public f0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.lynxCardRemoveByPosition";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("position");
        Integer r7 = null;
        if ((r6 instanceof Number) == true) goto L5;
        r6 = null;
    L5:
        Number r8 = (Number) r6;
        if (r8 == null) goto L8;
        r7 = Integer.valueOf(r8.intValue());
    L8:
        if (r7 == null) goto L20;
        if (r7.intValue() < 0) goto L20;
        ECHybridListEngine r9 = r2.b.J;
        if (r9 == null) goto L18;
        com.bytedance.android.ec.hybrid.list.ability.v r10 = (com.bytedance.android.ec.hybrid.list.ability.v) r9.getAbility(com.bytedance.android.ec.hybrid.list.ability.v.class);
        if (r10 == null) goto L18;
        r10.hB(r7.intValue());
    L18:
        return qf3.e.f(this);
    L20:
        return qf3.e.c("position is invalid");
    }
}
