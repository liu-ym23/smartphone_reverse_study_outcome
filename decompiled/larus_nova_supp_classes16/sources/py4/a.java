package py4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventHandlerParams(token=" + this.a + ", module=" + this.b + ", eventType=" + this.c + ", outer=" + this.d + ')';
    }

    public a(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "eventType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
