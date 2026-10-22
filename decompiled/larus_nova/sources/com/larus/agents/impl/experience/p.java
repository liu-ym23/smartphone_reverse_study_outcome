package com.larus.agents.impl.experience;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f286684d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f286681a, r101.f286681a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286682b, r101.f286682b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286683c, r101.f286683c) == true) goto L18;
        return false;
    L18:
        if (this.f286684d == r101.f286684d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f286681a.hashCode() * 31) + this.f286682b.hashCode()) * 31) + this.f286683c.hashCode()) * 31;
        if (this.f286684d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "WorkExperienceDraft(name=" + this.f286681a + ", description=" + this.f286682b + ", details=" + this.f286683c + ", autoOptimize=" + this.f286684d + ')';
    }

    public p(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "details");
        this.f286681a = r100;
        this.f286682b = r101;
        this.f286683c = r102;
        this.f286684d = r103;
    }
}
