package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l<S extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<S> f499139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f499140b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f499139a, r101.f499139a) == true) goto L12;
        return false;
    L12:
        if (this.f499140b == r101.f499140b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499139a.hashCode() * 31;
        long r101 = this.f499140b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "TaskHandle(taskFlowId=" + this.f499139a + ", epoch=" + this.f499140b + ')';
    }

    public l(g<S> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "taskFlowId");
        this.f499139a = r100;
        this.f499140b = r101;
    }
}
