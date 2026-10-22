package com.larus.dora.impl.dynamic.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335453a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f335453a, ((d) r100).f335453a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f335453a.hashCode();
    }

    public final String toString() {
        return "ShowFailureToast(text=" + this.f335453a + ')';
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f335453a = r100;
    }
}
