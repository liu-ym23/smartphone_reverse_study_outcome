package com.larus.dora.impl.noti_v3.overview.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f336449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f336450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f336451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f336452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f336453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f336454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f336455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q59.a f336456h;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f336449a, r101.f336449a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f336450b, r101.f336450b) == true) goto L15;
        return false;
    L15:
        if (this.f336451c == r101.f336451c) goto L18;
        return false;
    L18:
        if (this.f336452d == r101.f336452d) goto L21;
        return false;
    L21:
        if (this.f336453e == r101.f336453e) goto L24;
        return false;
    L24:
        if (this.f336454f == r101.f336454f) goto L27;
        return false;
    L27:
        if (this.f336455g == r101.f336455g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f336456h, r101.f336456h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f336449a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f336450b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.f336451c) * 31) + this.f336452d) * 31) + this.f336453e) * 31) + this.f336454f) * 31) + this.f336455g) * 31;
        q59.a r107 = this.f336456h;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NotificationBroadcastV3UiState(conflictHandlingResId=" + this.f336449a + ", notificationFreqResId=" + this.f336450b + ", socialConfigCount=" + this.f336451c + ", enabledServiceCount=" + this.f336452d + ", selectedAppCount=" + this.f336453e + ", selectedRuleCount=" + this.f336454f + ", specialContactCount=" + this.f336455g + ", deviceSettings=" + this.f336456h + ')';
    }

    public /* synthetic */ b(int r110) {
        this(null, null, 0, 0, 0, 0, 0, null);
    }

    public b(Integer r100, Integer r101, int r102, int r103, int r104, int r105, int r106, q59.a r107) {
        this.f336449a = r100;
        this.f336450b = r101;
        this.f336451c = r102;
        this.f336452d = r103;
        this.f336453e = r104;
        this.f336454f = r105;
        this.f336455g = r106;
        this.f336456h = r107;
    }
}
