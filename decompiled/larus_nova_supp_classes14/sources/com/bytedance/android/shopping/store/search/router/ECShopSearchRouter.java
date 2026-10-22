package com.bytedance.android.shopping.store.search.router;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import kotlin.jvm.internal.Intrinsics;
import vj3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSearchRouter implements c {
    public ECShopSearchRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/store/search";
    }

    public final boolean c(final Context r3, final Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        if (HybridPageConfigSetting.d == false) goto L5;
        ak3.a.b.b(r3, (b) HybridPageConfigSetting.a.getValue());
    L5:
        n.b(r3, r5, null, new ECShopSearchRouter$open$1(r4, r3), ECShopSearchRouter$open$2.INSTANCE);
        return true;
    }
}
