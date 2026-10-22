package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f368907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f368908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f368909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f368910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f368911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f368912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f368913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f368914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f368915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f368916j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f368907a, r101.f368907a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368908b, r101.f368908b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368909c, r101.f368909c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f368910d, r101.f368910d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f368911e, r101.f368911e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f368912f, r101.f368912f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f368913g, r101.f368913g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f368914h, r101.f368914h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f368915i, r101.f368915i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f368916j, r101.f368916j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f368907a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f368908b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f368909c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f368910d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f368911e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f368912f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f368913g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f368914h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f368915i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        JSONObject r128 = this.f368916j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "SaasSharePanelRequest(scene=" + this.f368907a + ", officialUrl=" + this.f368908b + ", zlinkUrl=" + this.f368909c + ", title=" + this.f368910d + ", description=" + this.f368911e + ", imageUrl=" + this.f368912f + ", contentId=" + this.f368913g + ", poiId=" + this.f368914h + ", liveRoomId=" + this.f368915i + ", trackInfo=" + this.f368916j + ')';
    }

    public /* synthetic */ f(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, JSONObject r210, int r211) {
        if ((r211 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r211 & 64) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r211 & 256) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r211 & 512) == 0) goto L29;
        JSONObject r118 = null;
    L30:
        this(r110, r111, null, r100, r101, r102, r103, r104, r105, r118);
        return;
    L29:
        r118 = r210;
        goto L30
    L25:
        r105 = r117;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, JSONObject r110) {
        this.f368907a = r100;
        this.f368908b = r101;
        this.f368909c = r102;
        this.f368910d = r103;
        this.f368911e = r104;
        this.f368912f = r105;
        this.f368913g = r106;
        this.f368914h = r107;
        this.f368915i = r108;
        this.f368916j = r110;
    }
}
