package hr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f486857c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f486855a, r101.f486855a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f486856b, r101.f486856b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f486857c, r101.f486857c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f486855a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f486856b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f486857c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IRTCRemoteStreamInfoParam(roomId=" + this.f486855a + ", userId=" + this.f486856b + ", streamIndex=" + this.f486857c + ")";
    }

    public g(String r100, String r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "streamIndex");
        this.f486855a = r100;
        this.f486856b = r101;
        this.f486857c = r102;
    }
}
