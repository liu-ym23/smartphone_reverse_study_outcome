package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements CoroutineScope, d {
    public final Lifecycle a;
    public final CoroutineContext b;

    public final CoroutineContext getCoroutineContext() {
        return this.b;
    }

    public c(Lifecycle r2, CoroutineContext r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "coroutineContext");
        this.a = r2;
        this.b = r3;
        if (r2.b() != Lifecycle.State.DESTROYED) goto L6;
        JobKt.cancel$default(r3, null, 1, null);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(e r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.a.b().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        this.a.c(this);
        JobKt.cancel$default(this.b, null, 1, null);
        return;
    }
}
