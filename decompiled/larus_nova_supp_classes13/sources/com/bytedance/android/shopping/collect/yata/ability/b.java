package com.bytedance.android.shopping.collect.yata.ability;

import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements v96.c {
    public final String a;

    public b() {
        this.a = "CollectYataErrorHandler";
    }

    public final void a(com.bytedance.kmp.ec.yata.common.error.d r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.b(this.a, "onError   code:" + r4.a + "  msg:" + r4.b);
    }
}
