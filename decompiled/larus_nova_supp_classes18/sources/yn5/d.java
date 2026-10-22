package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public final boolean b;

    public d() {
        this(false, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateBitableSelectResult(workspaceToken=" + this.a + ", needNewWorkspace=" + this.b + ')';
    }

    public /* synthetic */ d(boolean r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        r1 = false;
    L5:
        this(null, r1);
    }

    public d(String r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
