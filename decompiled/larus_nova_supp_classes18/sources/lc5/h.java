package lc5;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final com.bytedance.ee.bear.contract.d a;
    public final boolean b;
    public final String c;
    public final Document d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ReportAddManualLineParam(analyticService=" + this.a + ", isGrid=" + this.b + ", module=" + this.c + ", item=" + this.d + ", result=" + this.e + ')';
    }

    public h(com.bytedance.ee.bear.contract.d r2, boolean r3, String r4, Document r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r6, "result");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
