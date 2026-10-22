package ny8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f521211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f521213c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f521211a, r101.f521211a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521212b, r101.f521212b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f521213c, r101.f521213c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f521211a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f521212b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f521213c;
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
        return "CanvasError(code=" + this.f521211a + ", message=" + this.f521212b + ", exception=" + this.f521213c + ')';
    }

    public /* synthetic */ b(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, null, null);
    }

    public b(Integer r100, String r101, Throwable r102) {
        this.f521211a = r100;
        this.f521212b = r101;
        this.f521213c = r102;
    }
}
