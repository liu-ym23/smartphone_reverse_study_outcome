package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements d {
    public e() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        Intrinsics.checkNotNullParameter(r101, "bearUrl");
        int r103 = com.ss.android.lark.router.c.f439675a;
        com.ss.android.lark.router.c.b(LarkContext.getApplication(), r101.f222564e);
        return true;
    }
}
