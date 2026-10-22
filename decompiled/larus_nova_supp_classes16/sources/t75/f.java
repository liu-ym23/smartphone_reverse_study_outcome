package t75;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final long a;
    public final List<g> b;

    public f() {
        this(0, 3);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DrivePreviewAiResourceSnapshot(generation=" + this.a + ", selections=" + this.b + ')';
    }

    public /* synthetic */ f(long r2, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        List r5 = CollectionsKt.emptyList();
    L9:
        this(r2, r5);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public f(long r2, List<g> r4) {
        Intrinsics.checkNotNullParameter(r4, "selections");
        this.a = r2;
        this.b = r4;
    }
}
