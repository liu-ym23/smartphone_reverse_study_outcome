package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements d {
    public e() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r1, BearUrl r2, RouteBean r3) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        int r4 = com.ss.android.lark.router.c.a;
        com.ss.android.lark.router.c.b(LarkContext.getApplication(), r2.e);
        return true;
    }
}
