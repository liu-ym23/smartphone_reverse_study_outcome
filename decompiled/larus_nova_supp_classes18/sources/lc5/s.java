package lc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public final com.bytedance.ee.bear.contract.d a;
    public final boolean b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        String r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return ((((r2 + r4) * 31) + this.e) * 31) + this.f.hashCode();
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReportRemoveManualOfflineParam(analyticService=" + this.a + ", isGrid=" + this.b + ", module=" + this.c + ", objToken=" + this.d + ", type=" + this.e + ", result=" + this.f + ')';
    }

    public final int getType() {
        return this.e;
    }

    public s(com.bytedance.ee.bear.contract.d r2, boolean r3, String r4, String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r7, "result");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
