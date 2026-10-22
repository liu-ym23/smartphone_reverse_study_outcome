package lw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f511047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f511048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f511049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f511050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f511051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f511052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f511053h;

    public a() {
        this(true, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f511046a == r101.f511046a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511047b, r101.f511047b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511048c, r101.f511048c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511049d, r101.f511049d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f511050e, r101.f511050e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f511051f, r101.f511051f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f511052g, r101.f511052g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f511053h, r101.f511053h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean r100 = this.f511046a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.f511047b;
        int r104 = 0;
        if (r103 != null) goto L8;
        int r105 = 0;
    L9:
        int r106 = (r102 + r105) * 31;
        Integer r107 = this.f511048c;
        if (r107 != null) goto L12;
        int r108 = 0;
    L13:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f511049d;
        if (r110 != null) goto L16;
        int r111 = 0;
    L17:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f511050e;
        if (r113 != null) goto L20;
        int r114 = 0;
    L21:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f511051f;
        if (r116 != null) goto L24;
        int r117 = 0;
    L25:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f511052g;
        if (r119 != null) goto L28;
        int r120 = 0;
    L29:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f511053h;
        if (r122 == null) goto L34;
        r104 = r122.hashCode();
    L34:
        return r121 + r104;
    L28:
        r120 = r119.hashCode();
        goto L29
    L24:
        r117 = r116.hashCode();
        goto L25
    L20:
        r114 = r113.hashCode();
        goto L21
    L16:
        r111 = r110.hashCode();
        goto L17
    L12:
        r108 = r107.hashCode();
        goto L13
    L8:
        r105 = r103.hashCode();
        goto L9
    }

    public final String toString() {
        return "BlockQuoteConfig(enableNewQuoteStyle=" + this.f511046a + ", blockQuoteWidth=" + this.f511047b + ", blockQuoteColor=" + this.f511048c + ", lineCornerRadius=" + this.f511049d + ", blockMargin=" + this.f511050e + ", textColorInQuote=" + this.f511051f + ", orderedListItemColorInQuote=" + this.f511052g + ", bulletListItemColorInQuote=" + this.f511053h + ')';
    }

    public a(boolean r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107) {
        this.f511046a = r100;
        this.f511047b = r101;
        this.f511048c = r102;
        this.f511049d = r103;
        this.f511050e = r104;
        this.f511051f = r105;
        this.f511052g = r106;
        this.f511053h = r107;
    }
}
