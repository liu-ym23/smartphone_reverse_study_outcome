package zj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f572372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f572374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f572375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f572376g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f572370a, r101.f572370a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f572371b, r101.f572371b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f572372c, r101.f572372c) == true) goto L12;
        return false;
    L12:
        if (this.f572373d == r101.f572373d) goto L14;
        return false;
    L14:
        if (this.f572374e == r101.f572374e) goto L16;
        return false;
    L16:
        if (this.f572375f == r101.f572375f) goto L18;
        return false;
    L18:
        if (this.f572376g == r101.f572376g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r100 = this.f572370a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f572371b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f572372c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (((r106 + r101) * 31) + this.f572373d) * 31;
        boolean r109 = this.f572374e;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L16;
        r111 = 1;
    L16:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.f572375f;
        ?? r114 = r113;
        if (r113 == false) goto L19;
        r114 = 1;
    L19:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f572376g;
        if (r116 == true) goto L24;
        r110 = r116;
    L24:
        return r115 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ScrollData(sectionId=" + this.f572370a + ", itemId=" + this.f572371b + ", itemIndex=" + this.f572372c + ", offset=" + this.f572373d + ", needAnimate=" + this.f572374e + ", forceScroll=" + this.f572375f + ", silentScroll=" + this.f572376g + ")";
    }

    public a(String r100, String r101, Integer r102, int r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "sectionId");
        this.f572370a = r100;
        this.f572371b = r101;
        this.f572372c = r102;
        this.f572373d = r103;
        this.f572374e = r104;
        this.f572375f = r105;
        this.f572376g = false;
    }
}
