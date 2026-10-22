package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f365137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f365139f;

    public g5() {
        this(null, null, null, -1, null, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g5) == true) goto L8;
        return false;
    L8:
        g5 r101 = (g5) r100;
        if (Intrinsics.areEqual(this.f365134a, r101.f365134a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365135b, r101.f365135b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365136c, r101.f365136c) == true) goto L18;
        return false;
    L18:
        if (this.f365137d == r101.f365137d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365138e, r101.f365138e) == true) goto L24;
        return false;
    L24:
        if (this.f365139f == r101.f365139f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365134a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365135b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f365136c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f365137d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f365138e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        int r113 = (r111 + r101) * 31;
        long r114 = this.f365139f;
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
        return "SdkDouyinToken(accessToken=" + this.f365134a + ", openId=" + this.f365135b + ", scopes=" + this.f365136c + ", expireTime=" + this.f365137d + ", refreshToken=" + this.f365138e + ", accessTokenExpireAt=" + this.f365139f + ')';
    }

    public g5(String r100, String r101, String r102, long r103, String r104, long r105) {
        this.f365134a = r100;
        this.f365135b = r101;
        this.f365136c = r102;
        this.f365137d = r103;
        this.f365138e = r104;
        this.f365139f = r105;
    }
}
