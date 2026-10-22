package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f434819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f434820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f434821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f434822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f434823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f434824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f434825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f434826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f434827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f434828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f434829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f434830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f434831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f434832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f434833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f434834p;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f434819a == r101.f434819a) goto L12;
        return false;
    L12:
        if (this.f434820b == r101.f434820b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434821c, r101.f434821c) == true) goto L18;
        return false;
    L18:
        if (this.f434822d == r101.f434822d) goto L21;
        return false;
    L21:
        if (this.f434823e == r101.f434823e) goto L24;
        return false;
    L24:
        if (this.f434824f == r101.f434824f) goto L27;
        return false;
    L27:
        if (this.f434825g == r101.f434825g) goto L30;
        return false;
    L30:
        if (this.f434826h == r101.f434826h) goto L33;
        return false;
    L33:
        if (this.f434827i == r101.f434827i) goto L36;
        return false;
    L36:
        if (this.f434828j == r101.f434828j) goto L39;
        return false;
    L39:
        if (this.f434829k == r101.f434829k) goto L42;
        return false;
    L42:
        if (this.f434830l == r101.f434830l) goto L45;
        return false;
    L45:
        if (this.f434831m == r101.f434831m) goto L48;
        return false;
    L48:
        if (this.f434832n == r101.f434832n) goto L51;
        return false;
    L51:
        if (this.f434833o == r101.f434833o) goto L54;
        return false;
    L54:
        if (this.f434834p == r101.f434834p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f434819a == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.f434820b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        Long r104 = this.f434821c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f434822d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f434823e == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f434824f == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f434825g == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (r112 + r113) * 31;
        if (this.f434826h == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (r114 + r115) * 31;
        if (this.f434827i == false) goto L33;
        int r117 = 1231;
    L34:
        int r118 = (r116 + r117) * 31;
        if (this.f434828j == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (r118 + r119) * 31;
        if (this.f434829k == false) goto L41;
        int r121 = 1231;
    L42:
        int r122 = (r120 + r121) * 31;
        if (this.f434830l == false) goto L45;
        int r123 = 1231;
    L46:
        int r124 = (r122 + r123) * 31;
        if (this.f434831m == false) goto L49;
        int r125 = 1231;
    L50:
        int r126 = (r124 + r125) * 31;
        if (this.f434832n == false) goto L53;
        int r127 = 1231;
    L54:
        int r128 = (r126 + r127) * 31;
        if (this.f434833o == false) goto L57;
        int r129 = 1231;
    L58:
        int r130 = (r128 + r129) * 31;
        if (this.f434834p == true) goto L63;
        r100 = 1237;
    L63:
        return r130 + r100;
    L57:
        r129 = 1237;
        goto L58
    L53:
        r127 = 1237;
        goto L54
    L49:
        r125 = 1237;
        goto L50
    L45:
        r123 = 1237;
        goto L46
    L41:
        r121 = 1237;
        goto L42
    L37:
        r119 = 1237;
        goto L38
    L33:
        r117 = 1237;
        goto L34
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAINoteEntity(loaded=" + this.f434819a + ", lastMarkActionElapsedTimeMs=" + this.f434820b + ", photoTargetNoteId=" + this.f434821c + ", bizSessionStarted=" + this.f434822d + ", saveSwitchFeatureEnabled=" + this.f434823e + ", saveSwitchFetched=" + this.f434824f + ", saveSwitchState=" + this.f434825g + ", saveSwitchUpdating=" + this.f434826h + ", hasContent=" + this.f434827i + ", saveSwitchTooltipGuideNeedShow=" + this.f434828j + ", saveSwitchTooltipConsumed=" + this.f434829k + ", saveSwitchTooltipShowing=" + this.f434830l + ", saveSwitchTooltipHasShownInSession=" + this.f434831m + ", saveSwitchPanelExpanded=" + this.f434832n + ", saveSwitchEditorFocused=" + this.f434833o + ", saveSwitchKeyboardVisible=" + this.f434834p + ')';
    }

    public /* synthetic */ c(int r110) {
        this(false, 0, null, false, false, false, true, false, false, false, false, false, false, false, false, false);
    }

    public c(boolean r100, long r101, Long r102, boolean r103, boolean r104, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210) {
        this.f434819a = r100;
        this.f434820b = r101;
        this.f434821c = r102;
        this.f434822d = r103;
        this.f434823e = r104;
        this.f434824f = r110;
        this.f434825g = r111;
        this.f434826h = r112;
        this.f434827i = r113;
        this.f434828j = r114;
        this.f434829k = r115;
        this.f434830l = r116;
        this.f434831m = r117;
        this.f434832n = r118;
        this.f434833o = r119;
        this.f434834p = r210;
    }

    public static c a(c r110, boolean r111, long r112, Long r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        boolean r100 = r110.f434819a;
    L7:
        if ((r315 & 2) == 0) goto L9;
        long r101 = r110.f434820b;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Long r102 = r110.f434821c;
    L15:
        if ((r315 & 8) == 0) goto L17;
        boolean r103 = r110.f434822d;
    L19:
        if ((r315 & 16) == 0) goto L21;
        boolean r104 = r110.f434823e;
    L23:
        if ((r315 & 32) == 0) goto L25;
        boolean r105 = r110.f434824f;
    L27:
        if ((r315 & 64) == 0) goto L29;
        boolean r106 = r110.f434825g;
    L31:
        if ((r315 & 128) == 0) goto L33;
        boolean r113 = r110.f434826h;
    L35:
        if ((r315 & 256) == 0) goto L37;
        boolean r114 = r110.f434827i;
    L39:
        if ((r315 & 512) == 0) goto L41;
        boolean r115 = r110.f434828j;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        boolean r116 = r110.f434829k;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        boolean r117 = r110.f434830l;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        boolean r118 = r110.f434831m;
    L54:
        boolean r316 = r118;
        if ((r315 & 8192) == 0) goto L57;
        boolean r119 = r110.f434832n;
    L58:
        boolean r317 = r119;
        if ((r315 & 16384) == 0) goto L61;
        boolean r120 = r110.f434833o;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        boolean r107 = r110.f434834p;
    L66:
        r110.getClass();
        return new c(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r316, r317, r120, r107);
    L65:
        r107 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L63
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
