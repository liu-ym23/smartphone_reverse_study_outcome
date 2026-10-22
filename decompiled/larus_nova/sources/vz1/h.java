package vz1;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f557678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f557679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f557680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f557681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f557682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f557683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f557684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f557685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f557686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f557687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f557688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f557689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f557690m;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L32;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f557678a, r101.f557678a) == true) goto L8;
        return false;
    L8:
        if (this.f557679b == r101.f557679b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f557680c, r101.f557680c) == true) goto L12;
        return false;
    L12:
        if (this.f557681d == r101.f557681d) goto L14;
        return false;
    L14:
        if (this.f557682e == r101.f557682e) goto L16;
        return false;
    L16:
        if (this.f557683f == r101.f557683f) goto L18;
        return false;
    L18:
        if (this.f557684g == r101.f557684g) goto L20;
        return false;
    L20:
        if (this.f557685h == r101.f557685h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f557686i, r101.f557686i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f557687j, r101.f557687j) == true) goto L26;
        return false;
    L26:
        if (this.f557688k == r101.f557688k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f557689l, r101.f557689l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f557690m, r101.f557690m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    public final int hashCode() {
        k r100 = this.f557678a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f557679b) * 31;
        String r104 = this.f557680c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f557681d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f557682e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f557683f;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f557684g;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.f557685h;
        ?? r116 = r115;
        if (r115 == false) goto L13;
        r116 = 1;
    L13:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f557686i;
        if (r118 == null) goto L16;
        int r119 = r118.hashCode();
    L17:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f557687j;
        if (r121 == null) goto L20;
        int r122 = r121.hashCode();
    L21:
        int r123 = (r120 + r122) * 31;
        long r124 = this.f557688k;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        String r126 = this.f557689l;
        if (r126 == null) goto L24;
        int r127 = r126.hashCode();
    L25:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f557690m;
        if (r129 == null) goto L29;
        r101 = r129.hashCode();
    L29:
        return r128 + r101;
    L24:
        r127 = 0;
        goto L25
    L20:
        r122 = 0;
        goto L21
    L16:
        r119 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PropInfo(diamondLabel=" + this.f557678a + ", count=" + this.f557679b + ", name=" + this.f557680c + ", nextExpire=" + this.f557681d + ", nowTimeDiff=" + this.f557682e + ", propType=" + this.f557683f + ", diamond=" + this.f557684g + ", setGray=" + this.f557685h + ", propDescription=" + this.f557686i + ", expiredException=" + this.f557687j + ", propDefSubType=" + this.f557688k + ", description=" + this.f557689l + ", refId=" + this.f557690m + ")";
    }

    public final String a() {
        return this.f557690m;
    }

    public /* synthetic */ h(int r210) {
        this(null, 0, null, 0, 0, 0, 0, false, "", "", 0, "", "");
    }

    public h(k r100, int r101, String r110, long r111, long r112, long r113, long r114, boolean r115, String r210, String r211, long r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r210, "propDescription");
        Intrinsics.checkNotNullParameter(r211, "expiredException");
        Intrinsics.checkNotNullParameter(r213, "description");
        Intrinsics.checkNotNullParameter(r214, "refId");
        this.f557678a = r100;
        this.f557679b = r101;
        this.f557680c = r110;
        this.f557681d = r111;
        this.f557682e = r112;
        this.f557683f = r113;
        this.f557684g = r114;
        this.f557685h = r115;
        this.f557686i = r210;
        this.f557687j = r211;
        this.f557688k = r212;
        this.f557689l = r213;
        this.f557690m = r214;
    }
}
