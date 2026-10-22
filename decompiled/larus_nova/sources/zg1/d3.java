package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571817a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d3) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f571817a, ((d3) r100).f571817a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f571817a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StopRecordEvent(source=" + this.f571817a + ")";
    }

    public d3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f571817a = r100;
    }
}
