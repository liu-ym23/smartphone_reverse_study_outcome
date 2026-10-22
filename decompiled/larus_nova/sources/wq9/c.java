package wq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f560763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f560764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560765c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f560763a, r101.f560763a) == true) goto L12;
        return false;
    L12:
        if (this.f560764b == r101.f560764b) goto L15;
        return false;
    L15:
        if (this.f560765c == r101.f560765c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f560763a.hashCode() * 31) + this.f560764b) * 31) + this.f560765c;
    }

    public final String toString() {
        return "FlowPolylineOptions(latlngs=" + this.f560763a + ", color=" + this.f560764b + ", width=" + this.f560765c + ')';
    }

    public c(List<a> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "latlngs");
        this.f560763a = r100;
        this.f560764b = r101;
        this.f560765c = r102;
    }
}
