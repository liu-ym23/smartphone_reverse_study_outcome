package fi3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f477344a;

    public static final class a {
    }

    static {
    }

    public x() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477344a, ((x) r100).f477344a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f477344a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PDPPreloadLynxActionParam(preloadComponents=" + this.f477344a + ")";
    }

    public x(List<String> r100) {
        this.f477344a = r100;
    }
}
