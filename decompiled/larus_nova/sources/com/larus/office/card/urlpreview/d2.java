package com.larus.office.card.urlpreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f361885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<List<String>> f361886b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d2) == true) goto L8;
        return false;
    L8:
        d2 r101 = (d2) r100;
        if (Intrinsics.areEqual(this.f361885a, r101.f361885a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361886b, r101.f361886b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f361885a.hashCode() * 31) + this.f361886b.hashCode();
    }

    public final String toString() {
        return "OfficeUrlPreviewRequestPlan(normalizedUrls=" + this.f361885a + ", requestBatches=" + this.f361886b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d2(List<String> r100, List<? extends List<String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "normalizedUrls");
        Intrinsics.checkNotNullParameter(r101, "requestBatches");
        this.f361885a = r100;
        this.f361886b = r101;
    }
}
