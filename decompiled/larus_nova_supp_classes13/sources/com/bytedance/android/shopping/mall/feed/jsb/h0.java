package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public h0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallSchemaMonitor";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("scene");
        Object r0 = null;
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        Object r8 = r4.get("params");
        if ((r8 instanceof String) == true) goto L8;
        r8 = null;
    L8:
        String r9 = (String) r8;
        if (r7 == null) goto L20;
        if (r9 == null) goto L20;
        Object r10 = r4.get("contextProvider");
        if ((r10 instanceof String) == true) goto L14;
        r10 = null;
    L14:
        String r11 = (String) r10;
        Object r12 = r4.get("scriptPath");
        if ((r12 instanceof String) == false) goto L18;
        r0 = r12;
    L18:
        String r1 = (String) r0;
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostECSchemaMonitorService();
        return qf3.e.f(this);
    L20:
        return qf3.e.c("scene or params is null");
    }
}
