package nz8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521553b;

    public b() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f521552a, r101.f521552a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521553b, r101.f521553b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f521552a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f521553b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TraceConfig(previousPage=" + this.f521552a + ", enterMethod=" + this.f521553b + ')';
    }

    public b(String r100, String r101) {
        this.f521552a = r100;
        this.f521553b = r101;
    }
}
