package n04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f516573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f516574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f516575f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f516570a, r101.f516570a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516571b, r101.f516571b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f516572c, r101.f516572c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f516573d, r101.f516573d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f516574e, r101.f516574e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f516575f, r101.f516575f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f516570a.hashCode() * 31) + this.f516571b.hashCode()) * 31) + this.f516572c.hashCode()) * 31) + this.f516573d.hashCode()) * 31) + this.f516574e.hashCode()) * 31) + this.f516575f.hashCode();
    }

    public final String toString() {
        return "ProfileShoppingCardCommonParams(entranceLocation=" + this.f516570a + ", storeSourcePage=" + this.f516571b + ", storeGroupType=" + this.f516572c + ", storeSourceMethod=" + this.f516573d + ", authorOpenId=" + this.f516574e + ", ecSourcePage=" + this.f516575f + ')';
    }

    public d(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r100, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r101, "storeGroupType");
        Intrinsics.checkNotNullParameter(r102, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r103, "authorOpenId");
        Intrinsics.checkNotNullParameter(r104, "ecSourcePage");
        this.f516570a = "others_homepage";
        this.f516571b = r100;
        this.f516572c = r101;
        this.f516573d = r102;
        this.f516574e = r103;
        this.f516575f = r104;
    }
}
