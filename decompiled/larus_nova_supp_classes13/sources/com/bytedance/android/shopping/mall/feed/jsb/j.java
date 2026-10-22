package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends qf3.e {
    public final String getName() {
        return "mall.deliveryNativeAbilityModify";
    }

    public j(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r6, Map<String, ? extends Object> r7, IDLXBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Object r9 = r7.get("ability");
        Object r1 = null;
        if ((r9 instanceof String) == true) goto L5;
        r9 = null;
    L5:
        String r10 = (String) r9;
        Object r11 = r7.get("action");
        if ((r11 instanceof String) == false) goto L9;
        r1 = r11;
    L9:
        String r2 = (String) r1;
        if (r10 == null) goto L23;
        int r3 = r10.hashCode();
        if (r3 == (-763348009)) goto L21;
        if (r3 != (-259719452)) goto L23;
        if (r10.equals("rollback") == false) goto L23;
        this.c.b.A1.Hn(r10);
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("code", 1);
        r12.put("msg", "success");
        r8.invoke(r12);
        return;
    L21:
        if (r10.equals("smallWindow") == false) goto L23;
        this.c.b.A1.Hn(r10);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("code", 1);
        r13.put("msg", "success");
        r8.invoke(r13);
        return;
    L23:
        String r14 = "ability: " + r10 + "暂未支持";
        Pair[] r4 = new Pair[2];
        r4[0] = TuplesKt.to("code", 0);
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r4[1] = TuplesKt.to("msg", r14);
        r8.invoke(MapsKt.mapOf(r4));
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
