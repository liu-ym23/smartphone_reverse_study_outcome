package ti4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f546063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f546064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f546065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f546066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f546067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f546068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f546069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f546070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f546071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f546072j;

    public c0() {
        this(null, null, null, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f546063a, r101.f546063a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546064b, r101.f546064b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546065c, r101.f546065c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546066d, r101.f546066d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f546067e, r101.f546067e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f546068f, r101.f546068f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f546069g, r101.f546069g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f546070h, r101.f546070h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f546071i, r101.f546071i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f546072j, r101.f546072j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f546063a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f546064b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f546065c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f546066d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f546067e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f546068f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f546069g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f546070h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f546071i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f546072j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ListConfigUpdate(showTitle=" + this.f546063a + ", showTab=" + this.f546064b + ", useCorner=" + this.f546065c + ", itemSpacing=" + this.f546066d + ", recyclerViewPadding=" + this.f546067e + ", recyclerMoveTop=" + this.f546068f + ", showHeader=" + this.f546069g + ", refreshItemCount=" + this.f546070h + ", resetSelectedIndex=" + this.f546071i + ", isSelectedTabSticky=" + this.f546072j + ')';
    }

    public c0(Boolean r100, Boolean r101, Boolean r102, Integer r103, Integer r104, Boolean r105, Boolean r106, Integer r110, Integer r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r112 & 256) == 0) goto L29;
        r111 = null;
    L29:
        this.f546063a = r100;
        this.f546064b = r101;
        this.f546065c = r102;
        this.f546066d = r103;
        this.f546067e = r104;
        this.f546068f = r105;
        this.f546069g = r106;
        this.f546070h = r110;
        this.f546071i = r111;
        this.f546072j = null;
    }
}
