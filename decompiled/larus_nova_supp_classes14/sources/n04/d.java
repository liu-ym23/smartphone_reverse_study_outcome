package n04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "ProfileShoppingCardCommonParams(entranceLocation=" + this.a + ", storeSourcePage=" + this.b + ", storeGroupType=" + this.c + ", storeSourceMethod=" + this.d + ", authorOpenId=" + this.e + ", ecSourcePage=" + this.f + ')';
    }

    public d(String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r3, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r4, "storeGroupType");
        Intrinsics.checkNotNullParameter(r5, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r6, "authorOpenId");
        Intrinsics.checkNotNullParameter(r7, "ecSourcePage");
        this.a = "others_homepage";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
