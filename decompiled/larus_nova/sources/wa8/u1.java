package wa8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558896c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r101 = (u1) r100;
        if (Intrinsics.areEqual(this.f558894a, r101.f558894a) == true) goto L12;
        return false;
    L12:
        if (this.f558895b == r101.f558895b) goto L15;
        return false;
    L15:
        if (this.f558896c == r101.f558896c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f558894a.hashCode() * 31) + this.f558895b) * 31) + this.f558896c;
    }

    public final String toString() {
        return "RedDotTextStyleInfo(text=" + this.f558894a + ", textColor=" + this.f558895b + ", backgroundColor=" + this.f558896c + ')';
    }

    public u1(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f558894a = r100;
        this.f558895b = r101;
        this.f558896c = r102;
    }
}
