package com.larus.im.internal.tracking.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f350433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f350434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f350435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f350436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f350437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f350438f;

    public s() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f350433a, r101.f350433a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350434b, r101.f350434b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350435c, r101.f350435c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350436d, r101.f350436d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350437e, r101.f350437e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f350438f, r101.f350438f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f350433a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f350434b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f350435c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f350436d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f350437e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f350438f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "NetworkTrackMetrics(totalMs=" + this.f350433a + ", connectMs=" + this.f350434b + ", dnsMs=" + this.f350435c + ", sendMs=" + this.f350436d + ", waitMs=" + this.f350437e + ", receiveMs=" + this.f350438f + ')';
    }

    public s(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105) {
        this.f350433a = r100;
        this.f350434b = r101;
        this.f350435c = r102;
        this.f350436d = r103;
        this.f350437e = r104;
        this.f350438f = r105;
    }
}
