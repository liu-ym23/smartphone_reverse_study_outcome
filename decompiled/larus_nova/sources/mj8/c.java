package mj8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f514261b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f514260a, r101.f514260a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514261b, r101.f514261b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f514260a.hashCode() * 31;
        Integer r101 = this.f514261b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CodeArtifactCardViewInput(fileName=" + this.f514260a + ", rootBackgroundRes=" + this.f514261b + ')';
    }

    public c(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        this.f514260a = r100;
        this.f514261b = r101;
    }
}
