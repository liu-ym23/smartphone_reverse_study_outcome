package com.bytedance.commerce.base.richtext;

import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f202908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f202909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f202910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f202911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f202912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f202913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f202914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f202915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f202916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f202917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f202918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f202919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f202920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f202921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f202922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f202923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f202924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f202925r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f202926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f202927t;

    /* JADX INFO: renamed from: com.bytedance.commerce.base.richtext.a$a, reason: collision with other inner class name */
    public static final class C2948a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L46;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f202908a, r101.f202908a) == true) goto L8;
        return false;
    L8:
        if (this.f202909b == r101.f202909b) goto L10;
        return false;
    L10:
        if (this.f202910c == r101.f202910c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f202911d, r101.f202911d) == 0) goto L14;
        return false;
    L14:
        if (this.f202912e == r101.f202912e) goto L16;
        return false;
    L16:
        if (this.f202913f == r101.f202913f) goto L18;
        return false;
    L18:
        if (Float.compare(this.f202914g, r101.f202914g) == 0) goto L20;
        return false;
    L20:
        if (this.f202915h == r101.f202915h) goto L22;
        return false;
    L22:
        if (this.f202916i == r101.f202916i) goto L24;
        return false;
    L24:
        if (this.f202917j == r101.f202917j) goto L26;
        return false;
    L26:
        if (this.f202918k == r101.f202918k) goto L28;
        return false;
    L28:
        if (this.f202919l == r101.f202919l) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f202920m, r101.f202920m) == true) goto L32;
        return false;
    L32:
        if (Float.compare(this.f202921n, r101.f202921n) == 0) goto L34;
        return false;
    L34:
        if (this.f202922o == r101.f202922o) goto L36;
        return false;
    L36:
        if (this.f202923p == r101.f202923p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f202924q, r101.f202924q) == true) goto L40;
        return false;
    L40:
        if (Float.compare(this.f202925r, r101.f202925r) == 0) goto L42;
        return false;
    L42:
        if (this.f202926s == r101.f202926s) goto L44;
        return false;
    L44:
        if (this.f202927t == r101.f202927t) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        TextView r100 = this.f202908a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f202909b;
        int r104 = ((((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f202910c) * 31) + Float.floatToIntBits(this.f202911d)) * 31;
        boolean r105 = this.f202912e;
        ?? r106 = 1;
        ?? r107 = r105;
        if (r105 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f202913f;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (((r108 + r110) * 31) + Float.floatToIntBits(this.f202914g)) * 31;
        boolean r112 = this.f202915h;
        ?? r113 = r112;
        if (r112 == false) goto L15;
        r113 = 1;
    L15:
        int r114 = (((r111 + r113) * 31) + this.f202916i) * 31;
        boolean r115 = this.f202917j;
        if (r115 == true) goto L19;
        r106 = r115;
    L19:
        int r116 = (((((r114 + r106) * 31) + this.f202918k) * 31) + this.f202919l) * 31;
        String r117 = this.f202920m;
        if (r117 == null) goto L22;
        int r118 = r117.hashCode();
    L23:
        int r119 = (((((((r116 + r118) * 31) + Float.floatToIntBits(this.f202921n)) * 31) + this.f202922o) * 31) + this.f202923p) * 31;
        String r120 = this.f202924q;
        if (r120 == null) goto L27;
        r101 = r120.hashCode();
    L27:
        return ((((((r119 + r101) * 31) + Float.floatToIntBits(this.f202925r)) * 31) + this.f202926s) * 31) + this.f202927t;
    L22:
        r118 = 0;
        goto L23
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PriceBuilder(textView=" + this.f202908a + ", priceInFen=" + this.f202909b + ", priceTextColor=" + this.f202910c + ", priceDecimalTextSizeRatio=" + this.f202911d + ", priceBold=" + this.f202912e + ", hideYuanSymbol=" + this.f202913f + ", yuanSymbolTextSizeRatio=" + this.f202914g + ", yuanSymbolBold=" + this.f202915h + ", yuanSymbolMarginRight=" + this.f202916i + ", showStrikeThrough=" + this.f202917j + ", strikeThroughColor=" + this.f202918k + ", strikeThroughThickness=" + this.f202919l + ", prefixText=" + this.f202920m + ", prefixTextSizeRatio=" + this.f202921n + ", prefixTextColor=" + this.f202922o + ", prefixMarginRight=" + this.f202923p + ", suffixText=" + this.f202924q + ", suffixTextSizeRatio=" + this.f202925r + ", suffixTextMarginLeft=" + this.f202926s + ", suffixTextColor=" + this.f202927t + ")";
    }

    public a(TextView r100) {
        int r101 = vf4.a.a(r100.getContext(), 2.0f);
        int r102 = vf4.a.a(r100.getContext(), 1.0f);
        int r103 = vf4.a.a(r100.getContext(), 4.0f);
        int r104 = vf4.a.a(r100.getContext(), 2.0f);
        this.f202908a = r100;
        this.f202909b = 0;
        this.f202910c = CJBadgeTextView.BADGE_COLOR;
        this.f202911d = 0.6666667f;
        this.f202912e = false;
        this.f202913f = false;
        this.f202914g = 0.6666667f;
        this.f202915h = false;
        this.f202916i = r101;
        this.f202917j = false;
        this.f202918k = 0;
        this.f202919l = r102;
        this.f202920m = "";
        this.f202921n = 1.0f;
        this.f202922o = 0;
        this.f202923p = r103;
        this.f202924q = "";
        this.f202925r = 1.0f;
        this.f202926s = r104;
        this.f202927t = 0;
    }
}
