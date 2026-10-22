package mj2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f514165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f514166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f514167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f514168d;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f514165a, r101.f514165a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f514166b, r101.f514166b) == true) goto L10;
        return false;
    L10:
        if (this.f514167c == r101.f514167c) goto L12;
        return false;
    L12:
        if (this.f514168d == r101.f514168d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r100 = this.f514165a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f514166b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f514167c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f514168d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECPromotionEffectState(topEffectPromotionId=" + this.f514165a + ", relatedEffectPromotionId=" + this.f514166b + ", canShowSecKillProgressEffect=" + this.f514167c + ", canShowCouponEffect=" + this.f514168d + ")";
    }

    public b(int r100) {
        this.f514165a = null;
        this.f514166b = null;
        this.f514167c = true;
        this.f514168d = true;
    }
}
