package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public x(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallGetReportInfo";
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r4, Map<String, ? extends Object> r5, IDLXBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        LinkedHashMap r7 = new LinkedHashMap();
        Map<String, Object> r0 = this.c.b.j0.c();
        if (r0 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, Object> r2 = r1.next();
        r7.put(r2.getKey(), r2.getValue());
    L8:
        r6.invoke(r7);
        a(r5, r7);
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
