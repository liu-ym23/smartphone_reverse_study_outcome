package com.larus.dora.impl.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraResourceArtifactUpdateAction f337904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f337905b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f337904a == r101.f337904a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f337905b, r101.f337905b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f337904a.hashCode() * 31;
        m r101 = this.f337905b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraResourceArtifactUpdateDecision(action=" + this.f337904a + ", identity=" + this.f337905b + ')';
    }

    public p(DoraResourceArtifactUpdateAction r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f337904a = r100;
        this.f337905b = r101;
    }
}
