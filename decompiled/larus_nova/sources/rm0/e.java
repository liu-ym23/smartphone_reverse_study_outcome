package rm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f538518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f538520c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f538518a, r101.f538518a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f538519b, r101.f538519b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f538520c, r101.f538520c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f538518a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f538519b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f538520c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveMiddleExtraParam(liveId=" + this.f538518a + ", nearbyCityCode=" + this.f538519b + ", devicePlatform=" + this.f538520c + ")";
    }

    public e(Integer r100) {
        this.f538518a = r100;
        this.f538519b = "";
        this.f538520c = "Android";
    }
}
