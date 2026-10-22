package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@MoreDslMarker
public final class n {
    public final MoreGroup a;
    public final List<o> b;

    public n(MoreGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "group");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        List<o> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new o(r4, null, null));
    }

    public final void b(String r4, Function1<? super p, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        Intrinsics.checkNotNullParameter(r5, "init");
        p r0 = new p(r4);
        r5.invoke(r0);
        List<o> r6 = this.b;
        ArrayList r7 = (ArrayList) r6;
        r7.add(new o(r0.a, r0.b, r0.c));
    }
}
