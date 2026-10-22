package com.larus.security.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f367871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f367872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f367873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f367874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f367875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f367876i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f367868a, r101.f367868a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367869b, r101.f367869b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367870c, r101.f367870c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367871d, r101.f367871d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367872e, r101.f367872e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f367873f, r101.f367873f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f367874g, r101.f367874g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f367875h, r101.f367875h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f367876i, r101.f367876i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((this.f367868a.hashCode() * 31) + this.f367869b.hashCode()) * 31) + this.f367870c.hashCode()) * 31) + this.f367871d.hashCode()) * 31) + this.f367872e.hashCode()) * 31) + this.f367873f.hashCode()) * 31) + this.f367874g.hashCode()) * 31) + this.f367875h.hashCode()) * 31) + this.f367876i.hashCode();
    }

    public final String toString() {
        return "TtCnpaManualWriteParams(inputFilePath=" + this.f367868a + ", outputFilePath=" + this.f367869b + ", label=" + this.f367870c + ", contentProducer=" + this.f367871d + ", produceId=" + this.f367872e + ", reservedCode1=" + this.f367873f + ", contentPropagator=" + this.f367874g + ", propagateId=" + this.f367875h + ", reservedCode2=" + this.f367876i + ')';
    }

    public m(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "inputFilePath");
        Intrinsics.checkNotNullParameter(r101, "outputFilePath");
        Intrinsics.checkNotNullParameter("1", "label");
        Intrinsics.checkNotNullParameter("001191110102MACQD9K64010000", "contentProducer");
        Intrinsics.checkNotNullParameter(r102, "produceId");
        Intrinsics.checkNotNullParameter("", "reservedCode1");
        Intrinsics.checkNotNullParameter("", "contentPropagator");
        Intrinsics.checkNotNullParameter("", "propagateId");
        Intrinsics.checkNotNullParameter("", "reservedCode2");
        this.f367868a = r100;
        this.f367869b = r101;
        this.f367870c = "1";
        this.f367871d = "001191110102MACQD9K64010000";
        this.f367872e = r102;
        this.f367873f = "";
        this.f367874g = "";
        this.f367875h = "";
        this.f367876i = "";
    }
}
