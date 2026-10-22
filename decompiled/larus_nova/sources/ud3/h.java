package ud3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f549735c;

    public h() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f549733a, r101.f549733a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f549734b, r101.f549734b) == true) goto L10;
        return false;
    L10:
        if (this.f549735c == r101.f549735c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f549733a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f549734b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f549735c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportCpsTrackRequest(productId=" + this.f549733a + ", cpsTrack=" + this.f549734b + ", reportType=" + this.f549735c + ")";
    }

    public h(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        int r103 = 1;
    L12:
        this.f549733a = r100;
        this.f549734b = r101;
        this.f549735c = r103;
        return;
    L11:
        r103 = 0;
        goto L12
    }
}
