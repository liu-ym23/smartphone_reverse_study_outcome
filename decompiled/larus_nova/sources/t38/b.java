package t38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f544453c;

    public b() {
        this(null, 0, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f544451a, r101.f544451a) == true) goto L12;
        return false;
    L12:
        if (this.f544452b == r101.f544452b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544453c, r101.f544453c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f544451a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f544452b) * 31;
        String r104 = this.f544453c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoubaoOpenAuthCodeResult(authCode=" + this.f544451a + ", errorCode=" + this.f544452b + ", errorMessage=" + this.f544453c + ')';
    }

    public b(String r100, int r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f544451a = r100;
        this.f544452b = r101;
        this.f544453c = r102;
    }
}
