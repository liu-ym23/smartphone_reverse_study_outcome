package zb9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f571194b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f571193a == r101.f571193a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571194b, r101.f571194b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f571193a * 31) + this.f571194b.hashCode();
    }

    public final String toString() {
        return "LoadRequest(pageSize=" + this.f571193a + ", ext=" + this.f571194b + ')';
    }

    public j(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "ext");
        this.f571193a = r100;
        this.f571194b = r101;
    }
}
