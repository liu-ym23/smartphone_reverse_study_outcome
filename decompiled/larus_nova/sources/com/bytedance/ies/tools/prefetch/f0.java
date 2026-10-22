package com.bytedance.ies.tools.prefetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f248819a;

    public interface a {
        String getDataType();
    }

    public f0() {
        throw null;
    }

    public final int hashCode() {
        T r100 = this.f248819a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(Object r100) {
        this.f248819a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f0) == true) goto L5;
        Object r101 = null;
    L7:
        if (((f0) r101) == null) goto L13;
        f0 r102 = (f0) r100;
        if ((!Intrinsics.areEqual(r102.getClass(), getClass())) == false) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(this.f248819a, r102.f248819a);
    L13:
        return false;
    L5:
        r101 = r100;
        goto L7
    }
}
