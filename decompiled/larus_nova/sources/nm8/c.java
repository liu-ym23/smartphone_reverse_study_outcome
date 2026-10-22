package nm8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f519605b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f519604a, r101.f519604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519605b, r101.f519605b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f519604a.hashCode() * 31;
        Integer r101 = this.f519605b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MiaodaArtifactCardViewInput(fileName=" + this.f519604a + ", rootBackgroundRes=" + this.f519605b + ')';
    }

    public c(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        this.f519604a = r100;
        this.f519605b = r101;
    }
}
