package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends qf3.e {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ec.mall.control_popup_resource";
    }

    public d(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("type");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        Object r8 = r4.get("token");
        if ((r8 instanceof String) == true) goto L8;
        r8 = null;
    L8:
        String r9 = (String) r8;
        if (Intrinsics.areEqual(r7, "register") == false) goto L12;
        r2.b.A1.bp();
    L15:
        return TuplesKt.to(Boolean.TRUE, null);
    L12:
        if (Intrinsics.areEqual(r7, "cancel") == false) goto L15;
        r2.b.A1.jO();
        goto L15
    }
}
