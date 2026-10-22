package rma;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.TextSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import qma.c;
import qma.d;
import qma.e;
import qma.f;
import qma.g;
import qma.h;
import qma.i;
import qma.j;
import qma.k;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f538614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qma.a.b f538615b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qma.a.b f538616c = null;

    public a() {
    }

    static {
        f538614a = new a();
        new qma.a.b(0.33f, 0.67f, 1.0f);
        f538615b = new qma.a.b(0.42f, 0.58f, 1.0f);
        f538616c = new qma.a.b(0.26f, 0.6f, 0.2f);
        new qma.a.C7361a(0.0f, 1);
        new qma.a.C7361a(0.4f, 1);
        new qma.a.C7361a(0.3f, 1);
    }

    public final k i() {
        g.b r100 = g.b.f533959a;
        TextSource r101 = TextSource.Current;
        Float r110 = Float.valueOf(0.0f);
        return new k("oui.dim_point.pending", 1500, r100, CollectionsKt.listOf(new c("pending_breath", 1500, CollectionsKt.listOf(new qma.b.C7362b[]{a("base_text", r101, CollectionsKt.emptyList()), g("gradient_overlay", r101, CollectionsKt.listOf(f(this, new Pair[]{TuplesKt.to(0L, r110), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(1500L, r110)})))}))), 2);
    }

    public final k d(boolean r210) {
        long r100 = Math.max(1250, 1450);
        TextSource r101 = TextSource.Current;
        Float r110 = Float.valueOf(0.03f);
        Float r111 = Float.valueOf(0.0f);
        Pair[] r112 = {TuplesKt.to(150L, r110), TuplesKt.to(1250L, r111)};
        Float r113 = Float.valueOf(-0.5f);
        Float r102 = Float.valueOf(1.0f);
        Pair[] r103 = {TuplesKt.to(0L, r113), TuplesKt.to(1250L, r102)};
        Direction r114 = Direction.LeftToRight;
        i[] r104 = {k(this, r112), e(this, r103, r114)};
        Float r105 = Float.valueOf(0.8f);
        List r106 = CollectionsKt.mutableListOf(new qma.b[]{a("generate_scan_base_text", r101, CollectionsKt.listOf(r104)), g("generate_scan_text", r101, CollectionsKt.listOf(new i[]{f(this, new Pair[]{TuplesKt.to(0L, r105), TuplesKt.to(750L, r105), TuplesKt.to(1450L, r111)}), k(this, new Pair[]{TuplesKt.to(150L, r110), TuplesKt.to(1400L, r111)}), e(this, new Pair[]{TuplesKt.to(0L, r113), TuplesKt.to(1250L, r102)}, r114)}))});
        if (r210 == false) goto L6;
        r106.add(h("enter_indicator", "enterScanIndicator", r114, 1250, -0.4f, 1.0f));
    L6:
        return new k("oui.dim_point.generate", r100, null, CollectionsKt.mutableListOf(new c[]{new c("generate_enter", r100, r106)}), 10);
    }

    public static i f(a r100, Pair[] r101) {
        qma.a.b r102 = f538615b;
        r100.getClass();
        return c(EffectProperty.Alpha, r102, (Pair[]) Arrays.copyOf(r101, r101.length));
    }

    public static i k(a r100, Pair[] r101) {
        qma.a.b r102 = f538615b;
        r100.getClass();
        return c(EffectProperty.Tracking, r102, (Pair[]) Arrays.copyOf(r101, r101.length));
    }

    public final k j(boolean r410, float r411) {
        long r110 = Math.max(Math.max(1250, 1450), Math.max(600, Math.max(600, 600)));
        TextSource r100 = TextSource.Old;
        Float r101 = Float.valueOf(0.0f);
        Float r102 = Float.valueOf(16.0f);
        Pair[] r111 = {TuplesKt.to(0L, r101), TuplesKt.to(600L, r102)};
        qma.a.b r103 = f538615b;
        EffectProperty r104 = EffectProperty.BlurRadius;
        Float r112 = Float.valueOf(3.0f);
        Pair[] r113 = {TuplesKt.to(0L, r101), TuplesKt.to(600L, r112)};
        EffectProperty r114 = EffectProperty.TranslationX;
        Float r115 = Float.valueOf(-0.4f);
        Float r105 = Float.valueOf(1.0f);
        Pair[] r116 = {TuplesKt.to(0L, r115), TuplesKt.to(50L, r115), TuplesKt.to(600L, r105)};
        Direction r106 = Direction.RightToLeft;
        List r107 = CollectionsKt.mutableListOf(new qma.b[]{a("old_text_exit", r100, CollectionsKt.listOf(new i[]{b(r104, r103, (Pair[]) Arrays.copyOf(r111, 2)), b(r114, r103, (Pair[]) Arrays.copyOf(r113, 2)), e(this, r116, r106)}))});
        Float r117 = Float.valueOf(0.8f);
        if (r411 <= 0.001f) goto L5;
        Float r108 = r105;
        r107.add(g("old_gradient_exit", r100, CollectionsKt.listOf(new i[]{f(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(RangesKt.coerceIn(r411, 0.0f, 0.8f))), TuplesKt.to(600L, Float.valueOf(RangesKt.coerceIn(r411, 0.0f, 0.8f)))}), b(r104, r103, (Pair[]) Arrays.copyOf(new Pair[]{TuplesKt.to(0L, r101), TuplesKt.to(600L, r102)}, 2)), b(r114, r103, (Pair[]) Arrays.copyOf(new Pair[]{TuplesKt.to(0L, r101), TuplesKt.to(600L, r112)}, 2)), e(this, new Pair[]{TuplesKt.to(0L, r115), TuplesKt.to(600L, r108)}, r106)})));
    L6:
        TextSource r109 = TextSource.New;
        Pair[] r118 = {TuplesKt.to(150L, Float.valueOf(0.03f)), TuplesKt.to(1400L, r101)};
        Pair[] r119 = {TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(1250L, r108)};
        Direction r120 = Direction.LeftToRight;
        List r121 = CollectionsKt.mutableListOf(new qma.b[]{a("new_text_enter_base", r109, CollectionsKt.listOf(new i[]{k(this, r118), e(this, r119, r120)})), g("new_text_enter", r109, CollectionsKt.listOf(new i[]{f(this, new Pair[]{TuplesKt.to(0L, r117), TuplesKt.to(750L, r117), TuplesKt.to(1450L, r101)}), k(this, new Pair[]{TuplesKt.to(150L, Float.valueOf(0.03f)), TuplesKt.to(1400L, r101)}), e(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(1250L, r108)}, r120)}))});
        if (r410 == false) goto L10;
        r107.add(h("exit_indicator", "exitScanIndicator", r106, 600, -0.7f, 1.0f));
        r121.add(h("enter_indicator", "enterScanIndicator", r120, 1250, -0.7f, 1.0f));
    L10:
        return new k("oui.dim_point.rewrite", r110, null, CollectionsKt.mutableListOf(new c[]{new c("rewrite", r110, CollectionsKt.plus(r107, r121))}), 10);
    L5:
        r108 = r105;
        goto L6
    }

    public static qma.b.C7362b a(String r100, TextSource r101, List r102) {
        return new qma.b.C7362b(r100, r101, e.b.f533956a, BlendSpec.SRC_OVER, r102);
    }

    public static i b(EffectProperty r100, qma.a r101, Pair... r110) {
        ArrayList r102 = new ArrayList(r110.length);
        int r103 = r110.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        Pair r105 = r110[r104];
        r102.add(new f(((Number) r105.getFirst()).longValue(), new d.a(((Number) r105.getSecond()).floatValue())));
        r104 = r104 + 1;
        goto L3
    L6:
        return new i(r100, r102, r101);
    }

    public static i c(EffectProperty r100, qma.a r101, Pair... r110) {
        ArrayList r102 = new ArrayList(r110.length);
        int r103 = r110.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        Pair r105 = r110[r104];
        r102.add(new f(((Number) r105.getFirst()).longValue(), new d.b(((Number) r105.getSecond()).floatValue())));
        r104 = r104 + 1;
        goto L3
    L6:
        return new i(r100, r102, r101);
    }

    public static i e(a r100, Pair[] r101, Direction r110) {
        r100.getClass();
        EffectProperty r102 = EffectProperty.GradientAlphaScan;
        ArrayList r103 = new ArrayList(r101.length);
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        Pair r106 = r101[r105];
        r103.add(new f(((Number) r106.getFirst()).longValue(), new d.b(((Number) r106.getSecond()).floatValue())));
        r105 = r105 + 1;
        goto L3
    L6:
        return new i(r102, r103, f538615b, new j.b(r110, r110));
    }

    public static qma.b.C7362b g(String r100, TextSource r101, List r102) {
        return new qma.b.C7362b(r100, r101, new e.a(b.f538617a, b.f538618b), BlendSpec.SCREEN, r102);
    }

    public static qma.b.a h(String r100, String r101, Direction r110, long r111, float r112, float r113) {
        d.f r102 = new d.f(r112);
        d.f r114 = new d.f(r113);
        List r115 = CollectionsKt.createListBuilder();
        r115.add(new f(0, new d.b(1.0f)));
        long r116 = r111 + 0;
        r115.add(new f(r116 - 1, new d.b(0.0f)));
        List r117 = CollectionsKt.build(r115);
        List r103 = CollectionsKt.createListBuilder();
        r103.add(new f(0, r102));
        r103.add(new f(r116, r114));
        List r118 = CollectionsKt.build(r103);
        return new qma.b.a(r100, r101, new h(r110), CollectionsKt.listOf(new i[]{new i(EffectProperty.Visibility, r117, qma.a.c.f533932a), new i(EffectProperty.TranslationX, r118, f538615b)}));
    }
}
