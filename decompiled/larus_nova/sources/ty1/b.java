package ty1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f547952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f547953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f547955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f547957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f547958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f547959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f547960i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (this.f547952a == r101.f547952a) goto L8;
        return false;
    L8:
        if (this.f547953b == r101.f547953b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f547954c, r101.f547954c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547955d, r101.f547955d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f547956e, r101.f547956e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f547957f, r101.f547957f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547958g, r101.f547958g) == true) goto L20;
        return false;
    L20:
        if (this.f547959h == r101.f547959h) goto L22;
        return false;
    L22:
        if (this.f547960i == r101.f547960i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v24 */
    public final int hashCode() {
        int r100 = this.f547952a * 31;
        long r101 = this.f547953b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f547954c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        a r107 = this.f547955d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f547956e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f547957f;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f547958g;
        if (r116 == null) goto L21;
        r104 = r116.hashCode();
    L21:
        int r117 = (r115 + r104) * 31;
        boolean r118 = this.f547959h;
        ?? r119 = r118;
        if (r118 == false) goto L24;
        r119 = 1;
    L24:
        int r120 = (r117 + r119) * 31;
        long r121 = this.f547960i;
        return r120 + ((int) (r121 ^ (r121 >>> 32)));
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "GroupContainerItem(type=" + this.f547952a + ", priority=" + this.f547953b + ", containerPayload=" + this.f547954c + ", position=" + this.f547955d + ", url=" + this.f547956e + ", foldUrl=" + this.f547957f + ", horizontalUrl=" + this.f547958g + ", canAdjustPosition=" + this.f547959h + ", timestamp=" + this.f547960i + ")";
    }

    public final int getType() {
        return this.f547952a;
    }

    public b(int r100, long r101, String r102, a r103, String r104, String r105, String r106, boolean r110, long r111) {
        Intrinsics.checkNotNullParameter(r102, "containerPayload");
        Intrinsics.checkNotNullParameter(r103, "position");
        Intrinsics.checkNotNullParameter(r104, "url");
        Intrinsics.checkNotNullParameter(r105, "foldUrl");
        Intrinsics.checkNotNullParameter(r106, "horizontalUrl");
        this.f547952a = r100;
        this.f547953b = r101;
        this.f547954c = r102;
        this.f547955d = r103;
        this.f547956e = r104;
        this.f547957f = r105;
        this.f547958g = r106;
        this.f547959h = r110;
        this.f547960i = r111;
    }
}
