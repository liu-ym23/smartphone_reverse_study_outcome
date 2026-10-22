package ko0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504360c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f504358a, r101.f504358a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f504359b, r101.f504359b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f504360c, r101.f504360c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f504358a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f504359b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f504360c;
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
        return "MiniAppLiveCastEntranceInfo(appId=" + this.f504358a + ", appName=" + this.f504359b + ", iconUrl=" + this.f504360c + ")";
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "iconUrl");
        this.f504358a = r100;
        this.f504359b = r101;
        this.f504360c = r102;
    }
}
