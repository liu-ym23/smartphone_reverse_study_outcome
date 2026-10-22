package uq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f551340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f551343d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f551340a == r101.f551340a) goto L12;
        return false;
    L12:
        if (this.f551341b == r101.f551341b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551342c, r101.f551342c) == true) goto L18;
        return false;
    L18:
        if (this.f551343d == r101.f551343d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f551340a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f551341b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f551342c;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.f551343d == true) goto L19;
        r100 = 1237;
    L19:
        return r107 + r100;
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ECBindDouYinResult(isBind=" + this.f551340a + ", isNewBind=" + this.f551341b + ", clientEngineExtra=" + this.f551342c + ", isCancel=" + this.f551343d + ')';
    }

    public e(boolean r100, boolean r101, String r102, boolean r103) {
        this.f551340a = r100;
        this.f551341b = r101;
        this.f551342c = r102;
        this.f551343d = r103;
    }
}
