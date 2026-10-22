package com.larus.dora.impl.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f337893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f337894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f337895c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f337893a, r101.f337893a) == true) goto L12;
        return false;
    L12:
        if (this.f337894b == r101.f337894b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f337895c, r101.f337895c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f337893a.hashCode() * 31;
        long r101 = this.f337894b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f337895c.hashCode();
    }

    public final String toString() {
        return "DoraResourceArtifactIdentity(packageId=" + this.f337893a + ", versionCode=" + this.f337894b + ", sha256=" + this.f337895c + ')';
    }

    public final String a() {
        return this.f337893a;
    }

    public m(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "packageId");
        Intrinsics.checkNotNullParameter(r102, "sha256");
        this.f337893a = r100;
        this.f337894b = r101;
        this.f337895c = r102;
    }
}
