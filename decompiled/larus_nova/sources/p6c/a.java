package p6c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f527967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f527968b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527967a, r101.f527967a) == true) goto L12;
        return false;
    L12:
        if (this.f527968b == r101.f527968b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f527967a.hashCode() * 31;
        long r101 = this.f527968b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AddChatTabListResult(result=" + this.f527967a + ", newTabId=" + this.f527968b + ')';
    }

    public a(c r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f527967a = r100;
        this.f527968b = r101;
    }
}
