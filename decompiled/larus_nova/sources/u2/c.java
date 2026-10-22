package u2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f548390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f548391f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f548386a, r101.f548386a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548387b, r101.f548387b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548388c, r101.f548388c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548389d, r101.f548389d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f548390e, r101.f548390e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548391f, r101.f548391f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f548386a.hashCode() * 31) + this.f548387b.hashCode()) * 31) + this.f548388c.hashCode()) * 31) + this.f548389d.hashCode()) * 31;
        String r101 = this.f548390e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f548391f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoubaoAppsMeta(doubaoAppletKey=" + this.f548386a + ", doubaoAppletName=" + this.f548387b + ", doubaoAppletIcon=" + this.f548388c + ", doubaoAppletVersion=" + this.f548389d + ", doubaoAppletType=" + this.f548390e + ", messageData=" + this.f548391f + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, b r105) {
        Intrinsics.checkNotNullParameter(r100, "doubaoAppletKey");
        Intrinsics.checkNotNullParameter(r101, "doubaoAppletName");
        Intrinsics.checkNotNullParameter(r102, "doubaoAppletIcon");
        Intrinsics.checkNotNullParameter(r103, "doubaoAppletVersion");
        Intrinsics.checkNotNullParameter(r105, "messageData");
        this.f548386a = r100;
        this.f548387b = r101;
        this.f548388c = r102;
        this.f548389d = r103;
        this.f548390e = r104;
        this.f548391f = r105;
    }
}
