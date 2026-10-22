package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends qf3.e {
    public final String d;

    public final String getName() {
        return this.d;
    }

    public n(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.showToast";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r8, IBDXBridgeContext r9, Map<String, ? extends Object> r10, Map<String, Object> r11) {
        Intrinsics.checkNotNullParameter(r8, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "result");
        Object r12 = r10.get("content");
        Object r0 = null;
        if ((r12 instanceof String) == true) goto L5;
        r12 = null;
    L5:
        String r2 = (String) r12;
        int r13 = 0;
        if (r2 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        if (r14 == false) goto L16;
        return TuplesKt.to(Boolean.FALSE, "content is empty");
    L16:
        if (Intrinsics.areEqual(r10.get("gravity"), "top") == false) goto L18;
        int r3 = 48;
    L19:
        Object r15 = r10.get("xOffset");
        if ((r15 instanceof Integer) == true) goto L22;
        r15 = null;
    L22:
        Integer r16 = (Integer) r15;
        if (r16 == null) goto L25;
        int r17 = r16.intValue();
    L26:
        Object r1 = r10.get("yOffset");
        if ((r1 instanceof Integer) == true) goto L29;
        r1 = null;
    L29:
        Integer r4 = (Integer) r1;
        if (r4 == null) goto L32;
        r13 = r4.intValue();
    L32:
        Object r18 = r10.get("duration");
        if ((r18 instanceof Integer) == false) goto L36;
        r0 = r18;
    L36:
        Integer r5 = (Integer) r0;
        if (r5 == null) goto L39;
        int r6 = r5.intValue();
    L48:
        int r19 = com.bytedance.android.shopping.mall.widget.b.h;     // Catch: Exception -> L42
        com.bytedance.android.shopping.mall.widget.b.a.a(r8.a, r2, r3, b0.c(Integer.valueOf(r17)), b0.c(Integer.valueOf(r13)), r6);     // Catch: Exception -> L42
        return TuplesKt.to(Boolean.TRUE, "show toast success.");
    L42:
        e = move-exception;
        if (HybridAppInfoService.p.isLocalTest() == true) goto L47;
        EnsureManager.ensureNotReachHere(e);
        return TuplesKt.to(Boolean.FALSE, String.valueOf(e.getMessage()));
    L47:
        throw e;
    L39:
        r6 = 3000;
        goto L48
    L25:
        r17 = 0;
        goto L26
    L18:
        r3 = 17;
        goto L19
    L8:
        if (r2.length() == 0) goto L11;
        r14 = false;
        goto L12
    }
}
