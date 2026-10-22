package com.bytedance.locallife.dito.core.viewmodel;

import com.bytedance.locallife.dito.model.BaseDitoModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseDitoModel<?> f258143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f258144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f258145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f258146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f258147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f258148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f258149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f258150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f258151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f258152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f258153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f258154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f258155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f258156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f258157o;

    public z() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f258143a, r101.f258143a) == true) goto L12;
        return false;
    L12:
        if (this.f258144b == r101.f258144b) goto L15;
        return false;
    L15:
        if (this.f258145c == r101.f258145c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f258146d, r101.f258146d) == 0) goto L21;
        return false;
    L21:
        if (this.f258147e == r101.f258147e) goto L24;
        return false;
    L24:
        if (this.f258148f == r101.f258148f) goto L27;
        return false;
    L27:
        if (this.f258149g == r101.f258149g) goto L30;
        return false;
    L30:
        if (this.f258150h == r101.f258150h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f258151i, r101.f258151i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f258152j, r101.f258152j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f258153k, r101.f258153k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f258154l, r101.f258154l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f258155m, r101.f258155m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f258156n, r101.f258156n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f258157o, r101.f258157o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        BaseDitoModel<?> r100 = this.f258143a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f258144b) * 31;
        int r104 = 1231;
        if (this.f258145c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((r103 + r105) * 31) + Float.floatToIntBits(this.f258146d)) * 31) + this.f258147e) * 31;
        if (this.f258148f == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f258149g == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f258150h == true) goto L22;
        r104 = 1237;
    L22:
        int r111 = (r110 + r104) * 31;
        String r112 = this.f258151i;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.f258152j;
        if (r115 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f258153k;
        if (r118 != null) goto L33;
        int r119 = 0;
    L34:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f258154l;
        if (r121 != null) goto L37;
        int r122 = 0;
    L38:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.f258155m;
        if (r124 != null) goto L41;
        int r125 = 0;
    L42:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f258156n;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        Boolean r130 = this.f258157o;
        if (r130 == null) goto L51;
        r101 = r130.hashCode();
    L51:
        return r129 + r101;
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = r124.hashCode();
        goto L42
    L37:
        r122 = r121.hashCode();
        goto L38
    L33:
        r119 = r118.hashCode();
        goto L34
    L29:
        r116 = r115.hashCode();
        goto L30
    L25:
        r113 = r112.hashCode();
        goto L26
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TopModelData(model=" + this.f258143a + ", offset=" + this.f258144b + ", overlapWithFloatHeader=" + this.f258145c + ", speedMultiple=" + this.f258146d + ", position=" + this.f258147e + ", scrollToPageTopWhenNeed=" + this.f258148f + ", preventCoverByStickContainer=" + this.f258149g + ", disableNestedResetToEdge=" + this.f258150h + ", targetSubViewId=" + this.f258151i + ", retryTimes=" + this.f258152j + ", retryTimesAfterTargetFound=" + this.f258153k + ", subViewNotFoundStrategy=" + this.f258154l + ", duration=" + this.f258155m + ", interpolatorControlPoints=" + this.f258156n + ", skipInvalidTimeCheckWhenTargetFoundRetry=" + this.f258157o + ')';
    }

    public z(BaseDitoModel r110, int r111, boolean r112, float r210, int r211, boolean r212, boolean r213, boolean r214, String r215, Integer r216, Integer r217, String r218, Integer r219, String r310, Boolean r311, int r312) {
        boolean r100 = false;
        if ((r312 & 2) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r312 & 4) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r312 & 8) == 0) goto L13;
        float r103 = 1.0f;
    L15:
        if ((r312 & 16) == 0) goto L17;
        int r104 = -1;
    L19:
        if ((r312 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r312 & 64) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r312 & 128) != 0) goto L30;
        r100 = r214;
    L30:
        Boolean r113 = null;
        if ((r312 & 256) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r312 & 512) == 0) goto L37;
        Integer r114 = null;
    L39:
        if ((r312 & 1024) == 0) goto L41;
        Integer r115 = null;
    L43:
        if ((r312 & 2048) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r312 & 4096) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r312 & 8192) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r312 & 16384) != 0) goto L58;
        r113 = r311;
    L58:
        this.f258143a = r110;
        this.f258144b = r101;
        this.f258145c = r102;
        this.f258146d = r103;
        this.f258147e = r104;
        this.f258148f = r105;
        this.f258149g = r106;
        this.f258150h = r100;
        this.f258151i = r107;
        this.f258152j = r114;
        this.f258153k = r115;
        this.f258154l = r116;
        this.f258155m = r117;
        this.f258156n = r118;
        this.f258157o = r113;
        return;
    L53:
        r118 = r310;
        goto L55
    L49:
        r117 = r219;
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
        r107 = r215;
        goto L35
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
