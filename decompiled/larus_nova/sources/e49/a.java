package e49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z39.a f471022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f471023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f471024c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f471022a, r101.f471022a) == true) goto L12;
        return false;
    L12:
        if (this.f471023b == r101.f471023b) goto L15;
        return false;
    L15:
        if (this.f471024c == r101.f471024c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        z39.a r100 = this.f471022a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f471023b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f471024c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraOTAResponseWrapper(response=" + this.f471022a + ", isNuttxFirmware=" + this.f471023b + ", isPeripheralResponse=" + this.f471024c + ')';
    }

    public a(z39.a r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this.f471022a = r100;
        this.f471023b = r101;
        this.f471024c = r102;
    }
}
