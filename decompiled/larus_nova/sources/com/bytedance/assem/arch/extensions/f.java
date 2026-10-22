package com.bytedance.assem.arch.extensions;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f192926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f192927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<T> f192928c;

    @Override // kotlin.Lazy
    public final T getValue() {
        T r100 = this.f192926a;
        if (r100 != null) goto L7;
        T r101 = this.f192928c.invoke();
        this.f192926a = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.f192927b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(boolean r100, Function0<? extends T> r101) {
        this.f192927b = r100;
        this.f192928c = r101;
    }
}
