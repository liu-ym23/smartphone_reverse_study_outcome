package sq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543099c;

    public i() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f543097a, r101.f543097a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543098b, r101.f543098b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543099c, r101.f543099c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f543097a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f543098b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f543099c;
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
        return "CreationImageShareEventModel(enterFrom=" + this.f543097a + ", messageId=" + this.f543098b + ", creationId=" + this.f543099c + ')';
    }

    public i(String r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f543097a = r100;
        this.f543098b = r101;
        this.f543099c = r102;
    }
}
