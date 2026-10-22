package d11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f466309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f466310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f466312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f466313g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (this.f466307a == r101.f466307a) goto L8;
        return false;
    L8:
        if (this.f466308b == r101.f466308b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f466309c, r101.f466309c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f466310d, r101.f466310d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f466311e, r101.f466311e) == true) goto L16;
        return false;
    L16:
        if (this.f466312f == r101.f466312f) goto L18;
        return false;
    L18:
        if (this.f466313g == r101.f466313g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466307a * 31;
        long r101 = this.f466308b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f466309c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f466310d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f466311e;
        if (r110 == null) goto L13;
        r104 = r110.hashCode();
    L13:
        int r111 = (((r109 + r104) * 31) + this.f466312f) * 31;
        long r112 = this.f466313g;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "KickOutParams(scene=" + this.f466307a + ", channelId=" + this.f466308b + ", toUserId=" + this.f466309c + ", secToUserId=" + this.f466310d + ", reqSrc=" + this.f466311e + ", kickOutSource=" + this.f466312f + ", toRoomId=" + this.f466313g + ")";
    }

    public e(int r100, long r101, String r102, String r103, String r104, int r105, long r106) {
        Intrinsics.checkNotNullParameter(r104, "reqSrc");
        this.f466307a = r100;
        this.f466308b = r101;
        this.f466309c = r102;
        this.f466310d = r103;
        this.f466311e = r104;
        this.f466312f = r105;
        this.f466313g = r106;
    }

    public /* synthetic */ e(int r110, long r111, String r112, String r113, String r114, int r115, long r116, int r210) {
        if ((r210 & 32) == 0) goto L5;
        int r100 = 2;
    L7:
        if ((r210 & 64) == 0) goto L9;
        long r101 = 0;
    L10:
        this(r110, r111, r112, r113, r114, r100, r101);
        return;
    L9:
        r101 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
