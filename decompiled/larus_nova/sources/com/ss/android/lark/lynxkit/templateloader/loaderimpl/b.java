package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f431532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f431533c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f431531a, r101.f431531a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431532b, r101.f431532b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f431533c, r101.f431533c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f431531a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f431532b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f431533c;
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
        return "BuiltInResourceResult(path=" + this.f431531a + ", version=" + this.f431532b + ", failMsg=" + this.f431533c + ')';
    }

    public b(String r100, Long r101, String r102) {
        this.f431531a = r100;
        this.f431532b = r101;
        this.f431533c = r102;
    }
}
