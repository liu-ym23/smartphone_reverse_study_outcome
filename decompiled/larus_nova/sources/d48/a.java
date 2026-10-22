package d48;

import java.io.BufferedReader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f466825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f466827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f466828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedReader f466830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Throwable f466831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f466832h;

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
        if (Intrinsics.areEqual(this.f466825a, r101.f466825a) == true) goto L12;
        return false;
    L12:
        if (this.f466826b == r101.f466826b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f466827c, r101.f466827c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466828d, r101.f466828d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f466829e, r101.f466829e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466830f, r101.f466830f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f466831g, r101.f466831g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f466832h, r101.f466832h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f466825a.hashCode() * 31) + this.f466826b) * 31;
        Map<String, String> r101 = this.f466827c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f466828d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f466829e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        BufferedReader r111 = this.f466830f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Throwable r114 = this.f466831g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f466832h;
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
        return "FlowAccountSaasNetResult(url=" + this.f466825a + ", status=" + this.f466826b + ", headers=" + this.f466827c + ", body=" + this.f466828d + ", message=" + this.f466829e + ", stream=" + this.f466830f + ", exception=" + this.f466831g + ", originRequestUrl=" + this.f466832h + ')';
    }

    public final boolean a() {
        int r100 = this.f466826b;
        if (200 <= r100) goto L5;
        return false;
    L5:
        if (r100 >= 300) goto L9;
        return true;
    L9:
        return false;
    }

    public a(String r100, int r101, Map r102, String r103, String r104, Throwable r105, String r106, int r110) {
        if ((r110 & 64) == 0) goto L6;
        r105 = null;
    L6:
        if ((r110 & 128) == 0) goto L8;
        r106 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f466825a = r100;
        this.f466826b = r101;
        this.f466827c = r102;
        this.f466828d = r103;
        this.f466829e = r104;
        this.f466830f = null;
        this.f466831g = r105;
        this.f466832h = r106;
    }
}
