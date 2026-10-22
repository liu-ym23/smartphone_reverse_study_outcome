package b48;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public final Map<String, Object> a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AccountOperationResult(extra=" + this.a + ')';
    }

    public g(Object r2) {
        Map<String, Object> r3 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.a = r3;
    }
}
