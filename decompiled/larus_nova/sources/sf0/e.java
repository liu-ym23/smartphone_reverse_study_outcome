package sf0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f541716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f541718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f541719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f541720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f541721f;

    public e() {
        this(0, null, null, 0, 0, 63, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f541716a == r101.f541716a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541717b, r101.f541717b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f541718c, r101.f541718c) == true) goto L12;
        return false;
    L12:
        if (this.f541719d == r101.f541719d) goto L14;
        return false;
    L14:
        if (this.f541720e == r101.f541720e) goto L16;
        return false;
    L16:
        if (this.f541721f == r101.f541721f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f541716a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f541717b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f541718c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return ((((((r105 + r103) * 31) + this.f541719d) * 31) + this.f541720e) * 31) + this.f541721f;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplyParams(roomId=" + this.f541716a + ", secToUserId=" + this.f541717b + ", toUserIdString=" + this.f541718c + ", replyType=" + this.f541719d + ", linkType=" + this.f541720e + ", layout=" + this.f541721f + ")";
    }

    public e(long r100, String r101, String r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r101, "secToUserId");
        Intrinsics.checkNotNullParameter(r102, "toUserIdString");
        this.f541716a = r100;
        this.f541717b = r101;
        this.f541718c = r102;
        this.f541719d = r103;
        this.f541720e = r104;
        this.f541721f = r105;
    }

    public /* synthetic */ e(long r100, String r110, String r111, int r112, int r113, int r114, int r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = 0;
    L6:
        String r102 = "";
        if ((r114 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r114 & 4) != 0) goto L14;
        r102 = r111;
    L14:
        int r104 = 0;
        if ((r114 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r114 & 16) != 0) goto L22;
        r104 = r113;
    L22:
        this(r101, r103, r102, r105, r104, 0);
        return;
    L17:
        r105 = r112;
        goto L19
    L9:
        r103 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }
}
