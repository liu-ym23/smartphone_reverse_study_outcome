package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class p<S extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<S> f499147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f499148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f499149c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f499147a, r101.f499147a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499148b, r101.f499148b) == true) goto L15;
        return false;
    L15:
        if (this.f499149c == r101.f499149c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f499147a.hashCode() * 31) + this.f499148b.hashCode()) * 31;
        if (this.f499149c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "[sticky=" + this.f499149c + ",taskState=" + this.f499148b + ']';
    }

    public p(g<S> r100, S r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "taskFlowId");
        Intrinsics.checkNotNullParameter(r101, "taskState");
        this.f499147a = r100;
        this.f499148b = r101;
        this.f499149c = r102;
    }
}
