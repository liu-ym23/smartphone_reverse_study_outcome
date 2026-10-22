package com.bytedance.lark.inject_request_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252945b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f252944a, r101.f252944a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252945b, r101.f252945b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f252944a.hashCode() * 31) + this.f252945b.hashCode();
    }

    public final String toString() {
        return "HeaderPair(key=" + this.f252944a + ", value=" + this.f252945b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f252944a = r100;
        this.f252945b = r101;
    }
}
