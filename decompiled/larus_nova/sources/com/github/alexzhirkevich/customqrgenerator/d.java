package com.github.alexzhirkevich.customqrgenerator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f274246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f274247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f274248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f274249d;

    public d() {
        this(0);
    }

    public final int hashCode() {
        return (((((this.f274246a.hashCode() * 31) + this.f274247b.hashCode()) * 31) + this.f274248c.hashCode()) * 31) + Float.floatToIntBits(this.f274249d);
    }

    public final String toString() {
        return "QrHighlighting(cornerEyes=" + this.f274246a + ", versionEyes=" + this.f274247b + ", timingLines=" + this.f274248c + ", alpha=" + this.f274249d + ')';
    }

    public d(int r100) {
        a.b r101 = a.b.f274242a;
        Intrinsics.checkNotNullParameter(r101, "cornerEyes");
        Intrinsics.checkNotNullParameter(r101, "versionEyes");
        Intrinsics.checkNotNullParameter(r101, "timingLines");
        this.f274246a = r101;
        this.f274247b = r101;
        this.f274248c = r101;
        this.f274249d = 0.75f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f274246a, r101.f274246a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f274247b, r101.f274247b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f274248c, r101.f274248c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.f274249d), Float.valueOf(r101.f274249d)) == true) goto L20;
        return false;
    L20:
        return true;
    }
}
