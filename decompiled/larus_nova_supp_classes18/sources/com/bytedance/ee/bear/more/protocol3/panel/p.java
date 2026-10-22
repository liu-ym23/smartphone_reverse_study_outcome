package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@MoreDslMarker
public final class p {
    public final String a;
    public c b;
    public j c;

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        this.a = r2;
    }

    public final void a(Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        b r0 = new b();
        r3.invoke(r0);
        d r4 = r0.a;
        if (r4 == null) goto L7;
        this.b = new c(r4, null, null);
        return;
    L7:
        throw new IllegalArgumentException("CustomFactoryBuilder requires template".toString());
    }

    public final void b(Function1<? super h, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        h r0 = new h();
        r4.invoke(r0);
        this.c = new j(r0.a, r0.b, r0.c);
    }
}
