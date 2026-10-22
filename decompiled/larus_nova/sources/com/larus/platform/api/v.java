package com.larus.platform.api;

import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f365295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f365297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f365298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f365301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f365302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f365303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f365304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f365305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, String> f365306m;

    public v() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f365294a, r101.f365294a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365295b, r101.f365295b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365296c, r101.f365296c) == true) goto L18;
        return false;
    L18:
        if (this.f365297d == r101.f365297d) goto L21;
        return false;
    L21:
        if (this.f365298e == r101.f365298e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365299f, r101.f365299f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365300g, r101.f365300g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365301h, r101.f365301h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f365302i, r101.f365302i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f365303j, r101.f365303j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f365304k, r101.f365304k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f365305l, r101.f365305l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f365306m, r101.f365306m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365294a.hashCode() * 31;
        Boolean r101 = this.f365295b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f365296c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f365297d) * 31) + this.f365298e) * 31;
        String r108 = this.f365299f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f365300g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        List<String> r114 = this.f365301h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f365302i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f365303j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f365304k;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.f365305l;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        HashMap<String, String> r129 = this.f365306m;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
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
        return "GetCachedVideoItemsParams(messageId=" + this.f365294a + ", isLastVideoMessage=" + this.f365295b + ", outerFallbackRequestId=" + this.f365296c + ", outerShowCount=" + this.f365297d + ", clickIndex=" + this.f365298e + ", agentId=" + this.f365299f + ", outerVid=" + this.f365300g + ", outerFallbackVideoItems=" + this.f365301h + ", bizScene=" + this.f365302i + ", botId=" + this.f365303j + ", lastMessageId=" + this.f365304k + ", imprIndex=" + this.f365305l + ", outerFallbackChannelIdMap=" + this.f365306m + ')';
    }

    public v(String r110, Boolean r111, String r112, int r113, int r210, String r211, String r212, List r213, String r214, String r215, String r216, Integer r217, HashMap r218, int r219) {
        HashMap r100 = null;
        if ((r219 & 2) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r219 & 4) == 0) goto L9;
        String r102 = null;
    L10:
        int r103 = 0;
        if ((r219 & 8) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r219 & 16) != 0) goto L19;
        r103 = r210;
    L19:
        if ((r219 & 32) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r219 & 64) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r219 & 128) == 0) goto L29;
        List r114 = null;
    L31:
        if ((r219 & 256) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r219 & 512) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r219 & 1024) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r219 & 2048) == 0) goto L45;
        Integer r118 = null;
    L47:
        if ((r219 & 4096) != 0) goto L50;
        r100 = r218;
    L50:
        Intrinsics.checkNotNullParameter(r110, "messageId");
        this.f365294a = r110;
        this.f365295b = r101;
        this.f365296c = r102;
        this.f365297d = r104;
        this.f365298e = r103;
        this.f365299f = r105;
        this.f365300g = r106;
        this.f365301h = r114;
        this.f365302i = r115;
        this.f365303j = r116;
        this.f365304k = r117;
        this.f365305l = r118;
        this.f365306m = r100;
        return;
    L45:
        r118 = r217;
        goto L47
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L13:
        r104 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }
}
