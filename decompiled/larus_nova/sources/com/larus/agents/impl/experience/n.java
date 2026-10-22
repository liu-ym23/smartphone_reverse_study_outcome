package com.larus.agents.impl.experience;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f286678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286680c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f286678a, r101.f286678a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286679b, r101.f286679b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286680c, r101.f286680c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f286678a.hashCode() * 31) + this.f286679b.hashCode()) * 31) + this.f286680c.hashCode();
    }

    public final String toString() {
        return "WorkExperienceDetail(summary=" + this.f286678a + ", details=" + this.f286679b + ", fullContent=" + this.f286680c + ')';
    }

    public n(t r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "summary");
        Intrinsics.checkNotNullParameter(r101, "details");
        Intrinsics.checkNotNullParameter(r102, "fullContent");
        this.f286678a = r100;
        this.f286679b = r101;
        this.f286680c = r102;
    }
}
