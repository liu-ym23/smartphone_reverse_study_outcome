package com.larus.office.plugins.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeCreateDocByMessageActionType f363082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f363083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f363084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f363085d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f363082a == r101.f363082a) goto L12;
        return false;
    L12:
        if (this.f363083b == r101.f363083b) goto L15;
        return false;
    L15:
        if (this.f363084c == r101.f363084c) goto L18;
        return false;
    L18:
        if (this.f363085d == r101.f363085d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f363082a.hashCode() * 31;
        int r101 = 1231;
        if (this.f363083b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f363084c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f363085d == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeCreateDocByMessageState(action=" + this.f363082a + ", hasRealToken=" + this.f363083b + ", hasUserChanges=" + this.f363084c + ", hasFrontendLinked=" + this.f363085d + ')';
    }

    public b(OfficeCreateDocByMessageActionType r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f363082a = r100;
        this.f363083b = r101;
        this.f363084c = r102;
        this.f363085d = r103;
    }
}
