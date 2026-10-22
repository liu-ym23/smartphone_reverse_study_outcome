package com.bytedance.android.shopping.pre_purchase.arch.launch;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final CopyOnWriteArrayList<d> a;
    public g<?, ?> b;
    public g<?, ?> c;
    public final Lazy d;
    public final ChainName e;
    public final e f;
    public final j g;

    public final Monitor a() {
        return (Monitor) this.d.getValue();
    }

    public final void b(Throwable r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).i(r3);
        goto L4
    L6:
        a().i(r3);
    }

    public c(ChainName r2, e r3, com.bytedance.android.shopping.anchorv4.launcher.a r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "launchContext");
        Intrinsics.checkNotNullParameter(r4, "input");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new CopyOnWriteArrayList();
        this.d = LazyKt.lazy(new LaunchChain$launchMonitor$2(this));
    }
}
