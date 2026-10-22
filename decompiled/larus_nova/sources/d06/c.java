package d06;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f466202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f466203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f466204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f466205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f466206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f466207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f466208g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f466202a == r101.f466202a) goto L8;
        return false;
    L8:
        if (this.f466203b == r101.f466203b) goto L10;
        return false;
    L10:
        if (this.f466204c == r101.f466204c) goto L12;
        return false;
    L12:
        if (this.f466205d == r101.f466205d) goto L14;
        return false;
    L14:
        if (this.f466206e == r101.f466206e) goto L16;
        return false;
    L16:
        if (this.f466207f == r101.f466207f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466208g, r101.f466208g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f466202a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f466203b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f466204c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f466205d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f466206e;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f466207f;
        if (r116 == true) goto L21;
        r101 = r116;
    L21:
        int r117 = (r115 + r101) * 31;
        a r118 = this.f466208g;
        if (r118 == null) goto L24;
        int r119 = r118.hashCode();
    L26:
        return r117 + r119;
    L24:
        r119 = 0;
        goto L26
    }

    public final String toString() {
        return "SampleRateModel(appOpsConfig=" + this.f466202a + ", autoStartConfig=" + this.f466203b + ", exceptionConfig=" + this.f466204c + ", exceptionAlogConfig=" + this.f466205d + ", appExitConfig=" + this.f466206e + ", strictModeConfig=" + this.f466207f + ", defaultLowPriorityConfig=" + this.f466208g + ")";
    }

    public c(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, a r106) {
        this.f466202a = r100;
        this.f466203b = r101;
        this.f466204c = r102;
        this.f466205d = r103;
        this.f466206e = r104;
        this.f466207f = r105;
        this.f466208g = r106;
    }
}
