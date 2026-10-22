package g0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479512f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f479507a, r101.f479507a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479508b, r101.f479508b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479509c, r101.f479509c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479510d, r101.f479510d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479511e, r101.f479511e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479512f, r101.f479512f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f479507a.hashCode() * 31) + this.f479508b.hashCode()) * 31) + this.f479509c.hashCode()) * 31;
        String r101 = this.f479510d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f479511e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f479512f.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobEnterTabParamsKmp(currentPage=" + this.f479507a + ", tabId=" + this.f479508b + ", tabName=" + this.f479509c + ", fromTabId=" + this.f479510d + ", tabType=" + this.f479511e + ", enterMethod=" + this.f479512f + ')';
    }

    public i(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "tabId");
        Intrinsics.checkNotNullParameter(r102, "tabName");
        Intrinsics.checkNotNullParameter(r105, "enterMethod");
        this.f479507a = r100;
        this.f479508b = r101;
        this.f479509c = r102;
        this.f479510d = r103;
        this.f479511e = r104;
        this.f479512f = r105;
    }
}
