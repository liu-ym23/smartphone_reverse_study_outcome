package yx4;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f569411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f569413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f569414f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f569409a, r101.f569409a) == true) goto L12;
        return false;
    L12:
        if (this.f569410b == r101.f569410b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f569411c, r101.f569411c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569412d, r101.f569412d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f569413e, r101.f569413e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f569414f, r101.f569414f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f569409a.hashCode() * 31) + this.f569410b) * 31;
        Integer r101 = this.f569411c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f569412d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f569413e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function0<Unit> r111 = this.f569414f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeErrorInfo(msg=" + this.f569409a + ", iconRes=" + this.f569410b + ", code=" + this.f569411c + ", buttonTips=" + this.f569412d + ", errorCodeTips=" + this.f569413e + ", action=" + this.f569414f + ')';
    }

    public f(String r100, int r101, Integer r102, String r103, String r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f569409a = r100;
        this.f569410b = r101;
        this.f569411c = r102;
        this.f569412d = r103;
        this.f569413e = r104;
        this.f569414f = r105;
    }
}
