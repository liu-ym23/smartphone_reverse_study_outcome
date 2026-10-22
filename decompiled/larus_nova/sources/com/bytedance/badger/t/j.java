package com.bytedance.badger.t;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f199205a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f199205a, ((j) r100).f199205a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List r100 = this.f199205a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ObjectVal(fields=" + this.f199205a + ")";
    }

    public j(List r100) {
        this.f199205a = r100;
    }
}
