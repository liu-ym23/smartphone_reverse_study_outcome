package com.larus.common.account.bdauth.repository;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f325929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f325930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f325931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f325932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f325933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f325934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f325935i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f325927a, r101.f325927a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325928b, r101.f325928b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325929c, r101.f325929c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325930d, r101.f325930d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f325931e, r101.f325931e) == true) goto L24;
        return false;
    L24:
        if (this.f325932f == r101.f325932f) goto L27;
        return false;
    L27:
        if (this.f325933g == r101.f325933g) goto L30;
        return false;
    L30:
        if (this.f325934h == r101.f325934h) goto L33;
        return false;
    L33:
        if (this.f325935i == r101.f325935i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f325927a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f325928b.hashCode()) * 31) + this.f325929c.hashCode()) * 31;
        String r104 = this.f325930d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f325931e;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.f325932f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.f325933g == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f325934h == true) goto L26;
        r109 = 1237;
    L26:
        long r114 = this.f325935i;
        return ((r113 + r109) * 31) + ((int) (r114 ^ (r114 >>> 32)));
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BDAuthorizeAccount(userId=" + this.f325927a + ", secUserId=" + this.f325928b + ", displayName=" + this.f325929c + ", avatarUrl=" + this.f325930d + ", tenantName=" + this.f325931e + ", isEnterprise=" + this.f325932f + ", hasValidLogin=" + this.f325933g + ", isCurrent=" + this.f325934h + ", lastActiveTime=" + this.f325935i + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r107, long r110) {
        Intrinsics.checkNotNullParameter(r101, "secUserId");
        Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
        this.f325927a = r100;
        this.f325928b = r101;
        this.f325929c = r102;
        this.f325930d = r103;
        this.f325931e = r104;
        this.f325932f = r105;
        this.f325933g = r106;
        this.f325934h = r107;
        this.f325935i = r110;
    }
}
