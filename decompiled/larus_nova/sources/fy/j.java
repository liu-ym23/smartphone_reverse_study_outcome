package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f479229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f479230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f479231i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L24;
        j r101 = (j) r100;
        if (this.f479223a == r101.f479223a) goto L8;
        return false;
    L8:
        if (this.f479224b == r101.f479224b) goto L10;
        return false;
    L10:
        if (this.f479225c == r101.f479225c) goto L12;
        return false;
    L12:
        if (this.f479226d == r101.f479226d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479227e, r101.f479227e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f479228f, r101.f479228f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479229g, r101.f479229g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f479230h, r101.f479230h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f479231i, r101.f479231i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f479223a * 31;
        long r101 = this.f479224b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f479225c;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f479226d) * 31;
        String r105 = this.f479227e;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f479228f;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f479229g;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.f479230h;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        a r118 = this.f479231i;
        if (r118 == null) goto L22;
        r106 = r118.hashCode();
    L22:
        return r117 + r106;
    L17:
        r116 = 0;
        goto L18
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
        return "ReplyParams(scene=" + this.f479223a + ", channelId=" + this.f479224b + ", roomId=" + this.f479225c + ", replyStats=" + this.f479226d + ", inviteUserId=" + this.f479227e + ", secInviteUserId=" + this.f479228f + ", auto=" + this.f479229g + ", multiPkMode=" + this.f479230h + ", anchorParams=" + this.f479231i + ")";
    }

    public j(int r100, long r101, long r102, int r103, String r104, String r105, Boolean r110, Integer r111, a r112) {
        Intrinsics.checkNotNullParameter(r104, "inviteUserId");
        Intrinsics.checkNotNullParameter(r112, "anchorParams");
        this.f479223a = r100;
        this.f479224b = r101;
        this.f479225c = r102;
        this.f479226d = r103;
        this.f479227e = r104;
        this.f479228f = r105;
        this.f479229g = r110;
        this.f479230h = r111;
        this.f479231i = r112;
    }
}
