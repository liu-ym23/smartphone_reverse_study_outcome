package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f333722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f333723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f333724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f333725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f333726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f333727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f333728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DiaryDisplayMode f333729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f333730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f333731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f333732o;

    public d() {
        this(null, null, null, null, false, null, null, false, false, false, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f333718a, r101.f333718a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333719b, r101.f333719b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333720c, r101.f333720c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333721d, r101.f333721d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f333722e, r101.f333722e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f333723f, r101.f333723f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f333724g, r101.f333724g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f333725h, r101.f333725h) == true) goto L33;
        return false;
    L33:
        if (this.f333726i == r101.f333726i) goto L36;
        return false;
    L36:
        if (this.f333727j == r101.f333727j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f333728k, r101.f333728k) == true) goto L42;
        return false;
    L42:
        if (this.f333729l == r101.f333729l) goto L45;
        return false;
    L45:
        if (this.f333730m == r101.f333730m) goto L48;
        return false;
    L48:
        if (this.f333731n == r101.f333731n) goto L51;
        return false;
    L51:
        if (this.f333732o == r101.f333732o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f333718a.hashCode() * 31) + this.f333719b.hashCode()) * 31;
        String r101 = this.f333720c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f333721d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f333722e.hashCode()) * 31;
        String r108 = this.f333723f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f333724g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f333725h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        int r117 = 1231;
        if (this.f333726i == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r116 + r118) * 31;
        if (this.f333727j == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r119 + r120) * 31;
        String r122 = this.f333728k;
        if (r122 == null) goto L34;
        r102 = r122.hashCode();
    L34:
        int r123 = (((r121 + r102) * 31) + this.f333729l.hashCode()) * 31;
        if (this.f333730m == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        if (this.f333731n == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (r125 + r126) * 31;
        if (this.f333732o == true) goto L47;
        r117 = 1237;
    L47:
        return r127 + r117;
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L29:
        r120 = 1237;
        goto L30
    L25:
        r118 = 1237;
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraGDeviceManagementDiaryItem(id=" + this.f333718a + ", title=" + this.f333719b + ", subtitle=" + this.f333720c + ", content=" + this.f333721d + ", actionText=" + this.f333722e + ", iconUrl=" + this.f333723f + ", imageUrl=" + this.f333724g + ", thumbnail=" + this.f333725h + ", isEmptyState=" + this.f333726i + ", isLoading=" + this.f333727j + ", diaryId=" + this.f333728k + ", displayMode=" + this.f333729l + ", isClickable=" + this.f333730m + ", isSodaBannerVisible=" + this.f333731n + ", isOtaBannerVisible=" + this.f333732o + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333718a;
    }

    public /* synthetic */ d(String r210, String r211, String r212, String r213, boolean r214, String r215, DiaryDisplayMode r216, boolean r217, boolean r218, boolean r219, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "DoraGDeviceManagementDiaryItem";
    L7:
        if ((r310 & 2) == 0) goto L9;
        int r101 = com.larus.utils.j0.f375426a;
        String r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_diary_record_cn);
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        int r105 = com.larus.utils.j0.f375426a;
        String r106 = com.larus.utils.j0.d(R.string.larus_dora_g_device_more_option_cn);
    L23:
        if ((r310 & 128) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r310 & 512) == 0) goto L29;
        boolean r111 = false;
    L31:
        if ((r310 & 1024) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r310 & 2048) == 0) goto L37;
        DiaryDisplayMode r113 = DiaryDisplayMode.NORMAL;
    L39:
        if ((r310 & 4096) == 0) goto L41;
        boolean r114 = true;
    L43:
        if ((r310 & 8192) == 0) goto L45;
        boolean r115 = false;
    L47:
        if ((r310 & 16384) == 0) goto L49;
        boolean r116 = false;
    L50:
        this(r100, r102, r103, r104, r106, null, null, r110, false, r111, r112, r113, r114, r115, r116);
        return;
    L49:
        r116 = r219;
        goto L50
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r111 = r214;
        goto L31
    L25:
        r110 = r213;
        goto L27
    L21:
        r106 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public d(String r100, String r101, String r102, String r110, String r111, String r112, String r113, String r114, boolean r115, boolean r116, String r117, DiaryDisplayMode r118, boolean r119, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r111, "actionText");
        Intrinsics.checkNotNullParameter(r118, "displayMode");
        this.f333718a = r100;
        this.f333719b = r101;
        this.f333720c = r102;
        this.f333721d = r110;
        this.f333722e = r111;
        this.f333723f = r112;
        this.f333724g = r113;
        this.f333725h = r114;
        this.f333726i = r115;
        this.f333727j = r116;
        this.f333728k = r117;
        this.f333729l = r118;
        this.f333730m = r119;
        this.f333731n = r210;
        this.f333732o = r211;
    }
}
