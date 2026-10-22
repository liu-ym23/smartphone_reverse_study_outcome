package fi3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x {
    public final List<String> a;

    public static final class a {
    }

    static {
    }

    public x() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof x) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((x) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "PDPPreloadLynxActionParam(preloadComponents=" + this.a + ")";
    }

    public x(List<String> r1) {
        this.a = r1;
    }
}
