package cy6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f465796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f465797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f465798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f465799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f465800e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f465796a, r101.f465796a) == true) goto L12;
        return false;
    L12:
        if (this.f465797b == r101.f465797b) goto L15;
        return false;
    L15:
        if (this.f465798c == r101.f465798c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465799d, r101.f465799d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465800e, r101.f465800e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f465796a.hashCode() * 31;
        if (this.f465797b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f465798c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f465799d;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        Object r109 = this.f465800e;
        if (r109 == null) goto L15;
        r106 = r109.hashCode();
    L15:
        return r108 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LifeFeedPageResult(awemeList=" + this.f465796a + ", hasMore=" + this.f465797b + ", nextCursor=" + this.f465798c + ", removeAwemeId=" + this.f465799d + ", rawResponse=" + this.f465800e + ')';
    }

    public d(List<b> r100, boolean r101, long r102, String r103, Object r104) {
        Intrinsics.checkNotNullParameter(r100, "awemeList");
        this.f465796a = r100;
        this.f465797b = r101;
        this.f465798c = r102;
        this.f465799d = r103;
        this.f465800e = r104;
    }
}
