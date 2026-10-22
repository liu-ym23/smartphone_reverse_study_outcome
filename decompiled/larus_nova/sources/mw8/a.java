package mw8;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f515979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f515982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f515983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f515985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, Object, Unit> f515986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f515987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f515988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f515989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f515990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f515991m;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f515979a == r101.f515979a) goto L12;
        return false;
    L12:
        if (this.f515980b == r101.f515980b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515981c, r101.f515981c) == true) goto L18;
        return false;
    L18:
        if (this.f515982d == r101.f515982d) goto L21;
        return false;
    L21:
        if (this.f515983e == r101.f515983e) goto L24;
        return false;
    L24:
        if (this.f515984f == r101.f515984f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f515985g, r101.f515985g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515986h, r101.f515986h) == true) goto L33;
        return false;
    L33:
        if (this.f515987i == r101.f515987i) goto L36;
        return false;
    L36:
        if (this.f515988j == r101.f515988j) goto L39;
        return false;
    L39:
        if (this.f515989k == r101.f515989k) goto L42;
        return false;
    L42:
        if (this.f515990l == r101.f515990l) goto L45;
        return false;
    L45:
        if (this.f515991m == r101.f515991m) goto L47;
        return false;
    L47:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f515979a * 31;
        boolean r101 = this.f515980b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f515981c;
        int r106 = 0;
        if (r105 != null) goto L8;
        int r107 = 0;
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f515982d;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f515983e;
        ?? r113 = r112;
        if (r112 == false) goto L15;
        r113 = 1;
    L15:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.f515984f;
        ?? r116 = r115;
        if (r115 == false) goto L18;
        r116 = 1;
    L18:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.f515985g;
        if (r118 != null) goto L21;
        int r119 = 0;
    L22:
        int r120 = (r117 + r119) * 31;
        Function2<String, Object, Unit> r121 = this.f515986h;
        if (r121 == null) goto L26;
        r106 = r121.hashCode();
    L26:
        int r122 = (r120 + r106) * 31;
        boolean r123 = this.f515987i;
        ?? r124 = r123;
        if (r123 == false) goto L29;
        r124 = 1;
    L29:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f515988j;
        ?? r127 = r126;
        if (r126 == false) goto L32;
        r127 = 1;
    L32:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.f515989k;
        ?? r130 = r129;
        if (r129 == false) goto L35;
        r130 = 1;
    L35:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.f515990l;
        if (r132 == true) goto L40;
        r102 = r132;
    L40:
        return ((r131 + r102) * 31) + this.f515991m;
    L21:
        r119 = r118.hashCode();
        goto L22
    L8:
        r107 = r105.hashCode();
        goto L9
    }

    public final String toString() {
        return "LatexGlobalConfig(markdownLatexPatternStrategy=" + this.f515979a + ", enableMarkdownLatexOpt=" + this.f515980b + ", customizedSingleDollarLatexPattern=" + this.f515981c + ", disableLatexSplit=" + this.f515982d + ", enableLatexSplitOptimize=" + this.f515983e + ", enableLatexFallback=" + this.f515984f + ", unSupportLatexCommandList=" + this.f515985g + ", latexFallbackAbility=" + this.f515986h + ", enableBlockLatex=" + this.f515987i + ", isDisableLatex=" + this.f515988j + ", enableLatexNewCommand=" + this.f515989k + ", enableUseLatexBitmapCache=" + this.f515990l + ", latexBitmapCacheSize=" + this.f515991m + ')';
    }

    public /* synthetic */ a(int r110) {
        this(0, false, null, false, false, false, null, null, true, false, false, false, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, boolean r101, String r102, boolean r103, boolean r104, boolean r105, List<String> r106, Function2<? super String, Object, Unit> r107, boolean r108, boolean r110, boolean r111, boolean r112, int r113) {
        this.f515979a = r100;
        this.f515980b = r101;
        this.f515981c = r102;
        this.f515982d = r103;
        this.f515983e = r104;
        this.f515984f = r105;
        this.f515985g = r106;
        this.f515986h = r107;
        this.f515987i = r108;
        this.f515988j = r110;
        this.f515989k = r111;
        this.f515990l = r112;
        this.f515991m = r113;
    }
}
