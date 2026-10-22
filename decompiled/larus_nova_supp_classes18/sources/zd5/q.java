package zd5;

import com.bytedance.ee.bear.list.sort.SortAscType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public int a;
    public final int b;
    public boolean c;
    public final String d;
    public final Integer e;
    public final SortAscType f;

    public q(int r10, int r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "reportSort");
        this(r10, r11, r12, r13, null, null, 48);
    }

    public q(int r10, int r11, boolean r12, String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r13, "reportSort");
        this(r10, r11, r12, r13, r14, null, 32);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.d.hashCode()) * 31;
        Integer r3 = this.e;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return ((r2 + r4) * 31) + this.f.hashCode();
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SortType(resId=" + this.a + ", rank=" + this.b + ", asc=" + this.c + ", reportSort=" + this.d + ", forbiddenFilterResId=" + this.e + ", sortAscType=" + this.f + ')';
    }

    public q(int r2, int r3, boolean r4, String r5, Integer r6, SortAscType r7, int r8) {
        if ((r8 & 16) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r8 & 32) == 0) goto L8;
        r7 = SortAscType.TIME;
    L8:
        Intrinsics.checkNotNullParameter(r5, "reportSort");
        Intrinsics.checkNotNullParameter(r7, "sortAscType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
