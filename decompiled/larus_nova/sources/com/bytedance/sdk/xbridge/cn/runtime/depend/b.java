package com.bytedance.sdk.xbridge.cn.runtime.depend;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f270123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f270124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f270125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f270126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f270127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f270128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f270129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f270130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f270131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Integer> f270132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f270133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f270134m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f270135n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f270122a, r101.f270122a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f270123b, r101.f270123b) == true) goto L15;
        return false;
    L15:
        if (this.f270124c == r101.f270124c) goto L18;
        return false;
    L18:
        if (this.f270125d == r101.f270125d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f270126e, r101.f270126e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f270127f, r101.f270127f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f270128g, r101.f270128g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f270129h, r101.f270129h) == true) goto L33;
        return false;
    L33:
        if (this.f270130i == r101.f270130i) goto L36;
        return false;
    L36:
        if (this.f270131j == r101.f270131j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f270132k, r101.f270132k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f270133l, r101.f270133l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f270134m, r101.f270134m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f270135n, r101.f270135n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f270122a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f270123b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f270124c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f270125d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Integer r111 = this.f270126e;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (((r110 + r112) * 31) + this.f270127f.hashCode()) * 31;
        String r114 = this.f270128g;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f270129h;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (r116 + r118) * 31;
        int r120 = 1231;
        if (this.f270130i == false) goto L25;
        int r121 = 1231;
    L26:
        int r122 = (r119 + r121) * 31;
        if (this.f270131j == true) goto L30;
        r120 = 1237;
    L30:
        int r123 = (r122 + r120) * 31;
        List<Integer> r124 = this.f270132k;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f270133l;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        Integer r130 = this.f270134m;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        Integer r133 = this.f270135n;
        if (r133 == null) goto L47;
        r101 = r133.hashCode();
    L47:
        return r132 + r101;
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L25:
        r121 = 1237;
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r112 = r111.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalendarEventRecord(title=" + this.f270122a + ", description=" + this.f270123b + ", startTime=" + this.f270124c + ", endTime=" + this.f270125d + ", alarmMinutes=" + this.f270126e + ", eventId=" + this.f270127f + ", appUrl=" + this.f270128g + ", location=" + this.f270129h + ", allDay=" + this.f270130i + ", isRepeat=" + this.f270131j + ", scheduledWeekDays=" + this.f270132k + ", repeatFrequency=" + this.f270133l + ", repeatInterval=" + this.f270134m + ", repeatCount=" + this.f270135n + ')';
    }

    public b(String r100, String r101, long r102, long r103, Integer r110, String r111, String r112, String r113, boolean r114, boolean r115, List<Integer> r116, String r117, Integer r118, Integer r210) {
        Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276361k);
        this.f270122a = r100;
        this.f270123b = r101;
        this.f270124c = r102;
        this.f270125d = r103;
        this.f270126e = r110;
        this.f270127f = r111;
        this.f270128g = r112;
        this.f270129h = r113;
        this.f270130i = r114;
        this.f270131j = r115;
        this.f270132k = r116;
        this.f270133l = r117;
        this.f270134m = r118;
        this.f270135n = r210;
    }
}
