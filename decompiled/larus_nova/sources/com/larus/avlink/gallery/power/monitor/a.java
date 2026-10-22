package com.larus.avlink.gallery.power.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f292655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f292656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f292657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f292658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f292659e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f292655a == r101.f292655a) goto L12;
        return false;
    L12:
        if (this.f292656b == r101.f292656b) goto L15;
        return false;
    L15:
        if (this.f292657c == r101.f292657c) goto L18;
        return false;
    L18:
        if (this.f292658d == r101.f292658d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f292659e, r101.f292659e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f292655a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f292656b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f292657c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f292658d == false) goto L5;
        int r106 = 1231;
    L7:
        return ((r105 + r106) * 31) + this.f292659e.hashCode();
    L5:
        r106 = 1237;
        goto L7
    }

    public final String toString() {
        return "AlbumVideoThermalMetrics(durationMs=" + this.f292655a + ", moderateDurationMs=" + this.f292656b + ", severeDurationMs=" + this.f292657c + ", thermalValid=" + this.f292658d + ", result=" + this.f292659e + ')';
    }

    public a(long r100, long r101, long r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "result");
        this.f292655a = r100;
        this.f292656b = r101;
        this.f292657c = r102;
        this.f292658d = r103;
        this.f292659e = r104;
    }
}
