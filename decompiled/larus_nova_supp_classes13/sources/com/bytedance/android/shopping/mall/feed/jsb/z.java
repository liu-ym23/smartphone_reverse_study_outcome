package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public z(qf3.d r3) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter("ec.mallInstantHandleEnd", "name");
        super(r3);
        this.d = "ec.mallInstantHandleEnd";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        ECMallFeed r6 = r2.b;
        r6.U(r6.w0);
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
