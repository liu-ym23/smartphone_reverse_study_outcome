package com.bytedance.android.shopping.sku.inner.yata.abilities;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements v96.c {
    public c() {
    }

    public final void a(com.bytedance.kmp.ec.yata.common.error.d r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.b("SkuYataErrorHandler", "onError   code:" + r3.a + "  msg:" + r3.b);
    }
}
