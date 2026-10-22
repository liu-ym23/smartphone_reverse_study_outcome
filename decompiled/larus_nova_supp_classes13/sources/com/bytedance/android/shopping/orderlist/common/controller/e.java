package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.store.core.a {
    public final /* synthetic */ OrderBottomBarHandler a;

    public e(OrderBottomBarHandler r1) {
        this.a = r1;
    }

    public final void c(com.bytedance.kmp.ec.yata.store.core.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "modifier");
        Map r3 = r2.d();
        if (r3 == null) goto L5;
        Object r4 = r3.get("is_bottom_bar");
    L7:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L10;
        this.a.b = true;
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
