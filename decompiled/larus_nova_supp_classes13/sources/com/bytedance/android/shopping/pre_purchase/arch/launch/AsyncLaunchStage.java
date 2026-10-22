package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class AsyncLaunchStage<I extends j, O extends j> extends g<I, O> {
    public abstract void e(e r1, I r2, Function1<? super f<? extends O>, Unit> r3);

    public AsyncLaunchStage() {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.i
    public final void a(final e r2, I r3) {
        Intrinsics.checkNotNullParameter(r2, "launchContext");
        Intrinsics.checkNotNullParameter(r3, "input");
        c(r2, r3);
        e(r2, r3, new AsyncLaunchStage$execute$1(this, r2));
    }
}
