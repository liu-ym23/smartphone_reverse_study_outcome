package la3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ma3.b f508166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f508168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508169d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f508166a, r101.f508166a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f508167b, r101.f508167b) == true) goto L10;
        return false;
    L10:
        if (this.f508168c == r101.f508168c) goto L12;
        return false;
    L12:
        if (this.f508169d == r101.f508169d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ma3.b r100 = this.f508166a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f508167b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((((r103 + r101) * 31) + this.f508168c) * 31) + this.f508169d;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowResponseWrapper(response=" + this.f508166a + ", logId=" + this.f508167b + ", responseSize=" + this.f508168c + ", responseType=" + this.f508169d + ")";
    }

    public b(ma3.b r100, String r101, int r102, int r103) {
        this.f508166a = r100;
        this.f508167b = r101;
        this.f508168c = r102;
        this.f508169d = r103;
    }
}
