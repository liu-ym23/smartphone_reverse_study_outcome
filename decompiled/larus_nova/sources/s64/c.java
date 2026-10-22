package s64;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f540805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f540806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f540807d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f540804a, r101.f540804a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f540805b, r101.f540805b) == true) goto L15;
        return false;
    L15:
        if (this.f540806c == r101.f540806c) goto L18;
        return false;
    L18:
        if (this.f540807d == r101.f540807d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f540804a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f540805b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f540806c) * 31) + this.f540807d;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UIComponentInitPhotoUrl(uri=" + this.f540804a + ", urlList=" + this.f540805b + ", width=" + this.f540806c + ", height=" + this.f540807d + ')';
    }

    public c(String r100, List<String> r101, int r102, int r103) {
        this.f540804a = r100;
        this.f540805b = r101;
        this.f540806c = r102;
        this.f540807d = r103;
    }
}
