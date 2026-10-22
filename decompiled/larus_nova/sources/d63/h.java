package d63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f467118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f467119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f467121e;

    public h() {
        this(null, null, 0, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f467117a, r101.f467117a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f467118b, r101.f467118b) == true) goto L10;
        return false;
    L10:
        if (this.f467119c == r101.f467119c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467120d, r101.f467120d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f467121e, r101.f467121e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f467117a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f467118b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f467119c) * 31;
        String r107 = this.f467120d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f467121e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "DiscountLabelVO(tag=" + this.f467117a + ", tagHeader=" + this.f467118b + ", type=" + this.f467119c + ", id=" + this.f467120d + ", uiType=" + this.f467121e + ")";
    }

    public final int getType() {
        return this.f467119c;
    }

    public /* synthetic */ h(String r100, String r110, int r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r103 = 1;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r113 & 16) == 0) goto L21;
        Integer r105 = 0;
    L22:
        this(r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = null;
        goto L22
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public h(String r100, String r101, int r102, String r103, Integer r104) {
        this.f467117a = r100;
        this.f467118b = r101;
        this.f467119c = r102;
        this.f467120d = r103;
        this.f467121e = r104;
    }
}
