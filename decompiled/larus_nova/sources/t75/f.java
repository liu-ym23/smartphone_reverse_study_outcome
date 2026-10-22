package t75;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f544890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f544891b;

    public f() {
        this(0, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f544890a == r101.f544890a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544891b, r101.f544891b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f544890a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f544891b.hashCode();
    }

    public final String toString() {
        return "DrivePreviewAiResourceSnapshot(generation=" + this.f544890a + ", selections=" + this.f544891b + ')';
    }

    public /* synthetic */ f(long r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r101 & 2) == 0) goto L8;
        List r102 = CollectionsKt.emptyList();
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public f(long r100, List<g> r101) {
        Intrinsics.checkNotNullParameter(r101, "selections");
        this.f544890a = r100;
        this.f544891b = r101;
    }
}
