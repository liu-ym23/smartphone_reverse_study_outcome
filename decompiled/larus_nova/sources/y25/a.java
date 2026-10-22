package y25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f565715c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f565713a, r101.f565713a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565714b, r101.f565714b) == true) goto L15;
        return false;
    L15:
        if (this.f565715c == r101.f565715c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565713a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f565714b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f565715c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CacheResult(source=" + this.f565713a + ", doc_token=" + this.f565714b + ", isHitCache=" + this.f565715c + ')';
    }

    public a(String r100, String r101, boolean r102) {
        this.f565713a = r100;
        this.f565714b = r101;
        this.f565715c = r102;
    }
}
