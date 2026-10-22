package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class k<I extends j, O extends j> extends g<I, O> {
    public abstract f<O> e(e r1, I r2);

    public k() {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.i
    public final void a(e r2, I r3) {
        Intrinsics.checkNotNullParameter(r2, "launchContext");
        Intrinsics.checkNotNullParameter(r3, "input");
        c(r2, r3);
        d(r2, e(r2, r3));
    }
}
