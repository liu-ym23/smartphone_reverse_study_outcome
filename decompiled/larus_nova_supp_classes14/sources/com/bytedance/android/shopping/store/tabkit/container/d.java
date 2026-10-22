package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    static {
    }

    public static void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = com.bytedance.android.ec.store.utils.h.a;
        if (hk3.e.a() == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        ShoppingAsyncInflater.a r2 = ShoppingAsyncInflater.e;
        Context r5 = th.a.e(r4, true);
        r2.getClass();
        com.bytedance.android.ec.opt.asyncInflate.d r6 = ShoppingAsyncInflater.a.a(r5).a();
        r6.c(2131560981, 7, "ec_tabkit_tab_layout_item");
        r6.c(2131560979, 1, "ec_tabkit_fragment_h5");
        r6.commit();
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
