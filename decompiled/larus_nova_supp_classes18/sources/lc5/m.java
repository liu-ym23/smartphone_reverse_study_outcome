package lc5;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public final com.bytedance.ee.bear.contract.d a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final Document f;
    public final int g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.f.hashCode()) * 31) + this.g;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ReportItemClickParam(analyticService=" + this.a + ", module=" + this.b + ", subModule=" + this.c + ", position=" + this.d + ", isGrid=" + this.e + ", item=" + this.f + ", deepIndex=" + this.g + ')';
    }

    public m(com.bytedance.ee.bear.contract.d r2, String r3, String r4, int r5, boolean r6, Document r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "subModule");
        Intrinsics.checkNotNullParameter(r7, "item");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
