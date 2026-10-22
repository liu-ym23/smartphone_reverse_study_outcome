package vs6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f557056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f557057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f557058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f557059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f557060f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f557055a, r101.f557055a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f557056b, r101.f557056b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f557057c, r101.f557057c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f557058d, r101.f557058d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f557059e, r101.f557059e) == true) goto L24;
        return false;
    L24:
        if (this.f557060f == r101.f557060f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f557055a.hashCode() * 31) + this.f557056b.hashCode()) * 31) + this.f557057c.hashCode()) * 31) + this.f557058d.hashCode()) * 31) + this.f557059e.hashCode()) * 31;
        if (this.f557060f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SaasBtmPageInfo(btmShowId=" + this.f557055a + ", pageBtm=" + this.f557056b + ", pageId=" + this.f557057c + ", instanceId=" + this.f557058d + ", lastBtmShowId=" + this.f557059e + ", jumpWithToken=" + this.f557060f + ')';
    }

    public b() {
        this("", "", "", "", "", false);
    }

    public b(String r100, String r101, String r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "btmShowId");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        Intrinsics.checkNotNullParameter(r102, "pageId");
        Intrinsics.checkNotNullParameter(r103, "instanceId");
        Intrinsics.checkNotNullParameter(r104, "lastBtmShowId");
        this.f557055a = r100;
        this.f557056b = r101;
        this.f557057c = r102;
        this.f557058d = r103;
        this.f557059e = r104;
        this.f557060f = r105;
    }
}
