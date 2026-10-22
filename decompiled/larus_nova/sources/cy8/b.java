package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f465806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f465808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f465809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f465810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f465811f;

    public b() {
        this(null, null, null, false, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f465806a, r101.f465806a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465807b, r101.f465807b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465808c, r101.f465808c) == true) goto L18;
        return false;
    L18:
        if (this.f465809d == r101.f465809d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465810e, r101.f465810e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465811f, r101.f465811f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f465806a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465807b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f465808c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f465809d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        a r112 = this.f465810e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f465811f;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasBlockModel(blockType=" + this.f465806a + ", blockId=" + this.f465807b + ", idx=" + this.f465808c + ", isFinish=" + this.f465809d + ", content=" + this.f465810e + ", logId=" + this.f465811f + ')';
    }

    public b(Integer r100, String r101, Integer r102, boolean r103, a r104, String r105) {
        this.f465806a = r100;
        this.f465807b = r101;
        this.f465808c = r102;
        this.f465809d = r103;
        this.f465810e = r104;
        this.f465811f = r105;
    }
}
