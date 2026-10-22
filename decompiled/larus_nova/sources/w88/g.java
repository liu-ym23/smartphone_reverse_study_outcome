package w88;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f558664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f558667d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f558664a, r101.f558664a) == true) goto L12;
        return false;
    L12:
        if (this.f558665b == r101.f558665b) goto L15;
        return false;
    L15:
        if (this.f558666c == r101.f558666c) goto L18;
        return false;
    L18:
        if (this.f558667d == r101.f558667d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f558664a.hashCode() * 31) + this.f558665b) * 31) + this.f558666c) * 31) + this.f558667d;
    }

    public final String toString() {
        return "DoraOAlbumPreviewData(items=" + this.f558664a + ", totalCount=" + this.f558665b + ", unsyncedImageCount=" + this.f558666c + ", unsyncedVideoCount=" + this.f558667d + ')';
    }

    public g(List<h> r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f558664a = r100;
        this.f558665b = r101;
        this.f558666c = r102;
        this.f558667d = r103;
    }
}
