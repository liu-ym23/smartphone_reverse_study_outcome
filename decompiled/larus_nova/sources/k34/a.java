package k34;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f501717d;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501714a, r101.f501714a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501715b, r101.f501715b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f501716c, r101.f501716c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501717d, r101.f501717d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f501714a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f501715b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f501716c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f501717d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AuthContext(hostEnterFrom=" + this.f501714a + ", enterFrom=" + this.f501715b + ", videoId=" + this.f501716c + ", reqId=" + this.f501717d + ')';
    }

    public a(String r100, String r101, String r102, String r103) {
        this.f501714a = r100;
        this.f501715b = r101;
        this.f501716c = r102;
        this.f501717d = r103;
    }
}
