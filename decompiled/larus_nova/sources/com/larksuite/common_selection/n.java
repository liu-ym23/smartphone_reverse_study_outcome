package com.larksuite.common_selection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectionGranularity f282906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SelectionInitiationMode f282907b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f282906a == r101.f282906a) goto L12;
        return false;
    L12:
        if (this.f282907b == r101.f282907b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f282906a.hashCode() * 31) + this.f282907b.hashCode();
    }

    public final String toString() {
        return "SelectionOption(granularity=" + this.f282906a + ", initiationMode=" + this.f282907b + ')';
    }

    public n(SelectionGranularity r100, SelectionInitiationMode r101) {
        Intrinsics.checkNotNullParameter(r100, "granularity");
        Intrinsics.checkNotNullParameter(r101, "initiationMode");
        this.f282906a = r100;
        this.f282907b = r101;
    }
}
