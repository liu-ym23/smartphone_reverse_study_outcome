package ts2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f547360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f547361b;

    public q() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f547360a, r101.f547360a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547361b, r101.f547361b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f547360a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f547361b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnTryUserCloseData(eventAction=" + this.f547360a + ", extra=" + this.f547361b + ")";
    }

    public q(Integer r100, Map<String, String> r101) {
        this.f547360a = r100;
        this.f547361b = r101;
    }
}
