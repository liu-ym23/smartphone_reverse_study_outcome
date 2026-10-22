package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends qf3.a {
    public final String getName() {
        return "ec.getRealRecommendInfo";
    }

    public v(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r3, qf3.d r4, Map<String, ? extends Object> r5, IDLXBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Object r7 = r5.get("recommendInfoPlaceholder");
        Object r1 = null;
        if ((r7 instanceof String) == true) goto L5;
        r7 = null;
    L5:
        String r8 = (String) r7;
        if (r8 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        LinkedHashMap r9 = new LinkedHashMap();
        qf3.c.b(r9, "recommendInfoPlaceholder is empty");
        c(r6, r9);
        return;
    L15:
        Object r10 = r5.get("isCacheData");
        if ((r10 instanceof Boolean) == false) goto L19;
        r1 = r10;
    L19:
        String r11 = r4.b.A1.AH(r8, Intrinsics.areEqual((Boolean) r1, Boolean.TRUE));
        if (r11 == null) goto L22;
        f(r6, MapsKt.mapOf(TuplesKt.to("recommendInfo", r11)));
        return;
    L22:
        f(r6, MapsKt.emptyMap());
        return;
    L8:
        if (r8.length() == 0) goto L11;
        r0 = false;
        goto L12
    }
}
