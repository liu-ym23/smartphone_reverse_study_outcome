package com.bytedance.ee.bear.wikiv2.searchv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241064c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f241062a, r101.f241062a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241063b, r101.f241063b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f241064c, r101.f241064c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f241062a.hashCode() * 31) + this.f241063b.hashCode()) * 31;
        String r101 = this.f241064c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "WikiTreeNavigationData(spaceId=" + this.f241062a + ", spaceName=" + this.f241063b + ", wikiToken=" + this.f241064c + ')';
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        this.f241062a = r100;
        this.f241063b = r101;
        this.f241064c = r102;
    }
}
