package ar5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final int b;
    public final String c;
    public final String d;

    /* JADX INFO: renamed from: ar5.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    static {
    }

    public /* synthetic */ a() {
        throw null;
    }

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "WikiPathResolveContext(visibleSpaceId=" + this.a + ", scene=" + this.b + ", targetWikiToken=" + this.c + ", loadIdentity=" + this.d + ')';
    }

    public a(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "visibleSpaceId");
        Intrinsics.checkNotNullParameter(r4, "targetWikiToken");
        Intrinsics.checkNotNullParameter(r5, "loadIdentity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
