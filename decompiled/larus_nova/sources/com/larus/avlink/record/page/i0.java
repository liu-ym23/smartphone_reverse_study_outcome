package com.larus.avlink.record.page;

import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f294246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f294248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TagType f294249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f294250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f294251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f294252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Float f294253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MinutesOfflineRecordingDeviceType f294254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f294255j;

    public i0() {
        this(null, null, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f294246a, r101.f294246a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294247b, r101.f294247b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294248c, r101.f294248c) == true) goto L18;
        return false;
    L18:
        if (this.f294249d == r101.f294249d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f294250e, r101.f294250e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f294251f, r101.f294251f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f294252g, r101.f294252g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f294253h, r101.f294253h) == true) goto L33;
        return false;
    L33:
        if (this.f294254i == r101.f294254i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f294255j, r101.f294255j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f294246a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f294247b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f294248c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TagType r110 = this.f294249d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f294250e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f294251f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f294252g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.f294253h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        MinutesOfflineRecordingDeviceType r125 = this.f294254i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f294255j;
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
        return "RecordMinutesItemData(id=" + this.f294246a + ", title=" + this.f294247b + ", contentSummary=" + this.f294248c + ", tag=" + this.f294249d + ", createTime=" + this.f294250e + ", messageId=" + this.f294251f + ", startTimeMs=" + this.f294252g + ", uploadProgress=" + this.f294253h + ", deviceType=" + this.f294254i + ", larkDocToken=" + this.f294255j + ')';
    }

    public static i0 a(i0 r110, TagType r111, Float r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f294246a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f294247b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f294248c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        TagType r104 = r110.f294249d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r105 = r110.f294250e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r114 = r110.f294251f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        Long r115 = r110.f294252g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        Float r116 = r110.f294253h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        MinutesOfflineRecordingDeviceType r117 = r110.f294254i;
    L39:
        if ((r113 & 512) == 0) goto L42;
        r100 = r110.f294255j;
    L42:
        return new i0(r101, r102, r103, r104, r105, r114, r115, r116, r117, r100);
    L37:
        r117 = null;
        goto L39
    L33:
        r116 = r112;
        goto L35
    L29:
        r115 = null;
        goto L31
    L25:
        r114 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r111;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ i0(String r110, String r111, TagType r112, String r113, Long r114, Float r210, MinutesOfflineRecordingDeviceType r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 8) == 0) goto L13;
        TagType r102 = null;
    L15:
        if ((r213 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        Long r115 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        Float r116 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        MinutesOfflineRecordingDeviceType r117 = null;
    L31:
        if ((r213 & 512) == 0) goto L33;
        String r118 = null;
    L34:
        this(r100, r101, null, r102, r103, null, r115, r116, r117, r118);
        return;
    L33:
        r118 = r212;
        goto L34
    L29:
        r117 = r211;
        goto L31
    L25:
        r116 = r210;
        goto L27
    L21:
        r115 = r114;
        goto L23
    L17:
        r103 = r113;
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

    public i0(String r100, String r101, String r102, TagType r103, String r104, String r105, Long r106, Float r107, MinutesOfflineRecordingDeviceType r108, String r110) {
        this.f294246a = r100;
        this.f294247b = r101;
        this.f294248c = r102;
        this.f294249d = r103;
        this.f294250e = r104;
        this.f294251f = r105;
        this.f294252g = r106;
        this.f294253h = r107;
        this.f294254i = r108;
        this.f294255j = r110;
    }
}
