package zv6;

import jx6.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f573739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573740b;

    public d() {
        this(null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f573739a, r101.f573739a) == true) goto L12;
        return false;
    L12:
        if (this.f573740b == r101.f573740b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        r r100 = this.f573739a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f573740b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PreviewImageDetailPageData(actionParams=" + this.f573739a + ", position=" + this.f573740b + ')';
    }

    public d(r r100, int r101) {
        this.f573739a = r100;
        this.f573740b = r101;
    }
}
