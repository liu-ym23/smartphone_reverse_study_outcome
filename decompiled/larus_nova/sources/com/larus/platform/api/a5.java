package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f364862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f364863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f364864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f364865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f364866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f364867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f364868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f364869i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a5) == true) goto L8;
        return false;
    L8:
        a5 r101 = (a5) r100;
        if (Intrinsics.areEqual(this.f364861a, r101.f364861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364862b, r101.f364862b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364863c, r101.f364863c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f364864d, r101.f364864d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364865e, r101.f364865e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f364866f, r101.f364866f) == true) goto L27;
        return false;
    L27:
        if (this.f364867g == r101.f364867g) goto L30;
        return false;
    L30:
        if (this.f364868h == r101.f364868h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f364869i, r101.f364869i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364861a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f364862b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f364863c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f364864d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f364865e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f364866f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f364867g == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        long r121 = this.f364868h;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        String r123 = this.f364869i;
        if (r123 == null) goto L35;
        r101 = r123.hashCode();
    L35:
        return r122 + r101;
    L29:
        r119 = 1237;
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
        return "SdkCalendarEventParams(eventId=" + this.f364861a + ", title=" + this.f364862b + ", description=" + this.f364863c + ", startTime=" + this.f364864d + ", duration=" + this.f364865e + ", location=" + this.f364866f + ", enableRemind=" + this.f364867g + ", remindDate=" + this.f364868h + ", rRule=" + this.f364869i + ')';
    }

    public a5(String r100, String r101, Long r102, Long r103, String r104, boolean r105, long r106, String r107) {
        this.f364861a = r100;
        this.f364862b = r101;
        this.f364863c = null;
        this.f364864d = r102;
        this.f364865e = r103;
        this.f364866f = r104;
        this.f364867g = r105;
        this.f364868h = r106;
        this.f364869i = r107;
    }
}
