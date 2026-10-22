package nvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520928a;

    /* JADX INFO: renamed from: nvb.a$a, reason: collision with other inner class name */
    public static final class C6980a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f520928a, ((a) r100).f520928a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f520928a.hashCode();
    }

    static {
        new a("mm_hardware_placeholder");
    }

    public final String toString() {
        return this.f520928a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f520928a = r100;
    }
}
