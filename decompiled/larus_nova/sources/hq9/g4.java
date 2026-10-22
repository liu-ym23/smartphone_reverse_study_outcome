package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f486616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f486617b;

    public g4() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g4) == true) goto L8;
        return false;
    L8:
        g4 r101 = (g4) r100;
        if (Intrinsics.areEqual(this.f486616a, r101.f486616a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486617b, r101.f486617b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f486616a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f486617b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RtcCapabilityConfig(enable=" + this.f486616a + ", supportLink=" + this.f486617b + ')';
    }

    public g4(Boolean r100, List<String> r101) {
        this.f486616a = r100;
        this.f486617b = r101;
    }
}
