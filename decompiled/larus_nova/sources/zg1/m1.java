package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571879a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m1) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f571879a, ((m1) r100).f571879a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f571879a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveProfileDialogDismissEvent(userId=" + this.f571879a + ")";
    }

    public m1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f571879a = r100;
    }
}
