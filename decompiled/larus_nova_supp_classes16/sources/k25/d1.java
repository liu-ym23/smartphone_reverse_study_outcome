package k25;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d1 {
    public final Object[] a;

    public d1() {
        this.a = new Object[64];
        int r0 = 0;
    L3:
        Object[] r1 = this.a;
        if (r0 >= r1.length) goto L6;
        r1[r0] = new Object();
        r0 = r0 + 1;
        goto L3
    }

    public final Object a(m0 r3, boolean r4) {
        if (r3 == null) goto L15;
        if (r4 == false) goto L15;
        int r5 = ((((Objects.hashCode(r3.k) + 527) * 31) + Objects.hashCode(r3.b)) * 31) + r3.p;
        Object[] r6 = this.a;
        int r0 = r6.length;
        int r1 = r5 % r0;
        if (r1 != 0) goto L9;
        int r7 = 0;
    L14:
        return r6[r7];
    L9:
        if ((((r5 ^ r0) >> 31) | 1) > 0) goto L12;
        r1 = r1 + r0;
    L12:
        r7 = r1;
    L15:
        return this;
    }
}
