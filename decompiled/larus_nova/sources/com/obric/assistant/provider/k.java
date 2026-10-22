package com.obric.assistant.provider;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f391204b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f391203a, r101.f391203a) == true) goto L12;
        return false;
    L12:
        if (this.f391204b == r101.f391204b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f391203a.hashCode() * 31) + this.f391204b;
    }

    public final String toString() {
        return "ProviderUriConfig(path=" + this.f391203a + ", code=" + this.f391204b + ')';
    }

    public k(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f391203a = r100;
        this.f391204b = r101;
    }
}
