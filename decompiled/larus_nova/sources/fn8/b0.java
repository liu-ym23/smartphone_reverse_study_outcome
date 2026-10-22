package fn8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<x> f477943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f477945c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f477943a, r101.f477943a) == true) goto L12;
        return false;
    L12:
        if (this.f477944b == r101.f477944b) goto L15;
        return false;
    L15:
        if (this.f477945c == r101.f477945c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f477943a.hashCode() * 31) + this.f477944b) * 31) + this.f477945c;
    }

    public final String toString() {
        return "RichMediaLayoutViewInput(items=" + this.f477943a + ", contentPaddingStart=" + this.f477944b + ", contentPaddingEnd=" + this.f477945c + ')';
    }

    public b0(List<x> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f477943a = r100;
        this.f477944b = r101;
        this.f477945c = r102;
    }
}
