package wf6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f559483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rj0.c f559484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f559485f;

    public b() {
        this(null, 0, false, false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f559480a, r101.f559480a) == true) goto L8;
        return false;
    L8:
        if (this.f559481b == r101.f559481b) goto L10;
        return false;
    L10:
        if (this.f559482c == r101.f559482c) goto L12;
        return false;
    L12:
        if (this.f559483d == r101.f559483d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f559484e, r101.f559484e) == true) goto L16;
        return false;
    L16:
        if (this.f559485f == r101.f559485f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f559480a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f559481b) * 31;
        boolean r104 = this.f559482c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f559483d;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        rj0.c r111 = this.f559484e;
        if (r111 == null) goto L15;
        r101 = r111.hashCode();
    L15:
        int r112 = (r110 + r101) * 31;
        boolean r113 = this.f559485f;
        if (r113 == true) goto L20;
        r105 = r113;
    L20:
        return r112 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CloseLinkParams(reqSource=" + this.f559480a + ", disconnectSource=" + this.f559481b + ", needToastWhenSuccess=" + this.f559482c + ", needShowLinkResult=" + this.f559483d + ", disconnectCallback=" + this.f559484e + ", isNeedLeaveChanel=" + this.f559485f + ")";
    }

    public /* synthetic */ b(String r100, int r101, boolean r110, boolean r111, rj0.c r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        int r103 = 0;
    L10:
        if ((r113 & 4) == 0) goto L12;
        boolean r104 = false;
    L14:
        if ((r113 & 8) == 0) goto L16;
        boolean r105 = false;
    L18:
        if ((r113 & 16) == 0) goto L20;
        r112 = null;
    L20:
        rj0.c r106 = r112;
        if ((r113 & 32) == 0) goto L23;
        boolean r107 = true;
    L24:
        this(r102, r103, r104, r105, r106, r107);
        return;
    L23:
        r107 = false;
        goto L24
    L16:
        r105 = r111;
        goto L18
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }

    public b(String r100, int r101, boolean r102, boolean r103, rj0.c r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "reqSource");
        this.f559480a = r100;
        this.f559481b = r101;
        this.f559482c = r102;
        this.f559483d = r103;
        this.f559484e = r104;
        this.f559485f = r105;
    }
}
