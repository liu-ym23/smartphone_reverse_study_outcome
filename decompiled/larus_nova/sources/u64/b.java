package u64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f548924e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f548920a, r101.f548920a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548921b, r101.f548921b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548922c, r101.f548922c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548923d, r101.f548923d) == true) goto L21;
        return false;
    L21:
        if (this.f548924e == r101.f548924e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f548920a.hashCode() * 31) + this.f548921b.hashCode()) * 31;
        String r101 = this.f548922c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f548923d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        long r106 = this.f548924e;
        return ((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AoAccessTokenResult(accessToken=" + this.f548920a + ", openId=" + this.f548921b + ", nickName=" + this.f548922c + ", loginChannel=" + this.f548923d + ", expireAt=" + this.f548924e + ')';
    }

    public b(String r100, String r101, String r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "accessToken");
        Intrinsics.checkNotNullParameter(r101, "openId");
        this.f548920a = r100;
        this.f548921b = r101;
        this.f548922c = r102;
        this.f548923d = r103;
        this.f548924e = r104;
    }
}
