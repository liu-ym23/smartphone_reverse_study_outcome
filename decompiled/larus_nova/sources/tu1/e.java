package tu1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547602a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547602a, ((e) r100).f547602a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f547602a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Word(content=" + this.f547602a + ")";
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f547602a = r100;
    }
}
