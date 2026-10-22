package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f435341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSummaryViewType f435342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmSummaryStatus f435343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmSummaryStatus f435344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f435345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmAISummaryLayoutData f435346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f435347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f435348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f435349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f435350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f435351m;

    public c() {
        this(false, false, false, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f435339a == r101.f435339a) goto L12;
        return false;
    L12:
        if (this.f435340b == r101.f435340b) goto L15;
        return false;
    L15:
        if (this.f435341c == r101.f435341c) goto L18;
        return false;
    L18:
        if (this.f435342d == r101.f435342d) goto L21;
        return false;
    L21:
        if (this.f435343e == r101.f435343e) goto L24;
        return false;
    L24:
        if (this.f435344f == r101.f435344f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435345g, r101.f435345g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f435346h, r101.f435346h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f435347i, r101.f435347i) == true) goto L36;
        return false;
    L36:
        if (this.f435348j == r101.f435348j) goto L39;
        return false;
    L39:
        if (this.f435349k == r101.f435349k) goto L42;
        return false;
    L42:
        if (this.f435350l == r101.f435350l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f435351m, r101.f435351m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f435339a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f435340b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f435341c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((((((((r104 + r105) * 31) + this.f435342d.hashCode()) * 31) + this.f435343e.hashCode()) * 31) + this.f435344f.hashCode()) * 31) + this.f435345g.hashCode()) * 31;
        MmAISummaryLayoutData r107 = this.f435346h;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        b r111 = this.f435347i;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        if (this.f435348j == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f435349k == false) goto L29;
        int r116 = 1231;
    L30:
        int r117 = (r115 + r116) * 31;
        if (this.f435350l == true) goto L34;
        r100 = 1237;
    L34:
        int r118 = (r117 + r100) * 31;
        Boolean r119 = this.f435351m;
        if (r119 == null) goto L39;
        r108 = r119.hashCode();
    L39:
        return r118 + r108;
    L29:
        r116 = 1237;
        goto L30
    L25:
        r114 = 1237;
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingSummaryEntity(isAISummaryEnable=" + this.f435339a + ", isFishBoneEnable=" + this.f435340b + ", isViewTypeSwitchEnable=" + this.f435341c + ", viewType=" + this.f435342d + ", textSummaryStatus=" + this.f435343e + ", fishBoneSummaryStatus=" + this.f435344f + ", url=" + this.f435345g + ", fishBoneLayoutData=" + this.f435346h + ", aiSummaryContent=" + this.f435347i + ", isWebReady=" + this.f435348j + ", isWebLoading=" + this.f435349k + ", isWebLoadFailed=" + this.f435350l + ", hasUnviewedSummary=" + this.f435351m + ')';
    }

    public /* synthetic */ c(boolean r110, boolean r111, boolean r112, MmSummaryViewType r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r211 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r211 & 8) == 0) goto L17;
        MmSummaryViewType r103 = MmSummaryViewType.Markdown;
    L19:
        if ((r211 & 16) == 0) goto L21;
        MmSummaryStatus r104 = MmSummaryStatus.None;
    L23:
        if ((r211 & 32) == 0) goto L25;
        MmSummaryStatus r105 = MmSummaryStatus.None;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r106 = "";
    L30:
        this(r100, r101, r102, r103, r104, r105, r106, null, null, false, false, false, null);
        return;
    L29:
        r106 = null;
        goto L30
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static c a(c r110, MmSummaryViewType r111, MmSummaryStatus r210, MmSummaryStatus r211, String r212, MmAISummaryLayoutData r213, b r214, boolean r215, boolean r216, boolean r217, Boolean r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        boolean r100 = r110.f435339a;
    L7:
        if ((r219 & 2) == 0) goto L9;
        boolean r101 = r110.f435340b;
    L11:
        if ((r219 & 4) == 0) goto L13;
        boolean r102 = r110.f435341c;
    L15:
        if ((r219 & 8) == 0) goto L17;
        MmSummaryViewType r103 = r110.f435342d;
    L19:
        if ((r219 & 16) == 0) goto L21;
        MmSummaryStatus r104 = r110.f435343e;
    L23:
        if ((r219 & 32) == 0) goto L25;
        MmSummaryStatus r112 = r110.f435344f;
    L27:
        if ((r219 & 64) == 0) goto L29;
        String r113 = r110.f435345g;
    L31:
        if ((r219 & 128) == 0) goto L33;
        MmAISummaryLayoutData r114 = r110.f435346h;
    L35:
        if ((r219 & 256) == 0) goto L37;
        b r115 = r110.f435347i;
    L39:
        if ((r219 & 512) == 0) goto L41;
        boolean r116 = r110.f435348j;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        boolean r117 = r110.f435349k;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        boolean r118 = r110.f435350l;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        Boolean r119 = r110.f435351m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewType");
        Intrinsics.checkNotNullParameter(r104, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r112, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r113, "url");
        return new c(r100, r101, r102, r103, r104, r112, r113, r114, r115, r116, r117, r118, r119);
    L53:
        r119 = r218;
        goto L54
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r113 = r212;
        goto L31
    L25:
        r112 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r111;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public c(boolean r100, boolean r101, boolean r102, MmSummaryViewType r103, MmSummaryStatus r104, MmSummaryStatus r105, String r106, MmAISummaryLayoutData r107, b r110, boolean r111, boolean r112, boolean r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r103, "viewType");
        Intrinsics.checkNotNullParameter(r104, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r105, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r106, "url");
        this.f435339a = r100;
        this.f435340b = r101;
        this.f435341c = r102;
        this.f435342d = r103;
        this.f435343e = r104;
        this.f435344f = r105;
        this.f435345g = r106;
        this.f435346h = r107;
        this.f435347i = r110;
        this.f435348j = r111;
        this.f435349k = r112;
        this.f435350l = r113;
        this.f435351m = r114;
    }
}
