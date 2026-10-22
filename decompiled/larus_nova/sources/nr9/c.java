package nr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f520247b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f520246a, r101.f520246a) == true) goto L12;
        return false;
    L12:
        if (this.f520247b == r101.f520247b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520246a.hashCode() * 31;
        if (this.f520247b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MdlCacheSaveResult(path=" + this.f520246a + ", hit=" + this.f520247b + ')';
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f520246a = r100;
        this.f520247b = true;
    }
}
