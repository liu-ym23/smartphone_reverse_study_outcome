package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public k0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallSendAction";
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r7, Map<String, ? extends Object> r8, IDLXBridgeMethod.a r9) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Object r10 = r8.get("action");
        if ((r10 instanceof String) == true) goto L5;
        r10 = null;
    L5:
        String r11 = (String) r10;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        Object r0 = r8.get("instant_or_wind");
        if ((r0 instanceof Boolean) == true) goto L11;
        r0 = null;
    L11:
        boolean r1 = Intrinsics.areEqual((Boolean) r0, Boolean.TRUE);
        if (r11.length() != 0) goto L14;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("code", 0);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("err_message", "params is empty");
        Unit r4 = Unit.INSTANCE;
        r12.put("data", r3);
    L19:
        r9.invoke(r12);
        a(r8, r12);
        return;
    L18:
        this.c.b.X(r11, r1, null);
        r12 = new LinkedHashMap();
        r12.put("code", 1);
        goto L19
    L14:
        r2 = false;
        goto L16
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return qf3.e.f(this);
    }
}
