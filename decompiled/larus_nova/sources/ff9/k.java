package ff9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476772b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f476771a, r101.f476771a) == true) goto L12;
        return false;
    L12:
        if (this.f476772b == r101.f476772b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f476771a.hashCode() * 31) + this.f476772b;
    }

    public final String toString() {
        return "FlowRTCJoinRoomMergeConfig(message=" + this.f476771a + ", startSessionTimeout=" + this.f476772b + ')';
    }

    public k(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f476771a = r100;
        this.f476772b = r101;
    }
}
