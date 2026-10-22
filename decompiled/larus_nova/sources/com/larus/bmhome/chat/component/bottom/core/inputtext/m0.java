package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f298773b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f298772a, r101.f298772a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298773b, r101.f298773b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f298772a.hashCode() * 31) + this.f298773b.hashCode();
    }

    public final String toString() {
        return "InputReferencePlaceholder(token=" + this.f298772a + ", reference=" + this.f298773b + ')';
    }

    public m0(String r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "reference");
        this.f298772a = r100;
        this.f298773b = r101;
    }
}
