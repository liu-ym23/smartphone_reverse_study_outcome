package n38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f517000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f517001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f517002f;

    public e() {
        this(null, null, null, -1, null, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f516997a, r101.f516997a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516998b, r101.f516998b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f516999c, r101.f516999c) == true) goto L18;
        return false;
    L18:
        if (this.f517000d == r101.f517000d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f517001e, r101.f517001e) == true) goto L24;
        return false;
    L24:
        if (this.f517002f == r101.f517002f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f516997a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f516998b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f516999c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f517000d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f517001e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        int r113 = (r111 + r101) * 31;
        long r114 = this.f517002f;
        return r113 + ((int) (r114 ^ (r114 >>> 32)));
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
        return "DouYinTokenResult(accessToken=" + this.f516997a + ", openId=" + this.f516998b + ", scopes=" + this.f516999c + ", expireTime=" + this.f517000d + ", refreshToken=" + this.f517001e + ", accessTokenExpireAt=" + this.f517002f + ')';
    }

    public e(String r100, String r101, String r102, long r103, String r104, long r105) {
        this.f516997a = r100;
        this.f516998b = r101;
        this.f516999c = r102;
        this.f517000d = r103;
        this.f517001e = r104;
        this.f517002f = r105;
    }
}
