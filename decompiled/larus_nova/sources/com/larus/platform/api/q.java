package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExternalRouteLaunchMode f365245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365246c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f365244a, r101.f365244a) == true) goto L12;
        return false;
    L12:
        if (this.f365245b == r101.f365245b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365246c, r101.f365246c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f365244a.hashCode() * 31) + this.f365245b.hashCode()) * 31) + this.f365246c.hashCode();
    }

    public final String toString() {
        return "ExternalRouteSession(id=" + this.f365244a + ", launchMode=" + this.f365245b + ", schema=" + this.f365246c + ')';
    }

    public q(String r100, ExternalRouteLaunchMode r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "launchMode");
        Intrinsics.checkNotNullParameter(r102, "schema");
        this.f365244a = r100;
        this.f365245b = r101;
        this.f365246c = r102;
    }
}
