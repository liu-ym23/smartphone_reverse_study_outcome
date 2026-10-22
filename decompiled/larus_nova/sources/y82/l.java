package y82;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f566865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f566866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f566867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f566868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f566869e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L16;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f566865a, r101.f566865a) == true) goto L8;
        return false;
    L8:
        if (this.f566866b == r101.f566866b) goto L10;
        return false;
    L10:
        if (this.f566867c == r101.f566867c) goto L12;
        return false;
    L12:
        if (this.f566868d == r101.f566868d) goto L14;
        return false;
    L14:
        if (this.f566869e == r101.f566869e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        a r100 = this.f566865a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((r101 * 31) + this.f566866b) * 31) + this.f566867c) * 31) + this.f566868d) * 31) + this.f566869e;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "MediaSpecificationParams(windowFrame=" + this.f566865a + ", playerTopMargin=" + this.f566866b + ", playerLeftMargin=" + this.f566867c + ", playerWidth=" + this.f566868d + ", playerHeight=" + this.f566869e + ")";
    }

    public l(a r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "windowFrame");
        this.f566865a = r100;
        this.f566866b = r101;
        this.f566867c = r102;
        this.f566868d = r103;
        this.f566869e = r104;
    }
}
