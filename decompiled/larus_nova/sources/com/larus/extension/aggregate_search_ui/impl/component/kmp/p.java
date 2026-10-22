package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f342610a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342610a, ((p) r100).f342610a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342610a.hashCode();
    }

    public final String toString() {
        return "KmpSelectedDomainFilter(id=" + this.f342610a + ')';
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f342610a = r100;
    }
}
