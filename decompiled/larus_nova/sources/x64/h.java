package x64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f562619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f562620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f562621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f562622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f562623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f562624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f562625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f562626h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L42:
        return true;
    L5:
        if ((r100 instanceof h) == false) goto L41;
        h r101 = (h) r100;
        if (this.f562619a != r101.f562619a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L41;
        if (this.f562620b != r101.f562620b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L41;
        if (this.f562621c != r101.f562621c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L41;
        if (this.f562622d != r101.f562622d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L41;
        if (this.f562623e != r101.f562623e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L41;
        if (this.f562624f != r101.f562624f) goto L34;
        boolean r107 = true;
    L35:
        if (r107 == false) goto L41;
        if (Intrinsics.areEqual(this.f562625g, r101.f562625g) == false) goto L41;
        if (Intrinsics.areEqual(this.f562626h, r101.f562626h) == false) goto L41;
    L34:
        r107 = false;
        goto L35
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L41:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        long r100 = this.f562619a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f562620b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f562621c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        boolean r106 = this.f562622d;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L5;
        r108 = 1;
    L5:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f562623e;
        if (r110 == true) goto L9;
        r107 = r110;
    L9:
        int r111 = (((r109 + r107) * 31) + this.f562624f) * 31;
        String r112 = this.f562625g;
        int r113 = 0;
        if (r112 == null) goto L12;
        int r114 = r112.hashCode();
    L13:
        int r115 = (r111 + r114) * 31;
        String r116 = this.f562626h;
        if (r116 == null) goto L17;
        r113 = r116.hashCode();
    L17:
        return r115 + r113;
    L12:
        r114 = 0;
        goto L13
    }

    public final String toString() {
        return "ReportPolicy(delayMs=" + this.f562619a + ", minIntervalMs=" + this.f562620b + ", timeoutMs=" + this.f562621c + ", shouldCheckFreq=" + this.f562622d + ", doUploadWhenTimeout=" + this.f562623e + ", sceneId=" + this.f562624f + ", triggerPath=" + this.f562625g + ", triggerLogid=" + this.f562626h + ")";
    }

    public h(long r100, long r101, long r102, boolean r103, int r104) {
        this.f562619a = r100;
        this.f562620b = r101;
        this.f562621c = r102;
        this.f562622d = true;
        this.f562623e = r103;
        this.f562624f = r104;
        this.f562625g = "";
        this.f562626h = "";
    }
}
