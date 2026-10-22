package f92;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f475958a = null;

    static {
        f475958a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        ti6.f r102 = (ti6.f) r100;
        ti6.f r103 = (ti6.f) r101;
        Intrinsics.checkNotNullParameter(r102, "regionL");
        Intrinsics.checkNotNullParameter(r103, "regionR");
        double r104 = r102.f546163e;
        double r105 = r103.f546163e;
        if (r104 == r105) goto L6;
        if (r104 >= r105) goto L12;
    L5:
        return -1;
    L12:
        return 1;
    L6:
        double r106 = r102.f546162d;
        double r107 = r103.f546162d;
        if (r106 == r107) goto L10;
        if (r106 < r107) goto L5;
        return 1;
    L10:
        return 0;
    }
}
