package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements q {
    public final Function2<x, Boolean, Boolean> a;
    public final Function2<x, Boolean, Boolean> b;
    public final Function1<x, i> c;

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final i a(x r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Function1<x, i> r0 = this.c;
        if (r0 == null) goto L7;
        i r3 = (i) r0.invoke(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return i.b.a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean b(x r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Function2<x, Boolean, Boolean> r0 = this.a;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return ((Boolean) r0.invoke(r2, Boolean.valueOf(r3))).booleanValue();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean c(x r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Function2<x, Boolean, Boolean> r0 = this.b;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return ((Boolean) r0.invoke(r2, Boolean.valueOf(r3))).booleanValue();
    }

    public j(Function2 r1, Function2 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
