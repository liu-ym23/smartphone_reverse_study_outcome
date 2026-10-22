package com.larus.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f362179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f362180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f362181c;

    public i() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f362179a, r101.f362179a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f362180b, r101.f362180b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f362181c, r101.f362181c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f362179a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f362180b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f362181c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeOfflineDocumentCreateResult(realToken=" + this.f362179a + ", serializedResponse=" + this.f362180b + ", errorMessage=" + this.f362181c + ')';
    }

    public /* synthetic */ i(String r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this(null, null, r100);
    }

    public i(String r100, String r101, String r102) {
        this.f362179a = r100;
        this.f362180b = r101;
        this.f362181c = r102;
    }
}
