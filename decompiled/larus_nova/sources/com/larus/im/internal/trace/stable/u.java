package com.larus.im.internal.trace.stable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f350214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f350215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f350216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f350217d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f350214a, r101.f350214a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350215b, r101.f350215b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350216c, r101.f350216c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350217d, r101.f350217d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f350214a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f350215b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f350216c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f350217d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "RealtimeCallLatencyStages(answerStartDuration=" + this.f350214a + ", serverLinkDuration=" + this.f350215b + ", audioFirstLinkDuration=" + this.f350216c + ", audioFirstProcessDuration=" + this.f350217d + ')';
    }

    public u(Long r100, Long r101, Long r102, Long r103) {
        this.f350214a = r100;
        this.f350215b = r101;
        this.f350216c = r102;
        this.f350217d = r103;
    }
}
