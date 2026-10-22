package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SceneModel f210472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f210473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f210474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f210475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f210476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f210477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f210478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f210479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f210480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f210481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f210482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OfficeBaseMainContentTopMode f210483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OfficeBaseMainStatusBarMode f210484m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f210472a, r101.f210472a) == true) goto L12;
        return false;
    L12:
        if (this.f210473b == r101.f210473b) goto L15;
        return false;
    L15:
        if (this.f210474c == r101.f210474c) goto L18;
        return false;
    L18:
        if (this.f210475d == r101.f210475d) goto L21;
        return false;
    L21:
        if (this.f210476e == r101.f210476e) goto L24;
        return false;
    L24:
        if (this.f210477f == r101.f210477f) goto L27;
        return false;
    L27:
        if (this.f210478g == r101.f210478g) goto L30;
        return false;
    L30:
        if (this.f210479h == r101.f210479h) goto L33;
        return false;
    L33:
        if (this.f210480i == r101.f210480i) goto L36;
        return false;
    L36:
        if (this.f210481j == r101.f210481j) goto L39;
        return false;
    L39:
        if (this.f210482k == r101.f210482k) goto L42;
        return false;
    L42:
        if (this.f210483l == r101.f210483l) goto L45;
        return false;
    L45:
        if (this.f210484m == r101.f210484m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f210472a.hashCode() * 31;
        int r101 = 1231;
        if (this.f210473b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f210474c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f210475d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f210476e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f210477f == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f210478g == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.f210479h == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (r113 + r114) * 31;
        if (this.f210480i == false) goto L33;
        int r116 = 1231;
    L34:
        int r117 = (r115 + r116) * 31;
        if (this.f210481j == false) goto L37;
        int r118 = 1231;
    L38:
        int r119 = (r117 + r118) * 31;
        if (this.f210482k == true) goto L43;
        r101 = 1237;
    L43:
        return ((((r119 + r101) * 31) + this.f210483l.hashCode()) * 31) + this.f210484m.hashCode();
    L37:
        r118 = 1237;
        goto L38
    L33:
        r116 = 1237;
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeBaseMainSceneState(rawScene=" + this.f210472a + ", showAppBar=" + this.f210473b + ", showTopSlot=" + this.f210474c + ", fullScreenContent=" + this.f210475d + ", hideAppletCapsule=" + this.f210476e + ", headerCollapseEnabled=" + this.f210477f + ", showNativeOverlay=" + this.f210478g + ", backgroundInContentContainer=" + this.f210479h + ", backgroundNeedRadius=" + this.f210480i + ", enableBackground=" + this.f210481j + ", keepRadiusWhenHeaderCollapsed=" + this.f210482k + ", contentTopMode=" + this.f210483l + ", statusBarMode=" + this.f210484m + ')';
    }

    public r(SceneModel r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, boolean r111, boolean r112, OfficeBaseMainContentTopMode r113, OfficeBaseMainStatusBarMode r114) {
        Intrinsics.checkNotNullParameter(r100, "rawScene");
        Intrinsics.checkNotNullParameter(r113, "contentTopMode");
        Intrinsics.checkNotNullParameter(r114, "statusBarMode");
        this.f210472a = r100;
        this.f210473b = r101;
        this.f210474c = r102;
        this.f210475d = r103;
        this.f210476e = r104;
        this.f210477f = r105;
        this.f210478g = r106;
        this.f210479h = r107;
        this.f210480i = r110;
        this.f210481j = r111;
        this.f210482k = r112;
        this.f210483l = r113;
        this.f210484m = r114;
    }
}
