package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486734d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o2) == true) goto L8;
        return false;
    L8:
        o2 r101 = (o2) r100;
        if (Intrinsics.areEqual(this.f486731a, r101.f486731a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486732b, r101.f486732b) == true) goto L15;
        return false;
    L15:
        if (this.f486733c == r101.f486733c) goto L18;
        return false;
    L18:
        if (this.f486734d == r101.f486734d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f486731a.hashCode() * 31) + this.f486732b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f486733c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f486734d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkSocialEligibilityContext(uid=" + this.f486731a + ", secUid=" + this.f486732b + ", isLogin=" + this.f486733c + ", isEnterpriseAccount=" + this.f486734d + ')';
    }

    public o2(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "secUid");
        this.f486731a = r100;
        this.f486732b = r101;
        this.f486733c = r102;
        this.f486734d = r103;
    }
}
