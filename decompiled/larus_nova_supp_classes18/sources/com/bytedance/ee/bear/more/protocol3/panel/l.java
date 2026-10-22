package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@MoreDslMarker
public final class l {
    public ItemUIStyle a;
    public final List<m> b;

    public l() {
        this.a = ItemUIStyle.FEISHU;
        this.b = new ArrayList();
    }

    public final void a(MoreGroup r3, Function1<? super n, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "group");
        Intrinsics.checkNotNullParameter(r4, "init");
        n r0 = new n(r3);
        r4.invoke(r0);
        List<m> r5 = this.b;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new m(r0.a, CollectionsKt.toList(r0.b)));
    }
}
