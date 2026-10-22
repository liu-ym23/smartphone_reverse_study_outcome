package com.larus.agents.impl.settings;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f286713b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f286712a, r101.f286712a) == true) goto L12;
        return false;
    L12:
        if (this.f286713b == r101.f286713b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f286712a.hashCode() * 31;
        long r101 = this.f286713b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "OfficeTaskPreference(instruction=" + this.f286712a + ", revision=" + this.f286713b + ')';
    }

    public b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "instruction");
        this.f286712a = r100;
        this.f286713b = r101;
    }
}
