package com.larus.dora.impl.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f337896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f337897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f337898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f337899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f337900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f337901f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f337896a, r101.f337896a) == true) goto L12;
        return false;
    L12:
        if (this.f337897b == r101.f337897b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f337898c, r101.f337898c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f337899d, r101.f337899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f337900e, r101.f337900e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f337901f, r101.f337901f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f337896a.hashCode() * 31;
        long r101 = this.f337897b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f337898c;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((((((r102 + r104) * 31) + this.f337899d.hashCode()) * 31) + this.f337900e.hashCode()) * 31) + this.f337901f.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraResourceArtifactManifest(packageId=" + this.f337896a + ", versionCode=" + this.f337897b + ", versionName=" + this.f337898c + ", sha256=" + this.f337899d + ", uri=" + this.f337900e + ", downloadUrl=" + this.f337901f + ')';
    }

    public n(String r100, long r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "packageId");
        Intrinsics.checkNotNullParameter(r103, "sha256");
        Intrinsics.checkNotNullParameter(r104, "uri");
        Intrinsics.checkNotNullParameter(r105, "downloadUrl");
        this.f337896a = r100;
        this.f337897b = r101;
        this.f337898c = r102;
        this.f337899d = r103;
        this.f337900e = r104;
        this.f337901f = r105;
    }
}
