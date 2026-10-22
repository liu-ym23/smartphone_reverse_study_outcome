package xw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f565251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final lp6.a f565253e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f565249a, r101.f565249a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565250b, r101.f565250b) == true) goto L15;
        return false;
    L15:
        if (this.f565251c == r101.f565251c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565252d, r101.f565252d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565253e, r101.f565253e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565249a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f565250b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f565251c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        String r109 = this.f565252d;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return ((r108 + r101) * 31) + this.f565253e.hashCode();
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoApiBizResponse(statusCode=" + this.f565249a + ", statusMsg=" + this.f565250b + ", isDowngrade=" + this.f565251c + ", logId=" + this.f565252d + ", ditoResponse=" + this.f565253e + ')';
    }

    public /* synthetic */ a(String r100, String r101, String r102, lp6.a r110) {
        this(r100, r101, false, r102, r110);
    }

    public a(String r100, String r101, boolean r102, String r103, lp6.a r104) {
        Intrinsics.checkNotNullParameter(r104, "ditoResponse");
        this.f565249a = r100;
        this.f565250b = r101;
        this.f565251c = r102;
        this.f565252d = r103;
        this.f565253e = r104;
    }
}
