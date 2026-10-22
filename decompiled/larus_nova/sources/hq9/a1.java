package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f486526a;

    public static final class a {
    }

    static {
    }

    public a1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486526a, ((a1) r100).f486526a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g r100 = this.f486526a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DoraXLinkCommonConfig(android=" + this.f486526a + ')';
    }

    public a1(g r100) {
        this.f486526a = r100;
    }
}
