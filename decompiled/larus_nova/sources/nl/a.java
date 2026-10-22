package nl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f519515d;

    public a() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f519512a, r101.f519512a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519513b, r101.f519513b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519514c, r101.f519514c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519515d, r101.f519515d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f519512a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f519513b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f519514c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f519515d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AdParams(cid=" + this.f519512a + ", logExtra=" + this.f519513b + ", adExtraData=" + this.f519514c + ", clickArea=" + this.f519515d + ")";
    }

    public a(String r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "cid");
        this.f519512a = r100;
        this.f519513b = r101;
        this.f519514c = r102;
        this.f519515d = null;
    }
}
