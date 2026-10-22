package com.larus.common.account.bdauth.viewmodel;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f325973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f325974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f325975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f325976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f325977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f325978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f325979i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f325971a, r101.f325971a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325972b, r101.f325972b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325973c, r101.f325973c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325974d, r101.f325974d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f325975e, r101.f325975e) == true) goto L24;
        return false;
    L24:
        if (this.f325976f == r101.f325976f) goto L27;
        return false;
    L27:
        if (this.f325977g == r101.f325977g) goto L30;
        return false;
    L30:
        if (this.f325978h == r101.f325978h) goto L33;
        return false;
    L33:
        if (this.f325979i == r101.f325979i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f325971a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f325972b.hashCode()) * 31) + this.f325973c.hashCode()) * 31;
        String r104 = this.f325974d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f325975e;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.f325976f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.f325977g == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f325978h == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f325979i == true) goto L31;
        r109 = 1237;
    L31:
        return r115 + r109;
    L25:
        r114 = 1237;
        goto L26
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
        return "BDAuthorizeAccountUiModel(userId=" + this.f325971a + ", secUserId=" + this.f325972b + ", displayName=" + this.f325973c + ", subtitle=" + this.f325974d + ", avatarUrl=" + this.f325975e + ", isCurrent=" + this.f325976f + ", isSelected=" + this.f325977g + ", isEnterprise=" + this.f325978h + ", hasValidLogin=" + this.f325979i + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "secUserId");
        Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
        this.f325971a = r100;
        this.f325972b = r101;
        this.f325973c = r102;
        this.f325974d = r103;
        this.f325975e = r104;
        this.f325976f = r105;
        this.f325977g = r106;
        this.f325978h = r107;
        this.f325979i = r110;
    }
}
