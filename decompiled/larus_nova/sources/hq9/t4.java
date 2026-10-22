package hq9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f486778b;

    public t4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r101 = (t4) r100;
        if (this.f486777a == r101.f486777a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486778b, r101.f486778b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f486777a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f486778b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "UGReturnConfig(enable=" + this.f486777a + ", titles=" + this.f486778b + ')';
    }

    public /* synthetic */ t4(int r100) {
        this(false, MapsKt.emptyMap());
    }

    public t4(boolean r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "titles");
        this.f486777a = r100;
        this.f486778b = r101;
    }
}
