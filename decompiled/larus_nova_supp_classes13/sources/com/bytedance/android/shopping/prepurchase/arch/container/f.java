package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<STATE extends h, STORE> {
    public final og3.c a;
    public final xi.b b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h c;
    public final i d;
    public final pg3.c<STATE, STORE> e;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.f f;

    public f(b<STATE, STORE> r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.a = r3.f;
        xi.b r0 = r3.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logService");
    L5:
        this.b = r0;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.h r1 = r3.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("eventTrackerService");
    L8:
        this.c = r1;
        i r2 = r3.c;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("monitorService");
    L11:
        this.d = r2;
        pg3.c<STATE, STORE> r4 = r3.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startFlowFactory");
    L14:
        this.e = r4;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.f r5 = r3.e;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
    L17:
        this.f = r5;
    }
}
