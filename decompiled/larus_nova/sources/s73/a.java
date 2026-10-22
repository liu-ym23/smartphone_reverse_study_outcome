package s73;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f540919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f540920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f540921e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f540917a, r101.f540917a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f540918b, r101.f540918b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f540919c, r101.f540919c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f540920d, r101.f540920d) == true) goto L14;
        return false;
    L14:
        if (this.f540921e == r101.f540921e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f540917a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f540918b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f540919c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f540920d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f540921e;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Pdp1To1XStyleParams(ecomSceneId=" + this.f540917a + ", firstCid=" + this.f540918b + ", halfHeadScale=" + this.f540919c + ", pdpHalfHeightType=" + this.f540920d + ", isLiveExplaining=" + this.f540921e + ")";
    }

    public a(String r100, String r101, Float r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "ecomSceneId");
        this.f540917a = r100;
        this.f540918b = r101;
        this.f540919c = r102;
        this.f540920d = r103;
        this.f540921e = r104;
    }
}
