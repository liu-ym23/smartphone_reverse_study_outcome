package rm1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f538523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f538524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f538525e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f538521a, r101.f538521a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f538522b, r101.f538522b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f538523c, r101.f538523c) == true) goto L12;
        return false;
    L12:
        if (this.f538524d == r101.f538524d) goto L14;
        return false;
    L14:
        if (this.f538525e == r101.f538525e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f538521a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f538522b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f538523c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f538524d;
        return ((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.f538525e;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SmoothSwitchCmdInfo(preReslolution=" + this.f538521a + ", afterResolution=" + this.f538522b + ", switchStrategy=" + this.f538523c + ", switchTs=" + this.f538524d + ", switchWaitTime=" + this.f538525e + ")";
    }

    public a() {
        this("", "", "", 0, 5000);
    }

    public a(String r100, String r101, String r102, long r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "preReslolution");
        Intrinsics.checkNotNullParameter(r101, "afterResolution");
        Intrinsics.checkNotNullParameter(r102, "switchStrategy");
        this.f538521a = r100;
        this.f538522b = r101;
        this.f538523c = r102;
        this.f538524d = r103;
        this.f538525e = r104;
    }
}
