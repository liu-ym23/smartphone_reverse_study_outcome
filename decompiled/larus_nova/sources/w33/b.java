package w33;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<n33.f> f558126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<d> f558127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<Map<String, Object>> f558128c;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f558126a, r101.f558126a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f558127b, r101.f558127b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f558128c, r101.f558128c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        e<n33.f> r100 = this.f558126a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e<d> r104 = this.f558127b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e<Map<String, Object>> r107 = this.f558128c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ArchState(querySuccessResponse=" + this.f558126a + ", flowTimestamp=" + this.f558127b + ", queryApiMetrics=" + this.f558128c + ")";
    }

    public b(Object r100) {
        f r101 = new f(null);
        f r102 = new f(null);
        f r103 = new f(null);
        Intrinsics.checkNotNullParameter(r101, "querySuccessResponse");
        Intrinsics.checkNotNullParameter(r102, "flowTimestamp");
        Intrinsics.checkNotNullParameter(r103, "queryApiMetrics");
        this.f558126a = r101;
        this.f558127b = r102;
        this.f558128c = r103;
    }
}
