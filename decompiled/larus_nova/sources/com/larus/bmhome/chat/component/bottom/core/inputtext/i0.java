package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f298747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f298748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f298749d;

    public i0() {
        int r100 = 0;
        this(r100, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f298746a, r101.f298746a) == true) goto L12;
        return false;
    L12:
        if (this.f298747b == r101.f298747b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298748c, r101.f298748c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f298749d, r101.f298749d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f298746a.hashCode() * 31) + this.f298747b) * 31) + this.f298748c.hashCode()) * 31) + this.f298749d.hashCode();
    }

    public final String toString() {
        return "InputReferenceDocumentIcon(token=" + this.f298746a + ", objType=" + this.f298747b + ", iconInfo=" + this.f298748c + ", url=" + this.f298749d + ')';
    }

    public /* synthetic */ i0(int r100, String r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L5;
        String r104 = "";
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = 0;
    L10:
        if ((r102 & 4) == 0) goto L13;
        r103 = "";
    L13:
        if ((r102 & 8) == 0) goto L15;
        r101 = "";
    L15:
        this(r104, r100, r103, r101);
        return;
    L5:
        r104 = null;
        goto L7
    }

    public i0(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "iconInfo");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f298746a = r100;
        this.f298747b = r101;
        this.f298748c = r102;
        this.f298749d = r103;
    }
}
