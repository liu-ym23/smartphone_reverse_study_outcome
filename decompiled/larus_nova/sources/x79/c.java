package x79;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f562847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f562848b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f562847a, r101.f562847a) == true) goto L12;
        return false;
    L12:
        if (this.f562848b == r101.f562848b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<b> r100 = this.f562847a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f562848b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatRecentFileLoadResult(fileList=" + this.f562847a + ", hasMore=" + this.f562848b + ')';
    }

    public c(List<b> r100, boolean r101) {
        this.f562847a = r100;
        this.f562848b = r101;
    }
}
