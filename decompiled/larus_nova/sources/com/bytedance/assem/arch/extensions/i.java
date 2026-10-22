package com.bytedance.assem.arch.extensions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f192929a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f192929a, ((i) r100).f192929a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f192929a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Success(value=" + this.f192929a + ")";
    }

    public i(T r100) {
        this.f192929a = r100;
    }
}
