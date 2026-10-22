package com.bytedance.badger.t;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f199203a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f199203a, ((h) r100).f199203a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List r100 = this.f199203a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ListVal(items=" + this.f199203a + ")";
    }

    public h(List r100) {
        this.f199203a = r100;
    }
}
