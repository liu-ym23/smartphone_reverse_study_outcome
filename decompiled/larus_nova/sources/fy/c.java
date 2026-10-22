package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f479165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f479167h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (this.f479160a == r101.f479160a) goto L8;
        return false;
    L8:
        if (this.f479161b == r101.f479161b) goto L10;
        return false;
    L10:
        if (this.f479162c == r101.f479162c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479163d, r101.f479163d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479164e, r101.f479164e) == true) goto L16;
        return false;
    L16:
        if (this.f479165f == r101.f479165f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479166g, r101.f479166g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f479167h, r101.f479167h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f479160a * 31;
        long r101 = this.f479161b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f479162c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f479163d;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f479164e;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (((r108 + r110) * 31) + this.f479165f) * 31;
        String r112 = this.f479166g;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f479167h;
        if (r115 == null) goto L18;
        r106 = r115.hashCode();
    L18:
        return r114 + r106;
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "CancelParams(scene=" + this.f479160a + ", channelId=" + this.f479161b + ", toRoomId=" + this.f479162c + ", toUserId=" + this.f479163d + ", secToUserId=" + this.f479164e + ", cancelType=" + this.f479165f + ", reqSrc=" + this.f479166g + ", inviteeUserIds=" + this.f479167h + ")";
    }

    public c(int r100, long r101, long r102, String r103, String r104, int r105, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r103, "toUserId");
        Intrinsics.checkNotNullParameter(r104, "secToUserId");
        Intrinsics.checkNotNullParameter(r110, "reqSrc");
        this.f479160a = r100;
        this.f479161b = r101;
        this.f479162c = r102;
        this.f479163d = r103;
        this.f479164e = r104;
        this.f479165f = r105;
        this.f479166g = r110;
        this.f479167h = r111;
    }
}
