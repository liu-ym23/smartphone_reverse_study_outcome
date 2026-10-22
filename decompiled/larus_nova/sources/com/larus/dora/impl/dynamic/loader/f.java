package com.larus.dora.impl.dynamic.loader;

import d59.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f335211a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f335211a, ((f) r100).f335211a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f335211a.hashCode();
    }

    public final String toString() {
        return "LoadSuccess(pageData=" + this.f335211a + ')';
    }

    public f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "pageData");
        this.f335211a = r100;
    }
}
