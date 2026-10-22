package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.list.ability.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements t {
    public final ECHybridDataEngine a;

    public final void release() {
    }

    public b(ECHybridDataEngine r1) {
        this.a = r1;
    }

    public final String TS(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        ECHybridDataEngine r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m(r2);
    }
}
