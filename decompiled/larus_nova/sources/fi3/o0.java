package fi3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477295a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477295a, ((o0) r100).f477295a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f477295a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PdpRefreshStateChangeParams(refreshScene=" + this.f477295a + ")";
    }

    public o0() {
        Intrinsics.checkNotNullParameter("", "refreshScene");
        this.f477295a = "";
    }
}
