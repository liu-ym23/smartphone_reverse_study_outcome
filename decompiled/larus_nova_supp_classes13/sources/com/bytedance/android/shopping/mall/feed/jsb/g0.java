package com.bytedance.android.shopping.mall.feed.jsb;

import android.content.Context;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // qf3.c
    public final boolean canRunInBackground() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.enableJsbAsync() != true) goto L7;
        return true;
    }

    public final String getName() {
        return this.d;
    }

    public g0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.saveDataToStorage";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r3, IBDXBridgeContext r4, Map<String, ? extends Object> r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "result");
        Object r7 = r5.get("key");
        Object r8 = r5.get("value");
        if (r8 == null) goto L5;
        String r9 = com.bytedance.android.ec.hybrid.list.util.k.d(r8);
    L7:
        if ((r7 instanceof String) == false) goto L12;
        if ((r9 instanceof String) == false) goto L12;
        Context r10 = r3.a;
        String r11 = (String) r7;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        com.bytedance.android.shopping.mall.homepage.tools.q.b();
        com.bytedance.android.shopping.mall.homepage.tools.q.c(r10, "ec_mall_lynx_cache").edit().putString(r11, r9).putLong(r11 + "_create_time", -1).apply();
    L12:
        return qf3.e.f(this);
    L5:
        r9 = null;
        goto L7
    }
}
