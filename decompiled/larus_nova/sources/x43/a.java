package x43;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f562435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f562436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f562439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f562440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f562441g;

    public a() {
        this(127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f562435a == r101.f562435a) goto L8;
        return false;
    L8:
        if (this.f562436b == r101.f562436b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f562437c, r101.f562437c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562438d, r101.f562438d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f562439e, r101.f562439e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f562440f, r101.f562440f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f562441g, r101.f562441g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    public final int hashCode() {
        boolean r100 = this.f562435a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f562436b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.f562437c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f562438d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f562439e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f562440f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f562441g;
        if (r119 == null) goto L29;
        r107 = r119.hashCode();
    L29:
        return r118 + r107;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "ErrorViewModel(showError=" + this.f562435a + ", showClose=" + this.f562436b + ", icon=" + this.f562437c + ", title=" + this.f562438d + ", description=" + this.f562439e + ", buttonText=" + this.f562440f + ", buttonAction=" + this.f562441g + ")";
    }

    public /* synthetic */ a(int r100) {
        this(false, false, null, null, null, null, null);
    }

    public a(boolean r100, boolean r101, String r102, String r103, String r104, String r105, String r106) {
        this.f562435a = r100;
        this.f562436b = r101;
        this.f562437c = r102;
        this.f562438d = r103;
        this.f562439e = r104;
        this.f562440f = r105;
        this.f562441g = r106;
    }
}
