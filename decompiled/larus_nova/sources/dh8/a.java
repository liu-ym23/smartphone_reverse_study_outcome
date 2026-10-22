package dh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f468624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f468625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f468626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f468627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f468628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f468629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f468630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f468631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f468632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f468633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f468634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f468635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f468636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f468637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f468638o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f468624a == r101.f468624a) goto L12;
        return false;
    L12:
        if (this.f468625b == r101.f468625b) goto L15;
        return false;
    L15:
        if (this.f468626c == r101.f468626c) goto L18;
        return false;
    L18:
        if (this.f468627d == r101.f468627d) goto L21;
        return false;
    L21:
        if (this.f468628e == r101.f468628e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468629f, r101.f468629f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f468630g, r101.f468630g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f468631h, r101.f468631h) == true) goto L33;
        return false;
    L33:
        if (this.f468632i == r101.f468632i) goto L36;
        return false;
    L36:
        if (this.f468633j == r101.f468633j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f468634k, r101.f468634k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f468635l, r101.f468635l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f468636m, r101.f468636m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f468637n, r101.f468637n) == true) goto L51;
        return false;
    L51:
        if (this.f468638o == r101.f468638o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f468624a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f468625b) * 31) + this.f468626c) * 31;
        if (this.f468627d == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f468628e;
        int r106 = (((((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f468629f.hashCode()) * 31) + this.f468630g.hashCode()) * 31) + this.f468631h.hashCode()) * 31;
        if (this.f468632i == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f468633j == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((r108 + r109) * 31) + this.f468634k.hashCode()) * 31;
        String r111 = this.f468635l;
        int r112 = 0;
        if (r111 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r110 + r113) * 31;
        Integer r115 = this.f468636m;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f468637n;
        if (r118 == null) goto L30;
        r112 = r118.hashCode();
    L30:
        int r119 = (r117 + r112) * 31;
        if (this.f468638o == true) goto L35;
        r100 = 1237;
    L35:
        return r119 + r100;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r111.hashCode();
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LongMessageCollapseConfig(enabled=" + this.f468624a + ", collapsedHeight=" + this.f468625b + ", triggerHeight=" + this.f468626c + ", expanded=" + this.f468627d + ", historyGeneration=" + this.f468628e + ", messageKey=" + this.f468629f + ", stateScope=" + this.f468630g + ", direction=" + this.f468631h + ", isSelectionMode=" + this.f468632i + ", initialCollapsed=" + this.f468633j + ", parentMessageKey=" + this.f468634k + ", selectionLookupMessageId=" + this.f468635l + ", selectedSubMessageIndex=" + this.f468636m + ", selectedSubMessageId=" + this.f468637n + ", expandedAfterSubMessageSwitch=" + this.f468638o + ')';
    }

    public static a a(a r210, int r211, int r212, boolean r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = r210.f468624a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r210.f468625b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r210.f468626c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r103 = r210.f468627d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r104 = r210.f468628e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r110 = r210.f468629f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r111 = r210.f468630g;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r112 = r210.f468631h;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r113 = r210.f468632i;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r114 = r210.f468633j;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r105 = r210.f468634k;
    L47:
        if ((r214 & 2048) == 0) goto L49;
        String r115 = r210.f468635l;
    L51:
        if ((r214 & 4096) == 0) goto L53;
        Integer r116 = r210.f468636m;
    L55:
        if ((r214 & 8192) == 0) goto L57;
        String r117 = r210.f468637n;
    L59:
        if ((r214 & 16384) == 0) goto L61;
        boolean r215 = r210.f468638o;
    L62:
        Intrinsics.checkNotNullParameter(r110, "messageKey");
        Intrinsics.checkNotNullParameter(r111, "stateScope");
        Intrinsics.checkNotNullParameter(r112, "direction");
        Intrinsics.checkNotNullParameter(r105, "parentMessageKey");
        return new a(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r115, r116, r117, r215);
    L61:
        r215 = false;
        goto L62
    L57:
        r117 = null;
        goto L59
    L53:
        r116 = null;
        goto L55
    L49:
        r115 = null;
        goto L51
    L45:
        r105 = null;
        goto L47
    L41:
        r114 = false;
        goto L43
    L37:
        r113 = false;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r104 = 0;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public a(boolean r100, int r101, int r110, boolean r111, long r112, String r113, String r114, String r115, boolean r116, boolean r117, String r118, String r210, Integer r211, String r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r113, "messageKey");
        Intrinsics.checkNotNullParameter(r114, "stateScope");
        Intrinsics.checkNotNullParameter(r115, "direction");
        Intrinsics.checkNotNullParameter(r118, "parentMessageKey");
        this.f468624a = r100;
        this.f468625b = r101;
        this.f468626c = r110;
        this.f468627d = r111;
        this.f468628e = r112;
        this.f468629f = r113;
        this.f468630g = r114;
        this.f468631h = r115;
        this.f468632i = r116;
        this.f468633j = r117;
        this.f468634k = r118;
        this.f468635l = r210;
        this.f468636m = r211;
        this.f468637n = r212;
        this.f468638o = r213;
    }
}
