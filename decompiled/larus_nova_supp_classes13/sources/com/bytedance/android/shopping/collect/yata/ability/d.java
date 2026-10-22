package com.bytedance.android.shopping.collect.yata.ability;

import android.content.Context;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import kotlin.jvm.internal.Intrinsics;
import v96.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements g {
    public final Context a;

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        int r0 = SkuCommonToast.a;
        SkuCommonToast.b(this.a, r2);
    }

    public d(Context r2, CollectYataFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r2;
    }
}
