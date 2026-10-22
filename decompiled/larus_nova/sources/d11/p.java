package d11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f466351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f466353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f466354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f466355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f466356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f466357h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L22;
        p r101 = (p) r100;
        if (this.f466350a == r101.f466350a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f466351b, r101.f466351b) == true) goto L10;
        return false;
    L10:
        if (this.f466352c == r101.f466352c) goto L12;
        return false;
    L12:
        if (this.f466353d == r101.f466353d) goto L14;
        return false;
    L14:
        if (this.f466354e == r101.f466354e) goto L16;
        return false;
    L16:
        if (this.f466355f == r101.f466355f) goto L18;
        return false;
    L18:
        if (this.f466356g == r101.f466356g) goto L20;
        return false;
    L20:
        if (this.f466357h == r101.f466357h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466350a * 31;
        String r101 = this.f466351b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f466352c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f466353d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f466354e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f466355f;
        return ((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f466356g) * 31) + this.f466357h;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelReplyParams(answerStatus=" + this.f466350a + ", fromAnchorId=" + this.f466351b + ", fromRoomId=" + this.f466352c + ", roomId=" + this.f466353d + ", curChannelId=" + this.f466354e + ", toJoinChannelId=" + this.f466355f + ", matchType=" + this.f466356g + ", inviteType=" + this.f466357h + ")";
    }

    public p(int r100, String r101, long r102, long r103, long r104, long r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r101, "fromAnchorId");
        this.f466350a = r100;
        this.f466351b = r101;
        this.f466352c = r102;
        this.f466353d = r103;
        this.f466354e = r104;
        this.f466355f = r110;
        this.f466356g = r111;
        this.f466357h = r112;
    }
}
