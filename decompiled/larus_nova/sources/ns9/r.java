package ns9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f520403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f520404b;

    public r() {
        Map r100 = null;
        this(r100, r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f520403a, r101.f520403a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520404b, r101.f520404b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f520403a.hashCode() * 31) + this.f520404b.hashCode();
    }

    public final String toString() {
        return "ReachPayload(passThrough=" + this.f520403a + ", extra=" + this.f520404b + ')';
    }

    public r(Map<String, String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "passThrough");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f520403a = r100;
        this.f520404b = r101;
    }

    public /* synthetic */ r(Map r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        this(r100, r101);
    }
}
