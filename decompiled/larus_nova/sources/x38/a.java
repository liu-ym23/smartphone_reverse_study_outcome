package x38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f562387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f562389c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f562387a == r101.f562387a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562388b, r101.f562388b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562389c, r101.f562389c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f562387a * 31;
        String r101 = this.f562388b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.f562389c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonError(code=" + this.f562387a + ", msg=" + this.f562388b + ", throwable=" + this.f562389c + ')';
    }

    public a(int r100, String r101, Throwable r102) {
        this.f562387a = r100;
        this.f562388b = r101;
        this.f562389c = r102;
    }
}
