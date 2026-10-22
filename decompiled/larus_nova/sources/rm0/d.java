package rm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f538512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f538514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f538515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f538516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f538517f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f538512a, r101.f538512a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f538513b, r101.f538513b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f538514c, r101.f538514c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538515d, r101.f538515d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f538516e, r101.f538516e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f538517f, r101.f538517f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f538512a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f538513b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f538514c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f538515d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f538516e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f538517f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "LiveMiddleEnvParam(isBoe=" + this.f538512a + ", boeLane=" + this.f538513b + ", isPpe=" + this.f538514c + ", ppeLane=" + this.f538515d + ", isOpSandboxApp=" + this.f538516e + ", isOpSandboxDevMode=" + this.f538517f + ")";
    }

    public d(Boolean r100, Boolean r101, Boolean r102, Boolean r103) {
        this.f538512a = r100;
        this.f538513b = "";
        this.f538514c = r101;
        this.f538515d = "";
        this.f538516e = r102;
        this.f538517f = r103;
    }
}
