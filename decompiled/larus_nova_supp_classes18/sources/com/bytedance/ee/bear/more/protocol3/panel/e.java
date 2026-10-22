package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements t {
    public final Map<String, e0> a;
    public final Map<String, q> b;

    public e() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.t
    public final q a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Map<String, q> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (q) r1.get(s.a(r2));
    }

    public final e0 c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Map<String, e0> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (e0) r1.get(s.a(r2));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.t
    public final void b(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.b.put(s.a(r2), r3);
    }

    public final void d(String r2, e0 r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.a.put(s.a(r2), r3);
    }
}
