package fl8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f477742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f477743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f477745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f477746f;

    public d() {
        this(null, false, false, false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f477741a, r101.f477741a) == true) goto L12;
        return false;
    L12:
        if (this.f477742b == r101.f477742b) goto L15;
        return false;
    L15:
        if (this.f477743c == r101.f477743c) goto L18;
        return false;
    L18:
        if (this.f477744d == r101.f477744d) goto L21;
        return false;
    L21:
        if (this.f477745e == r101.f477745e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f477746f, r101.f477746f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f477741a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f477742b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f477743c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f477744d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f477745e == true) goto L22;
        r104 = 1237;
    L22:
        int r111 = (r110 + r104) * 31;
        String r112 = this.f477746f;
        if (r112 == null) goto L27;
        r101 = r112.hashCode();
    L27:
        return r111 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatingThinkViewInput(title=" + this.f477741a + ", showArrow=" + this.f477742b + ", showLoadingIndicator=" + this.f477743c + ", showShimmer=" + this.f477744d + ", clickable=" + this.f477745e + ", iconUrl=" + this.f477746f + ')';
    }

    public /* synthetic */ d(String r110, boolean r111, boolean r112, boolean r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r115 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r115 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r115 & 32) == 0) goto L21;
        String r104 = null;
    L22:
        this(r100, r101, false, r102, r103, r104);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public d(String r100, boolean r101, boolean r102, boolean r103, boolean r104, String r105) {
        this.f477741a = r100;
        this.f477742b = r101;
        this.f477743c = r102;
        this.f477744d = r103;
        this.f477745e = r104;
        this.f477746f = r105;
    }
}
