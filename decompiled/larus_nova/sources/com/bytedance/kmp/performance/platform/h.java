package com.bytedance.kmp.performance.platform;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AutoCloseable> f252786a;

    @Override // java.lang.AutoCloseable
    public final void close() {
        Iterator<T> r100 = this.f252786a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((AutoCloseable) r100.next()).close();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends AutoCloseable> r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriptions");
        this.f252786a = r100;
    }
}
