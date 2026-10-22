package com.bytedance.ee.bear.document;

import com.alibaba.fastjson.JSON;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i5 implements com.bytedance.ee.bear.lynx.api.g {
    public final vv4.k a;
    public final Map<String, tb5.m> b;

    public static final class a {
    }

    static {
    }

    public i5(vv4.k r2) {
        Intrinsics.checkNotNullParameter(r2, "web");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bridgeName");
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.b("LynxWebDelegateImpl", "callJSBridgeCallback, bridgeName = " + r3 + ", params = " + r4);
        tb5.m r5 = (tb5.m) ((LinkedHashMap) this.b).get(r3);
        if (r5 == null) goto L6;
        r5.b(JSON.parseObject(r4));
        return;
    }

    public final void c(String r2, tb5.m r3) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        Intrinsics.checkNotNullParameter(r3, "callBackFunction");
        this.b.put(r2, r3);
    }

    public final void b(String r3, String r4, te5.b.a r5) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        tt5.a.b("LynxWebDelegateImpl", "execJSMethod, method = " + r3 + ", params = " + r4);
        this.a.a(r3, JSON.parseObject(r4), r5);
    }
}
