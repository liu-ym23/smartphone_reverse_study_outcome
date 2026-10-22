package r24;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f535758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f535760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f535761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f535762g;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f535756a, r101.f535756a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535757b, r101.f535757b) == true) goto L15;
        return false;
    L15:
        if (this.f535758c == r101.f535758c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535759d, r101.f535759d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535760e, r101.f535760e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535761f, r101.f535761f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f535762g, r101.f535762g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    public final int hashCode() {
        int r100 = ((this.f535756a.hashCode() * 31) + this.f535757b.hashCode()) * 31;
        boolean r101 = this.f535758c;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f535759d;
        int r105 = 0;
        if (r104 != null) goto L8;
        int r106 = 0;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f535760e;
        if (r108 != null) goto L12;
        int r109 = 0;
    L13:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f535761f;
        if (r111 != null) goto L16;
        int r112 = 0;
    L17:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f535762g;
        if (r114 == null) goto L22;
        r105 = r114.hashCode();
    L22:
        return r113 + r105;
    L16:
        r112 = r111.hashCode();
        goto L17
    L12:
        r109 = r108.hashCode();
        goto L13
    L8:
        r106 = r104.hashCode();
        goto L9
    }

    public final String toString() {
        return "DislikeModel(authorOpenId=" + this.f535756a + ", aid=" + this.f535757b + ", requireAutoLogin=" + this.f535758c + ", imprId=" + this.f535759d + ", anchorName=" + this.f535760e + ", poiType=" + this.f535761f + ", poiReportParams=" + this.f535762g + ')';
    }

    public b(String r100, String r101, String r102, Integer r103, Map r104, int r110) {
        if ((r110 & 8) == 0) goto L5;
        String r105 = "";
    L7:
        if ((r110 & 16) == 0) goto L10;
        r102 = "";
    L10:
        if ((r110 & 32) == 0) goto L13;
        r103 = null;
    L13:
        if ((r110 & 64) == 0) goto L15;
        r104 = null;
    L15:
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "aid");
        this.f535756a = r100;
        this.f535757b = r101;
        this.f535758c = false;
        this.f535759d = r105;
        this.f535760e = r102;
        this.f535761f = r103;
        this.f535762g = r104;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
