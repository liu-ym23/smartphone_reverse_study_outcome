package com.bytedance.ee.bear.search;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f236827c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f236825a, r101.f236825a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f236826b, r101.f236826b) == true) goto L15;
        return false;
    L15:
        if (this.f236827c == r101.f236827c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f236825a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f236826b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f236827c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FolderInfo(folderToken=" + this.f236825a + ", folderName=" + this.f236826b + ", isShareFolder=" + this.f236827c + ')';
    }

    public a(String r100, String r101, boolean r102) {
        this.f236825a = r100;
        this.f236826b = r101;
        this.f236827c = r102;
    }
}
