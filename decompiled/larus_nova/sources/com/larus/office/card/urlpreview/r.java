package com.larus.office.card.urlpreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f362013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f362014b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f362013a, r101.f362013a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f362014b, r101.f362014b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f362013a.hashCode() * 31) + this.f362014b.hashCode();
    }

    public final String toString() {
        return "OfficeUrlPreviewBlockKey(messageIdentity=" + this.f362013a + ", blockIdentity=" + this.f362014b + ')';
    }

    public r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageIdentity");
        Intrinsics.checkNotNullParameter(r101, "blockIdentity");
        this.f362013a = r100;
        this.f362014b = r101;
    }
}
