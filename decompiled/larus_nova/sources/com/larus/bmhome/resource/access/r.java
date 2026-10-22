package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f313725d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f313722a, r101.f313722a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313723b, r101.f313723b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313724c, r101.f313724c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313725d, r101.f313725d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f313722a.hashCode() * 31) + this.f313723b.hashCode()) * 31) + this.f313724c.hashCode()) * 31;
        Throwable r101 = this.f313725d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceAccessError(stage=" + this.f313722a + ", code=" + this.f313723b + ", message=" + this.f313724c + ", cause=" + this.f313725d + ')';
    }

    public r(String r100, String r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f313722a = r100;
        this.f313723b = r101;
        this.f313724c = r102;
        this.f313725d = r103;
    }
}
