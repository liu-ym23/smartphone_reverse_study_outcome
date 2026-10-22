package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489043b;

    public d0() {
        this(false, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (this.f489042a == r101.f489042a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489043b, r101.f489043b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f489042a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f489043b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "FoldOrExpandAnimation(forceFoldOrExpandAnimation=" + this.f489042a + ", triggerFoldOrExpandTitle=" + this.f489043b + ')';
    }

    public d0(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "triggerFoldOrExpandTitle");
        this.f489042a = r100;
        this.f489043b = r101;
    }
}
