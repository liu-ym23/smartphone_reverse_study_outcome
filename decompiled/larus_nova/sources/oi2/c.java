package oi2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f523376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f523377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f523378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f523379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f523380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f523381g;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f523375a == r101.f523375a) goto L8;
        return false;
    L8:
        if (this.f523376b == r101.f523376b) goto L10;
        return false;
    L10:
        if (this.f523377c == r101.f523377c) goto L12;
        return false;
    L12:
        if (this.f523378d == r101.f523378d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f523379e, r101.f523379e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f523380f, r101.f523380f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f523381g, r101.f523381g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r100 = this.f523375a * 31;
        boolean r101 = this.f523376b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f523377c;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f523378d;
        if (r108 == true) goto L12;
        r102 = r108;
    L12:
        int r109 = (r107 + r102) * 31;
        Integer r110 = this.f523379e;
        int r111 = 0;
        if (r110 == null) goto L15;
        int r112 = r110.hashCode();
    L16:
        int r113 = (r109 + r112) * 31;
        String r114 = this.f523380f;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f523381g;
        if (r117 == null) goto L24;
        r111 = r117.hashCode();
    L24:
        return r116 + r111;
    L19:
        r115 = 0;
        goto L20
    L15:
        r112 = 0;
        goto L16
    }

    public final String toString() {
        return "ECSelectModel(selectCardPosition=" + this.f523375a + ", isUserAction=" + this.f523376b + ", isExpand=" + this.f523377c + ", needAnim=" + this.f523378d + ", isReplayDefaultProduct=" + this.f523379e + ", promotionId=" + this.f523380f + ", fragmentId=" + this.f523381g + ")";
    }

    public /* synthetic */ c(int r100) {
        this(-1, false, false, false, null, null, null);
    }

    public static c a(c r100, int r101, boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f523375a;
    L5:
        int r102 = r101;
        if ((r112 & 2) == 0) goto L8;
        r110 = r100.f523376b;
    L8:
        boolean r103 = r110;
        if ((r112 & 4) == 0) goto L11;
        r111 = r100.f523377c;
    L11:
        boolean r104 = r111;
        if ((r112 & 8) == 0) goto L14;
        boolean r105 = r100.f523378d;
    L16:
        if ((r112 & 16) == 0) goto L18;
        Integer r106 = r100.f523379e;
    L20:
        if ((r112 & 32) == 0) goto L22;
        String r107 = r100.f523380f;
    L24:
        if ((r112 & 64) == 0) goto L26;
        String r108 = r100.f523381g;
    L27:
        r100.getClass();
        return new c(r102, r103, r104, r105, r106, r107, r108);
    L26:
        r108 = null;
        goto L27
    L22:
        r107 = null;
        goto L24
    L18:
        r106 = null;
        goto L20
    L14:
        r105 = true;
        goto L16
    }

    public c(int r100, boolean r101, boolean r102, boolean r103, Integer r104, String r105, String r106) {
        this.f523375a = r100;
        this.f523376b = r101;
        this.f523377c = r102;
        this.f523378d = r103;
        this.f523379e = r104;
        this.f523380f = r105;
        this.f523381g = r106;
    }
}
