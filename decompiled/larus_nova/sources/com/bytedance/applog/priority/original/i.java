package com.bytedance.applog.priority.original;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i<T> implements Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f192740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f192741b;

    @Override // kotlin.Lazy
    public final T getValue() {
        if (this.f192741b != null) goto L5;
        this.f192741b = this.f192740a.load();
    L5:
        T r100 = this.f192741b;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f192741b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public i(z<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        this.f192740a = r100;
    }
}
