package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DataFetchLifecycleDispatcher implements a {
    public final List<a> a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        a(DataFetchLifecycleDispatcher$onQueryStart$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataFetchLifecycleDispatcher(List<? extends a> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.a = r2;
    }

    public final void a(Function1<? super a, Unit> r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke((a) r0.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(final k.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        a(new DataFetchLifecycleDispatcher$onQueryFailed$1(r2));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(final k.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        a(new DataFetchLifecycleDispatcher$onQuerySuccess$1(r2));
    }
}
