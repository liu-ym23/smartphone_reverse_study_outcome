package hd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484593c;

    public c() {
        this(null, null, 1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f484591a, r101.f484591a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484592b, r101.f484592b) == true) goto L10;
        return false;
    L10:
        if (this.f484593c == r101.f484593c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f484591a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f484592b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f484593c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportCpsTrackRequest(productId=" + this.f484591a + ", cpsTrack=" + this.f484592b + ", reportType=" + this.f484593c + ")";
    }

    public c(String r100, String r101, int r102) {
        this.f484591a = r100;
        this.f484592b = r101;
        this.f484593c = r102;
    }
}
