package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class RenderLifecycleDispatcher implements e {
    public final List<e> a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.invoke((e) r1.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        C03171 r0 = C03171.INSTANCE;
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.invoke((e) r1.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RenderLifecycleDispatcher(List<? extends e> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.a = r2;
    }
}
