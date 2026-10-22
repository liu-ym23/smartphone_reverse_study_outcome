package zw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dx6.j f573843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f573844b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f573843a, r101.f573843a) == true) goto L12;
        return false;
    L12:
        if (this.f573844b == r101.f573844b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573843a.hashCode() * 31;
        if (this.f573844b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubViewExposeData(data=" + this.f573843a + ", hasExposed=" + this.f573844b + ')';
    }

    public j(dx6.j r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f573843a = r100;
        this.f573844b = false;
    }
}
