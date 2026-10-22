package com.bytedance.assem.arch.extensions;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Lazy<T> {
    public T a;
    public final boolean b;
    public final Function0<T> c;

    public final T getValue() {
        T r0 = this.a;
        if (r0 != null) goto L7;
        T r1 = (T) this.c.invoke();
        this.a = r1;
        return r1;
    L7:
        return r0;
    }

    public final boolean isInitialized() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(boolean r1, Function0<? extends T> r2) {
        this.b = r1;
        this.c = r2;
    }
}
