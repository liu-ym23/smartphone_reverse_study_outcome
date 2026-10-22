package com.larksuite.common_selection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f282867a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f282867a, ((e) r100).f282867a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f282867a.hashCode();
    }

    public final String toString() {
        return this.f282867a.toString();
    }

    public e(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f282867a = r100;
    }
}
