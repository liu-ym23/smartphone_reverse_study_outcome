package f10;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475040a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f475040a, ((b) r100).f475040a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f475040a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "InteractGroupNameItem(groupNames=" + this.f475040a + ")";
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupNames");
        this.f475040a = r100;
    }
}
