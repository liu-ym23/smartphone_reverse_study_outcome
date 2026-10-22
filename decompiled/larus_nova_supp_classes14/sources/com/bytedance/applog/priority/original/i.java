package com.bytedance.applog.priority.original;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i<T> implements Lazy<T> {
    public final z<T> a;
    public T b;

    public final T getValue() {
        if (this.b != null) goto L5;
        this.b = (T) this.a.load();
    L5:
        T r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final boolean isInitialized() {
        if (this.b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public i(z<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        this.a = r2;
    }
}
