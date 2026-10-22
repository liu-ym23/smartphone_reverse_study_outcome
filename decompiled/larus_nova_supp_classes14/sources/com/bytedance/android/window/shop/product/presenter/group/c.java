package com.bytedance.android.window.shop.product.presenter.group;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements d {
    public final List<d> a;

    @Override // com.bytedance.android.window.shop.product.presenter.group.d
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).a();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "children");
        this.a = r2;
    }
}
