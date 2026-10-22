package ey8;

import java.io.BufferedReader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f474815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedReader f474818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Throwable f474819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474820h;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474813a, r101.f474813a) == true) goto L12;
        return false;
    L12:
        if (this.f474814b == r101.f474814b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474815c, r101.f474815c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474816d, r101.f474816d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474817e, r101.f474817e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474818f, r101.f474818f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474819g, r101.f474819g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474820h, r101.f474820h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f474813a.hashCode() * 31) + this.f474814b) * 31;
        Map<String, String> r101 = this.f474815c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f474816d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f474817e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        BufferedReader r111 = this.f474818f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Throwable r114 = this.f474819g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f474820h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetResult(url=" + this.f474813a + ", status=" + this.f474814b + ", headers=" + this.f474815c + ", body=" + this.f474816d + ", message=" + this.f474817e + ", stream=" + this.f474818f + ", exception=" + this.f474819g + ", originRequestUrl=" + this.f474820h + ')';
    }

    public a(String r100, int r101, Map r102, String r103, String r104, BufferedReader r105, Throwable r106, String r110, int r111) {
        if ((r111 & 32) == 0) goto L6;
        r105 = null;
    L6:
        if ((r111 & 64) == 0) goto L9;
        r106 = null;
    L9:
        if ((r111 & 128) == 0) goto L11;
        r110 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f474813a = r100;
        this.f474814b = r101;
        this.f474815c = r102;
        this.f474816d = r103;
        this.f474817e = r104;
        this.f474818f = r105;
        this.f474819g = r106;
        this.f474820h = r110;
    }
}
