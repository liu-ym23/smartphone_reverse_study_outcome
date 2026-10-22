package com.ss.android.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f407179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f407180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f407181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f407182d;

    public q() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f407179a, r101.f407179a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f407180b, r101.f407180b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f407181c, r101.f407181c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f407182d, r101.f407182d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f407179a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f407180b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        s r107 = this.f407181c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        s r110 = this.f407182d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AINoteImageData(localUri=" + this.f407179a + ", thumbLocalUri=" + this.f407180b + ", thumbSource=" + this.f407181c + ", originSource=" + this.f407182d + ')';
    }

    public q(String r100, String r101, s r102, s r103) {
        this.f407179a = r100;
        this.f407180b = r101;
        this.f407181c = r102;
        this.f407182d = r103;
    }
}
