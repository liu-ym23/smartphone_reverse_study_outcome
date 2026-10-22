package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m<S extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<S> f499141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f499142b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f499141a, r101.f499141a) == true) goto L12;
        return false;
    L12:
        if (this.f499142b == r101.f499142b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499141a.hashCode() * 31;
        if (this.f499142b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskHandleAcquisition(handle=" + this.f499141a + ", started=" + this.f499142b + ')';
    }

    public m(l<S> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        this.f499141a = r100;
        this.f499142b = r101;
    }
}
