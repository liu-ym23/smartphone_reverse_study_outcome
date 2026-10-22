package g0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f479520h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f479513a, r101.f479513a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479514b, r101.f479514b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479515c, r101.f479515c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479516d, r101.f479516d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479517e, r101.f479517e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479518f, r101.f479518f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f479519g, r101.f479519g) == true) goto L30;
        return false;
    L30:
        if (this.f479520h == r101.f479520h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f479513a.hashCode() * 31) + this.f479514b.hashCode()) * 31) + this.f479515c.hashCode()) * 31) + this.f479516d.hashCode()) * 31;
        String r101 = this.f479517e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f479518f;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((r104 + r102) * 31) + this.f479519g.hashCode()) * 31;
        long r107 = this.f479520h;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobLeaveTabParamsKmp(enterMethod=" + this.f479513a + ", leaveMethod=" + this.f479514b + ", recommendFrom=" + this.f479515c + ", tabType=" + this.f479516d + ", tabName=" + this.f479517e + ", tabId=" + this.f479518f + ", currentPage=" + this.f479519g + ", duration=" + this.f479520h + ')';
    }

    public j(String r100, String r101, String r102, String r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r101, "leaveMethod");
        Intrinsics.checkNotNullParameter("creation_feed", "recommendFrom");
        Intrinsics.checkNotNullParameter(r102, "tabType");
        Intrinsics.checkNotNullParameter(r105, "currentPage");
        this.f479513a = r100;
        this.f479514b = r101;
        this.f479515c = "creation_feed";
        this.f479516d = r102;
        this.f479517e = r103;
        this.f479518f = r104;
        this.f479519g = r105;
        this.f479520h = r106;
    }
}
