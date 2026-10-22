package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public a0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.negfeedback_click";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Logger.d("puffone-NativeCommerceHomePage.initListEngine()", "负反馈: " + r4);
        if (r2.b.A1.isAttached() == false) goto L9;
        if (r4.isEmpty() == true) goto L9;
        r2.b.u0(r4);
        return qf3.e.f(this);
    L9:
        return qf3.e.c("container is not attached or params is empty");
    }
}
