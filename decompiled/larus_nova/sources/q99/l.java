package q99;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f532169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532170b;

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f532169a, r101.f532169a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532170b, r101.f532170b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f532169a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f532170b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowMessageFeedbackError(code=" + this.f532169a + ", tips=" + this.f532170b + ')';
    }

    public l(Integer r100, String r101) {
        this.f532169a = r100;
        this.f532170b = r101;
    }
}
