package com.larus.security.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f367864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f367865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f367866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f367867g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f367861a, r101.f367861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367862b, r101.f367862b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367863c, r101.f367863c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367864d, r101.f367864d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367865e, r101.f367865e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f367866f, r101.f367866f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f367867g, r101.f367867g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f367861a.hashCode() * 31) + this.f367862b.hashCode()) * 31) + this.f367863c.hashCode()) * 31) + this.f367864d.hashCode()) * 31) + this.f367865e.hashCode()) * 31) + this.f367866f.hashCode()) * 31) + this.f367867g.hashCode();
    }

    public final String toString() {
        return "TtCnpaManifestInfo(label=" + this.f367861a + ", contentProducer=" + this.f367862b + ", produceId=" + this.f367863c + ", reservedCode1=" + this.f367864d + ", contentPropagator=" + this.f367865e + ", propagateId=" + this.f367866f + ", reservedCode2=" + this.f367867g + ')';
    }

    public l(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "contentProducer");
        Intrinsics.checkNotNullParameter(r102, "produceId");
        Intrinsics.checkNotNullParameter(r103, "reservedCode1");
        Intrinsics.checkNotNullParameter(r104, "contentPropagator");
        Intrinsics.checkNotNullParameter(r105, "propagateId");
        Intrinsics.checkNotNullParameter(r106, "reservedCode2");
        this.f367861a = r100;
        this.f367862b = r101;
        this.f367863c = r102;
        this.f367864d = r103;
        this.f367865e = r104;
        this.f367866f = r105;
        this.f367867g = r106;
    }
}
