package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f465877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f465878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f465879e;

    public m() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f465875a, r101.f465875a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465876b, r101.f465876b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465877c, r101.f465877c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465878d, r101.f465878d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465879e, r101.f465879e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465875a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465876b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f465877c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f465878d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f465879e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
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
        return "CanvasKmpImageInfo(uri=" + this.f465875a + ", url=" + this.f465876b + ", width=" + this.f465877c + ", height=" + this.f465878d + ", radius=" + this.f465879e + ')';
    }

    public m(String r100, String r101, Long r102, Long r103, Long r104) {
        this.f465875a = r100;
        this.f465876b = r101;
        this.f465877c = r102;
        this.f465878d = r103;
        this.f465879e = r104;
    }
}
