package qv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f534863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f534864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f534865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f534866f;

    public b() {
        this(null, null, false, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f534861a, r101.f534861a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f534862b, r101.f534862b) == true) goto L10;
        return false;
    L10:
        if (this.f534863c == r101.f534863c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534864d, r101.f534864d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f534865e, r101.f534865e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f534866f, r101.f534866f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        String r100 = this.f534861a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f534862b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f534863c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f534864d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f534865e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f534866f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppLaunchLiveParams(gameId=" + this.f534861a + ", promoteScene=" + this.f534862b + ", isAnchor=" + this.f534863c + ", roomId=" + this.f534864d + ", videoId=" + this.f534865e + ", promoterId=" + this.f534866f + ")";
    }

    public b(String r100, String r101, boolean r102, String r103, String r104, String r105) {
        this.f534861a = r100;
        this.f534862b = r101;
        this.f534863c = r102;
        this.f534864d = r103;
        this.f534865e = r104;
        this.f534866f = r105;
    }

    public /* synthetic */ b(String r100, String r101, boolean r102, String r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r114 = null;
    L26:
        this(r103, r104, r105, r106, r107, r114);
        return;
    L25:
        r114 = r112;
        goto L26
    L21:
        r107 = r111;
        goto L23
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
