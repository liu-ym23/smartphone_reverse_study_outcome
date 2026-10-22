package jw4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f500714e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f500710a, r101.f500710a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500711b, r101.f500711b) == true) goto L15;
        return false;
    L15:
        if (this.f500712c == r101.f500712c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500713d, r101.f500713d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500714e, r101.f500714e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f500710a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f500711b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f500712c) * 31;
        String r107 = this.f500713d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f500714e;
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
        return "CreateFailEventReportParams(module=" + this.f500710a + ", fileType=" + this.f500711b + ", errorCode=" + this.f500712c + ", errorMsg=" + this.f500713d + ", product=" + this.f500714e + ')';
    }

    public b(String r100, String r101, int r102, String r103) {
        this.f500710a = r100;
        this.f500711b = r101;
        this.f500712c = r102;
        this.f500713d = r103;
        this.f500714e = "suite";
    }
}
