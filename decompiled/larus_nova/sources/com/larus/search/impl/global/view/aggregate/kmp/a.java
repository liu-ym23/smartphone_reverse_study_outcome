package com.larus.search.impl.global.view.aggregate.kmp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367772b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f367771a, r101.f367771a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367772b, r101.f367772b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f367771a.hashCode() * 31) + this.f367772b.hashCode();
    }

    public final String toString() {
        return "ContactDisplayContent(title=" + this.f367771a + ", subtitle=" + this.f367772b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subtitle");
        this.f367771a = r100;
        this.f367772b = r101;
    }
}
