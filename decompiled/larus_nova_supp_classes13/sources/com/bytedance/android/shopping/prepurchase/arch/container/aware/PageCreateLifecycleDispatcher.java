package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PageCreateLifecycleDispatcher implements b {
    public final List<b> a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        PageCreateLifecycleDispatcher$onPageCreateFinish$1 r0 = PageCreateLifecycleDispatcher$onPageCreateFinish$1.INSTANCE;
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.invoke((b) r1.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        PageCreateLifecycleDispatcher$onPageCreateStart$1 r0 = PageCreateLifecycleDispatcher$onPageCreateStart$1.INSTANCE;
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.invoke((b) r1.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageCreateLifecycleDispatcher(List<? extends b> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.a = r2;
    }
}
