package fh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f477126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f477127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f477130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f477131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f477132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f477133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f477134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f477135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f477136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final lw8.d f477137l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f477126a == r101.f477126a) goto L12;
        return false;
    L12:
        if (this.f477127b == r101.f477127b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f477128c, r101.f477128c) == true) goto L18;
        return false;
    L18:
        if (this.f477129d == r101.f477129d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f477130e, r101.f477130e) == true) goto L24;
        return false;
    L24:
        if (this.f477131f == r101.f477131f) goto L27;
        return false;
    L27:
        if (this.f477132g == r101.f477132g) goto L30;
        return false;
    L30:
        if (this.f477133h == r101.f477133h) goto L33;
        return false;
    L33:
        if (this.f477134i == r101.f477134i) goto L36;
        return false;
    L36:
        if (this.f477135j == r101.f477135j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f477136k, r101.f477136k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f477137l, r101.f477137l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f477126a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f477127b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f477128c.hashCode()) * 31;
        if (this.f477129d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f477130e.hashCode()) * 31;
        if (this.f477131f == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f477132g == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f477133h == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f477134i == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f477135j == true) goto L34;
        r100 = 1237;
    L34:
        int r115 = (r114 + r100) * 31;
        Boolean r116 = this.f477136k;
        int r117 = 0;
        if (r116 != null) goto L37;
        int r118 = 0;
    L38:
        int r119 = (r115 + r118) * 31;
        lw8.d r120 = this.f477137l;
        if (r120 == null) goto L43;
        r117 = r120.hashCode();
    L43:
        return r119 + r117;
    L37:
        r118 = r116.hashCode();
        goto L38
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownRenderConfig(failOrInterrupt=" + this.f477126a + ", isStreaming=" + this.f477127b + ", viewAlphaTag=" + this.f477128c + ", isDeepThinkArea=" + this.f477129d + ", forceRefreshId=" + this.f477130e + ", useSubscribedColor=" + this.f477131f + ", useCodeStyle=" + this.f477132g + ", isDeepResearchArea=" + this.f477133h + ", enableCodeBlockStroke=" + this.f477134i + ", enableCodeBlockHeaderBackground=" + this.f477135j + ", enableTableHeader=" + this.f477136k + ", customMarkdownInfo=" + this.f477137l + ')';
    }

    public l(boolean r100, boolean r101, String r102, boolean r103, String r104, boolean r105, boolean r110, boolean r111, boolean r112, Boolean r113, lw8.d r114, int r115) {
        if ((r115 & 16) == 0) goto L6;
        r104 = r102;
    L6:
        if ((r115 & 32) == 0) goto L9;
        r105 = false;
    L9:
        if ((r115 & 128) == 0) goto L12;
        r110 = false;
    L12:
        if ((r115 & 256) == 0) goto L15;
        r111 = false;
    L15:
        if ((r115 & 512) == 0) goto L18;
        r112 = false;
    L18:
        if ((r115 & 1024) == 0) goto L21;
        r113 = null;
    L21:
        if ((r115 & 2048) == 0) goto L23;
        r114 = null;
    L23:
        Intrinsics.checkNotNullParameter(r102, "viewAlphaTag");
        Intrinsics.checkNotNullParameter(r104, "forceRefreshId");
        this.f477126a = r100;
        this.f477127b = r101;
        this.f477128c = r102;
        this.f477129d = r103;
        this.f477130e = r104;
        this.f477131f = r105;
        this.f477132g = false;
        this.f477133h = r110;
        this.f477134i = r111;
        this.f477135j = r112;
        this.f477136k = r113;
        this.f477137l = r114;
    }
}
