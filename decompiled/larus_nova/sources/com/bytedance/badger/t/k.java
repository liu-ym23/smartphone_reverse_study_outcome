package com.bytedance.badger.t;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199206a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f199206a, ((k) r100).f199206a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f199206a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StringVal(value=" + this.f199206a + ")";
    }

    public k(String r100) {
        this.f199206a = r100;
    }
}
