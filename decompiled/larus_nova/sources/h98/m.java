package h98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f484350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f484351d;

    public m() {
        this(null, null, 0.0f, 15, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f484348a, r101.f484348a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484349b, r101.f484349b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f484350c, r101.f484350c) == 0) goto L18;
        return false;
    L18:
        if (this.f484351d == r101.f484351d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f484348a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f484349b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + Float.floatToIntBits(this.f484350c)) * 31) + this.f484351d;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraImageUIModel(thumbnailUrl=" + this.f484348a + ", url=" + this.f484349b + ", rotation=" + this.f484350c + ", tagCount=" + this.f484351d + ')';
    }

    public m(String r100, String r101, float r102, int r103) {
        this.f484348a = r100;
        this.f484349b = r101;
        this.f484350c = r102;
        this.f484351d = r103;
    }

    public /* synthetic */ m(String r100, String r101, float r102, int r103, int r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0.0f;
    L11:
        this(r100, r101, r102, 0);
    }
}
