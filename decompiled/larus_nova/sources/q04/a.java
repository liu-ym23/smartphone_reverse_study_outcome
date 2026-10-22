package q04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f531178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f531180e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f531176a, r101.f531176a) == true) goto L12;
        return false;
    L12:
        if (this.f531177b == r101.f531177b) goto L15;
        return false;
    L15:
        if (this.f531178c == r101.f531178c) goto L18;
        return false;
    L18:
        if (this.f531179d == r101.f531179d) goto L21;
        return false;
    L21:
        if (this.f531180e == r101.f531180e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f531176a.hashCode() * 31) + this.f531177b) * 31;
        boolean r101 = this.f531178c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f531179d;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f531180e;
        if (r108 == true) goto L13;
        r102 = r108;
    L13:
        return r107 + r102;
    }

    public final String toString() {
        return "AosUserProfileFollowModel(openId=" + this.f531176a + ", followStatus=" + this.f531177b + ", isSecret=" + this.f531178c + ", showIm=" + this.f531179d + ", isEnterpriseVerified=" + this.f531180e + ')';
    }

    public a(String r100, int r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        this.f531176a = r100;
        this.f531177b = r101;
        this.f531178c = r102;
        this.f531179d = r103;
        this.f531180e = r104;
    }
}
