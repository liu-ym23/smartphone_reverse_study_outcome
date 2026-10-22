package ni4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ki4.b0 f519316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519317c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (this.f519315a == r101.f519315a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519316b, r101.f519316b) == true) goto L15;
        return false;
    L15:
        if (this.f519317c == r101.f519317c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f519315a * 31) + this.f519316b.hashCode()) * 31) + this.f519317c;
    }

    public final String toString() {
        return "(" + this.f519315a + ", " + this.f519316b + ", " + this.f519317c + ')';
    }

    public o0(int r100, ki4.b0 r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "materialCursor");
        this.f519315a = r100;
        this.f519316b = r101;
        this.f519317c = r102;
    }
}
