package lk9;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f509641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<f> f509642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f509643c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f509641a, r101.f509641a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509642b, r101.f509642b) == true) goto L15;
        return false;
    L15:
        if (this.f509643c == r101.f509643c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f509641a.hashCode() * 31;
        CopyOnWriteArrayList<f> r101 = this.f509642b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f509643c;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProcessContext(mediaStack=" + this.f509641a + ", currentTop=" + this.f509642b + ", focusChange=" + this.f509643c + ')';
    }

    public o(j r100, CopyOnWriteArrayList<f> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mediaStack");
        this.f509641a = r100;
        this.f509642b = r101;
        this.f509643c = r102;
    }
}
