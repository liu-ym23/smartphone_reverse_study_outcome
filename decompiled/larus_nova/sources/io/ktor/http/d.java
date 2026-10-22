package io.ktor.http;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f491843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CookieEncoding f491844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f491845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hsc.a f491846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f491847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f491848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f491849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f491850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f491851j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f491842a, r101.f491842a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f491843b, r101.f491843b) == true) goto L15;
        return false;
    L15:
        if (this.f491844c == r101.f491844c) goto L18;
        return false;
    L18:
        if (this.f491845d == r101.f491845d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f491846e, r101.f491846e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f491847f, r101.f491847f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f491848g, r101.f491848g) == true) goto L30;
        return false;
    L30:
        if (this.f491849h == r101.f491849h) goto L33;
        return false;
    L33:
        if (this.f491850i == r101.f491850i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f491851j, r101.f491851j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r100 = ((((((this.f491842a.hashCode() * 31) + this.f491843b.hashCode()) * 31) + this.f491844c.hashCode()) * 31) + this.f491845d) * 31;
        hsc.a r101 = this.f491846e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f491847f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f491848g;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.f491849h;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f491850i;
        if (r114 == true) goto L22;
        r111 = r114;
    L22:
        return ((r113 + r111) * 31) + this.f491851j.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Cookie(name=" + this.f491842a + ", value=" + this.f491843b + ", encoding=" + this.f491844c + ", maxAge=" + this.f491845d + ", expires=" + this.f491846e + ", domain=" + this.f491847f + ", path=" + this.f491848g + ", secure=" + this.f491849h + ", httpOnly=" + this.f491850i + ", extensions=" + this.f491851j + ')';
    }

    public static d a(d r110, String r111, String r112, int r113) {
        Map<String, String> r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f491842a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f491843b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        CookieEncoding r103 = r110.f491844c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r104 = r110.f491845d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        hsc.a r105 = r110.f491846e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r114 = r110.f491847f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        String r115 = r110.f491848g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        boolean r116 = r110.f491849h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        boolean r117 = r110.f491850i;
    L39:
        if ((r113 & 512) == 0) goto L41;
        r100 = r110.f491851j;
    L41:
        Map<String, String> r118 = r100;
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "encoding");
        Intrinsics.checkNotNullParameter(r118, "extensions");
        return new d(r101, r102, r103, r104, r105, r114, r115, r116, r117, r118);
    L37:
        r117 = false;
        goto L39
    L33:
        r116 = false;
        goto L35
    L29:
        r115 = r112;
        goto L31
    L25:
        r114 = r111;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d(String r100, String r101, CookieEncoding r102, int r103, hsc.a r104, String r105, String r106, boolean r107, boolean r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "encoding");
        Intrinsics.checkNotNullParameter(r111, "extensions");
        this.f491842a = r100;
        this.f491843b = r101;
        this.f491844c = r102;
        this.f491845d = r103;
        this.f491846e = r104;
        this.f491847f = r105;
        this.f491848g = r106;
        this.f491849h = r107;
        this.f491850i = r110;
        this.f491851j = r111;
    }
}
