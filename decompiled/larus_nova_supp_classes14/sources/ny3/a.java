package ny3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final String b;
    public final int c;
    public final String d;

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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "CommentDiggBuryEvent(aid=" + this.a + ", cid=" + this.b + ", diggType=" + this.c + ", sessionId=" + this.d + ')';
    }

    public a(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "aid");
        Intrinsics.checkNotNullParameter(r3, "cid");
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
