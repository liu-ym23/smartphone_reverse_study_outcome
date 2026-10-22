package jr9;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Integer> f500147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f500149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f500150h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f500143a == r101.f500143a) goto L12;
        return false;
    L12:
        if (this.f500144b == r101.f500144b) goto L15;
        return false;
    L15:
        if (this.f500145c == r101.f500145c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500146d, r101.f500146d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500147e, r101.f500147e) == true) goto L24;
        return false;
    L24:
        if (this.f500148f == r101.f500148f) goto L27;
        return false;
    L27:
        if (this.f500149g == r101.f500149g) goto L30;
        return false;
    L30:
        if (this.f500150h == r101.f500150h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f500143a * 31) + this.f500144b) * 31) + this.f500145c) * 31) + this.f500146d.hashCode()) * 31) + this.f500147e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f500148f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f500149g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f500150h == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareItemUIConfig(iconId=" + this.f500143a + ", rectangleIconId=" + this.f500144b + ", textId=" + this.f500145c + ", textStr=" + this.f500146d + ", shareTypeTextMap=" + this.f500147e + ", enableStatus=" + this.f500148f + ", autoDismissDialog=" + this.f500149g + ", isLoadingState=" + this.f500150h + ')';
    }

    public static b a(b r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r100 = r110.f500143a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r101 = r110.f500144b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r102 = r110.f500145c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r103 = r110.f500146d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Map<String, Integer> r104 = r110.f500147e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        r111 = r110.f500148f;
    L25:
        boolean r105 = r111;
        if ((r113 & 64) == 0) goto L28;
        boolean r106 = r110.f500149g;
    L30:
        if ((r113 & 128) == 0) goto L32;
        r112 = r110.f500150h;
    L32:
        Intrinsics.checkNotNullParameter(r103, "textStr");
        Intrinsics.checkNotNullParameter(r104, "shareTypeTextMap");
        return new b(r100, r101, r102, r103, r104, r105, r106, r112);
    L28:
        r106 = false;
        goto L30
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public /* synthetic */ b(int r110, int r111, int r112, Map r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r114 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r114 & 8) == 0) goto L13;
        String r102 = "";
    L14:
        String r103 = r102;
        if ((r114 & 16) == 0) goto L17;
        Map r104 = new HashMap();
    L19:
        if ((r114 & 32) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r114 & 64) == 0) goto L25;
        boolean r106 = true;
    L26:
        this(r110, r100, r101, r103, r104, r105, r106, false);
        return;
    L25:
        r106 = false;
        goto L26
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public b(int r100, int r101, int r102, String r103, Map<String, Integer> r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r103, "textStr");
        Intrinsics.checkNotNullParameter(r104, "shareTypeTextMap");
        this.f500143a = r100;
        this.f500144b = r101;
        this.f500145c = r102;
        this.f500146d = r103;
        this.f500147e = r104;
        this.f500148f = r105;
        this.f500149g = r106;
        this.f500150h = r107;
    }
}
