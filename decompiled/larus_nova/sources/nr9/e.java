package nr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f520250c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f520248a == r101.f520248a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520249b, r101.f520249b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520250c, r101.f520250c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f520248a * 31) + this.f520249b.hashCode()) * 31;
        Boolean r101 = this.f520250c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SaveVideoResult(code=" + this.f520248a + ", path=" + this.f520249b + ", mdlCacheHit=" + this.f520250c + ')';
    }

    public e(int r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f520248a = r100;
        this.f520249b = r101;
        this.f520250c = r102;
    }
}
