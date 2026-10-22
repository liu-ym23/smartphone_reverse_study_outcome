package com.bytedance.ee.bear.document.offline.sync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f220667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f220668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f220669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f220670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f220671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f220672f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f220667a, r101.f220667a) == true) goto L12;
        return false;
    L12:
        if (this.f220668b == r101.f220668b) goto L15;
        return false;
    L15:
        if (this.f220669c == r101.f220669c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f220670d, r101.f220670d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f220671e, r101.f220671e) == true) goto L24;
        return false;
    L24:
        if (this.f220672f == r101.f220672f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f220667a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f220668b) * 31) + this.f220669c) * 31;
        String r104 = this.f220670d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f220671e;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f220672f;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "JSONObjData(memberId=" + this.f220667a + ", baseRev=" + this.f220668b + ", version=" + this.f220669c + ", type=" + this.f220670d + ", token=" + this.f220671e + ", openType=" + this.f220672f + ')';
    }

    public final String getType() {
        return this.f220670d;
    }

    public r(String r100, String r101) {
        this.f220667a = r100;
        this.f220668b = 0;
        this.f220669c = 0;
        this.f220670d = "CLIENT_VARS";
        this.f220671e = r101;
        this.f220672f = 1;
    }
}
